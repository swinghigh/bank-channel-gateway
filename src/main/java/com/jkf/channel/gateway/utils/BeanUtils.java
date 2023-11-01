package com.jkf.channel.gateway.utils;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.text.DecimalFormat;
import java.util.*;

/**
 * The class BeanUtils.
 * <p>
 * Description:
 *
 * @author: wuweikun
 * @since: 2020/04/17
 */

public class BeanUtils {

    private static final Logger LOG = LoggerFactory.getLogger(BeanUtils.class);

    /**
     * 判断对象是否基本数据类型与封装类
     * 
     * @param obj
     * @return
     */
    public static boolean isPrimitive(Object obj) {
        if (null == obj) {
            return false;
        }

        if (obj.getClass().isPrimitive() || obj instanceof String) {
            return true;
        }

        Object type = getPropertyValue(obj, "TYPE");
        if (null != type && type instanceof Class) {
            Class<?> classType = (Class<?>) type;
            if (classType.isPrimitive()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 默认格式化器缓存.
     */
    private static Map<Class<?>, Formatter> FORMATTER_MAP = new HashMap<Class<?>, Formatter>();

    // 转换器
    private static Map<Class<?>, Converter> CONVERTER_MAP = new HashMap<Class<?>, Converter>();

    static {
        // 默认使用Apache的转换器
        ConvertUtilsBean convertUtilsBean = BeanUtilsBean.getInstance().getConvertUtils();
        try {
            Field field = ConvertUtilsBean.class.getDeclaredField("converters");
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Map<Class<?>, Converter> beanUtilsMap = (Map<Class<?>, Converter>) field.get(convertUtilsBean);
            CONVERTER_MAP.putAll(beanUtilsMap);
        } catch (Exception e) {
            LOG.error("获取类ConvertUtilsBean的属性converters异常！", e);
        }
    }

    /**
     * 注册转换器
     *
     * @param converter
     * @param targetType
     */
    public static void register(Converter converter, Class<?> targetType) {
        CONVERTER_MAP.put(targetType, converter);
    }

    /**
     * 获取类的属性
     *
     * @param clazz
     * @return
     */
    public static String[] getPropertyNames(Class clazz) {
        String[] names = null;
        PropertyDescriptor[] pds = org.springframework.beans.BeanUtils.getPropertyDescriptors(clazz);
        if (null != pds && pds.length > 0) {
            List<String> list = new ArrayList<String>();
            names = new String[pds.length];
            for (int i = 0; i < pds.length; i++) {
                String name = pds[i].getName();
                if ("class".equals(name)) {
                    continue;
                }
                try {
                    clazz.getDeclaredField(name);
                } catch (SecurityException e) {
                    continue;
                } catch (NoSuchFieldException e) {
                    continue;
                }
                list.add(name);
            }
            names = list.toArray(new String[list.size()]);
        }
        return names;
    }

    /**
     * 实例化一个对象
     *
     * @param clazz
     *            类
     *
     * @param args
     *            构造函数
     *
     * @return
     */
    public static <T> T newInstance(Class<T> clazz, Object... args) {
        T result = null;
        try {
            if (clazz.isInterface()) {
                Class<T> implClazz = ClassUtils.getClassByInterface(clazz);
                if (null == implClazz) {
                    return result;
                }
                clazz = implClazz;
            }
            Constructor<T> constructor = null;
            if (null == args || args.length == 0) {
                constructor = clazz.getDeclaredConstructor();
            } else {
                Class<?>[] argClasses = new Class<?>[args.length];
                for (int i = 0; i < args.length; i++) {
                    Object arg = args[i];
                    if (null == arg) {
                        argClasses[i] = String.class;
                    } else {
                        argClasses[i] = arg.getClass();
                    }
                }
                constructor = clazz.getDeclaredConstructor(argClasses);
            }
            if (null != constructor) {
                if (!constructor.isAccessible()) {
                    constructor.setAccessible(true);
                }
                result = constructor.newInstance(args);
            }
        } catch (Exception e) {
            LOG.error("类" + clazz + "调用构造器异常！", e);
        }
        return result;
    }

    /**
     * 对目标对象设值
     *
     * @param target
     *            目标对象
     *
     * @param name
     *            目标属性
     *
     * @param value
     *            目标值
     *
     */
    public static void copyProperty(Object target, String name, Object value) {
        copyProperty(target, name, value, null, null, null, null, false);
    }

    /**
     * 对目标对象设值
     *
     * @param target
     *            目标对象
     *
     * @param name
     *            目标属性名
     *
     * @param value
     *            目标值
     *
     * @param formattersByClass
     *            根据类型格式化器
     *
     * @param formattersByName
     *            根据名称格式化器
     *
     * @param isDeep
     *            是否深拷贝
     *
     */
    public static void copyProperty(Object target, String name, Object value, Map<Class, Formatter> formattersByClass, Map<String, Formatter> formattersByName, Map<Class, Converter> convertersByClass,
                                    Map<String, Converter> convertersByName, boolean isDeep) {
        copyProperty(target, name, value, formattersByClass, formattersByName, convertersByClass, convertersByName, isDeep, true);
    }

    /**
     * 对目标对象设值
     *
     * @param target
     *            目标对象
     *
     * @param name
     *            目标属性名
     *
     * @param value
     *            目标值
     *
     * @param formattersByClass
     *            根据类型格式化器
     *
     * @param formattersByName
     *            根据名称格式化器
     *
     * @param isDeep
     *            是否深拷贝
     *
     * @param isCopyEmpty
     *            是否复制空值
     *
     */
    public static void copyProperty(Object target, String name, Object value, Map<Class, Formatter> formattersByClass, Map<String, Formatter> formattersByName, Map<Class, Converter> convertersByClass,
                                    Map<String, Converter> convertersByName, boolean isDeep, boolean isCopyEmpty) {
        if (null == target || "class".equals(name)) {
            return;
        }
        if (!isCopyEmpty && (null == value || StringUtils.isBlank(value.toString()))) {
            return;
        }

        Object innerObject = target;

        // 点下标，用于层级式的数据结构
        int dotIndex = -1;
        if ((dotIndex = name.indexOf(".")) > -1) {

            // 内部参数名
            String innerName = name.substring(0, dotIndex);

            boolean isMap = innerObject instanceof Map;

            // 获取内部对象值
            innerObject = BeanUtils.getPropertyValue(innerObject, innerName);

            // 对于Map类型如果不存在key，则value设置为Map
            if (null == innerObject) {
                if (isMap) {
                    innerObject = new HashMap<String, Object>();
                    ((Map) target).put(innerName, innerObject);
                } else {
                    PropertyDescriptor pd = org.springframework.beans.BeanUtils.getPropertyDescriptor(innerObject.getClass(), innerName);
                    if (null != pd) {
                        innerObject = BeanUtils.newInstance(pd.getPropertyType());
                    }
                }
            }

            // 获取内部字段名
            name = name.substring(dotIndex + 1);
            copyProperty(innerObject, name, value, formattersByClass, formattersByName, convertersByClass, convertersByName, isDeep, isCopyEmpty);
            return;
        }

        if (target instanceof Map) {
            ((Map) target).put(name, value);
        } else {

            PropertyDescriptor pd = org.springframework.beans.BeanUtils.getPropertyDescriptor(target.getClass(), name);
            if (null == pd) {
                return;
            }
            if (null != value) {
                Class targetType = pd.getPropertyType();

                // 数据转换
                value = convertValue(name, value, formattersByClass, formattersByName, convertersByClass, convertersByName, isDeep, value.getClass(), targetType);
            }
            Method writeMethod = pd.getWriteMethod();
            if (null != writeMethod) {
                try {
                    writeMethod.invoke(target, value);
                } catch (Exception e) {
                    LOG.error("Could not copy propertie=" + name + ",value=" + value + " to target ", e);
                }
            } else {
                Field field = null;
                try {
                    field = target.getClass().getDeclaredField(name);
                } catch (NoSuchFieldException e) {
                    LOG.error("class:" + target.getClass() + " has not field:" + name, e);
                    return;
                }
                if (!Modifier.isFinal(field.getModifiers()) || (Modifier.isFinal(field.getModifiers()) && null == value)) {
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    try {
                        field.set(target, value);
                    } catch (Exception e) {
                        LOG.error("Could not copy properties from source to target", e);
                    }
                }
            }
        }

    }

    /**
     * 对象属性拷贝(浅)
     *
     * @param source
     *            源对象
     *
     * @param target
     *            目标对象
     */
    public static void copyProperties(Object source, Object target) {
        copyProperties(source, target, false);
    }

    /**
     * 对象属性拷贝
     *
     * @param source
     *            源对象
     *
     * @param target
     *            目标对象
     *
     * @param isDeep
     *            是否深拷贝
     */
    public static void copyProperties(Object source, Object target, boolean isDeep) {
        copyProperties(source, target, null, isDeep);
    }

    /**
     * 对象属性拷贝
     *
     * @param source
     *            源对象
     *
     * @param target
     *            目标对象
     *
     * @param ignoreProperties
     *            排除属性
     *
     * @param isDeep
     *            是否深拷贝
     *
     */
    public static void copyProperties(Object source, Object target, String[] ignoreProperties, boolean isDeep) {
        copyProperties(source, target, ignoreProperties, null, null, null, null, false);
    }

    /**
     * 对象属性拷贝（使用转换器）
     *
     * @param source
     *            源对象
     *
     * @param target
     *            目标对象
     *
     * @param ignoreProperties
     *            排除属性
     *
     * @param formattersByClass
     *            格式化器
     *
     * @param isDeep
     *            是否深拷贝
     */
    public static void copyProperties(Object source, Object target, String[] ignoreProperties, Map<Class, Formatter> formattersByClass, Map<String, Formatter> formattersByName,
                                      Map<Class, Converter> convertersByClass, Map<String, Converter> convertersByName, boolean isDeep) {
        copyProperties(source, target, ignoreProperties, formattersByClass, formattersByName, convertersByClass, convertersByName, isDeep, true);
    }

    /**
     * 对象属性拷贝（使用转换器）
     *
     * @param source
     *            源对象
     *
     * @param target
     *            目标对象
     *
     * @param ignoreProperties
     *            排除属性
     *
     * @param formattersByClass
     *            格式化器
     *
     * @param isDeep
     *            是否深拷贝
     *
     * @param isCopyEmpty
     *            是否拷贝空值
     *
     */
    public static void copyProperties(Object source, Object target, String[] ignoreProperties, Map<Class, Formatter> formattersByClass, Map<String, Formatter> formattersByName,
                                      Map<Class, Converter> convertersByClass, Map<String, Converter> convertersByName, boolean isDeep, boolean isCopyEmpty) {
        if (null == source || null == target) {
            return;
        }

        if (target instanceof Collection) {
            if (!((Collection) target).isEmpty()) {
                for (Object item : (Collection) target) {
                    copyProperties(source, item, ignoreProperties, formattersByClass, formattersByName, convertersByClass, convertersByName, isDeep, isCopyEmpty);
                }
            }
        } else {
            if (source instanceof Map) {
                for (Object key : ((Map) source).keySet()) {
                    String name = (String) key;
                    Object value = ((Map) source).get(key);

                    // 设值
                    copyProperty(target, name, value, formattersByClass, formattersByName, convertersByClass, convertersByName, isDeep, isCopyEmpty);
                }
            } else {
                Class<?> actualEditable = source.getClass();
                PropertyDescriptor[] pds = org.springframework.beans.BeanUtils.getPropertyDescriptors(actualEditable);
                List<String> ignoreList = (ignoreProperties != null) ? Arrays.asList(ignoreProperties) : null;

                for (PropertyDescriptor pd : pds) {
                    String name = pd.getName();
                    if ("class".equals(name) || (ignoreProperties != null && ignoreList.contains(name))) {
                        continue;
                    }

                    Object value = getSourceValue(source, name);

                    // 设值
                    copyProperty(target, name, value, formattersByClass, formattersByName, convertersByClass, convertersByName, isDeep, isCopyEmpty);
                }
            }
        }
    }

    /**
     * 对目标对象设值
     *
     * @param target
     *            目标对象
     *
     * @param name
     *            目标属性
     *
     * @param value
     *            目标值
     *
     */
    public static void copyPropertyIngoreEmpty(Object target, String name, Object value) {
        copyPropertyIngoreEmpty(target, name, value, null, null, null, null, false);
    }

    /**
     * 对目标对象设值
     *
     * @param target
     *            目标对象
     *
     * @param name
     *            目标属性名
     *
     * @param value
     *            目标值
     *
     * @param formattersByClass
     *            根据类型格式化器
     *
     * @param formattersByName
     *            根据名称格式化器
     *
     * @param isDeep
     *            是否深拷贝
     *
     */
    public static void copyPropertyIngoreEmpty(Object target, String name, Object value, Map<Class, Formatter> formattersByClass, Map<String, Formatter> formattersByName,
                                               Map<Class, Converter> convertersByClass, Map<String, Converter> convertersByName, boolean isDeep) {
        copyProperty(target, name, value, formattersByClass, formattersByName, convertersByClass, convertersByName, isDeep, false);
    }

    /**
     * 获取对象的属性值
     *
     * @param obj
     *            目标对象
     *
     * @param propertyName
     *            属性名称
     *
     * @return
     */
    public static Object getPropertyValue(Object obj, String propertyName) {
        Object value = null;
        if (null == obj || StringUtils.isBlank(propertyName)) {
            return value;
        }

        if (propertyName.indexOf(".") > -1) {
            String[] propertyNames = propertyName.split("\\.");
            for (String name : propertyNames) {
                obj = getPropertyValue(obj, name);
            }
            value = obj;
        } else {
            if (obj instanceof Map) {
                value = ((Map) obj).get(propertyName);
            } else {
                Class<? extends Object> clazz = obj.getClass();
                PropertyDescriptor pd = org.springframework.beans.BeanUtils.getPropertyDescriptor(clazz, propertyName);
                Method readMethod = null;
                if (null != pd) {
                    readMethod = pd.getReadMethod();
                }
                if (null != readMethod) {
                    try {
                        if (!readMethod.isAccessible()) {
                            readMethod.setAccessible(true);
                        }
                        value = readMethod.invoke(obj, null);
                    } catch (Exception e) {
                        LOG.error("类" + clazz + "调用方法" + readMethod.getName() + "异常！", e);
                    }
                } else {
                    Field[] fields = clazz.getDeclaredFields();
                    if (null != fields && fields.length > 0) {
                        for (Field field : fields) {
                            if (propertyName.equals(field.getName())) {
                                if (!field.isAccessible()) {
                                    field.setAccessible(true);
                                }
                                try {
                                    value = field.get(obj);
                                } catch (IllegalArgumentException e) {
                                    LOG.error("属性：" + field + "参数非法！", e);
                                } catch (IllegalAccessException e) {
                                    LOG.error("属性：" + field + "访问非法！", e);
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }

        return value;
    }

    /**
     * 数据转换
     *
     * @param source
     *            源数据
     *
     * @param targetType
     *            目标类型
     *
     * @return
     */
    public static <T> T convert(Object source, Class<? extends T> targetType) {
        T result = null;
        if (null == targetType || null == source) {
            return result;
        }
        Converter converter = CONVERTER_MAP.get(targetType);
        if (null != converter) {
            result = (T) converter.convert(targetType, source);
        } else {
            result = (T) newInstance(targetType, null);
            copyProperties(source, result);
        }
        return result;
    }

    /**
     * 克隆对象(深)
     *
     * @param source
     * @return
     */
    public static <T> T deepClone(T source) {
        return clone(source, true);
    }

    /**
     * 克隆对象(浅)
     *
     * @param source
     *            源对象
     *
     * @param isDeep
     *            是否深拷贝
     *
     * @return
     */
    public static <T> T clone(T source, boolean isDeep) {
        T cloneObj = null;
        if (null != source) {
            Class<? extends Object> clazz = source.getClass();
            if (clazz.isInterface()) {
                return cloneObj;
            }
            if (!ObjectUtils.isBasicDataType(clazz)) {
                if (Collection.class.isAssignableFrom(clazz)) {
                    try {
                        Collection collection = (Collection) source;
                        Collection cloneCol = newCollection(collection);
                        if (null != cloneCol) {
                            Iterator it = collection.iterator();
                            if (it.hasNext()) {
                                cloneCol.add(clone(it.next(), isDeep));
                            }
                            cloneObj = (T) cloneCol;
                        }
                    } catch (Exception e) {
                        LOG.error("类" + clazz + "拷贝异常！", e);
                    }
                } else if (Map.class.isAssignableFrom(clazz)) {
                    try {
                        Constructor<?> constructor = clazz.getDeclaredConstructor();
                        if (null != constructor) {
                            if (!constructor.isAccessible()) {
                                constructor.setAccessible(true);
                            }
                            Map cloneMap = (Map) constructor.newInstance();
                            Map map = (Map) source;
                            for (Object key : map.keySet()) {
                                cloneMap.put(clone(key, isDeep), clone(map.get(key), isDeep));
                            }
                            cloneObj = (T) cloneMap;
                        }
                    } catch (Exception e) {
                        LOG.error("类" + clazz + "拷贝异常！", e);
                    }
                } else if (clazz.isArray()) {
                    Object[] sourceArray = (Object[]) source;
                    cloneObj = (T) Array.newInstance(clazz.getComponentType(), sourceArray.length);
                    Object[] cloneArray = (Object[]) cloneObj;
                    for (int i = 0; i < cloneArray.length; i++) {
                        cloneArray[i] = clone(sourceArray[i], isDeep);
                    }

                } else if (String.class.equals(clazz)) {
                    cloneObj = source;
                } else {
                    if (isDeep) {
                        try {
                            cloneObj = (T) JsonUtils.jsonToObject(JsonUtils.toJson(source), clazz);
                        } catch (Exception e) {
                            LOG.error("类" + clazz + "json转换异常！", e);
                        }
                    } else if (source instanceof Cloneable) {
                        try {
                            Method method = clazz.getMethod("clone", null);
                            cloneObj = (T) method.invoke(source, null);
                        } catch (Exception e) {
                            LOG.error("类" + clazz + "拷贝异常！", e);
                        }
                    } else {
                        try {
                            try {
                                Constructor<?> constructor = clazz.getDeclaredConstructor();
                                if (null != constructor) {
                                    if (!constructor.isAccessible()) {
                                        constructor.setAccessible(true);
                                    }
                                    cloneObj = (T) constructor.newInstance();
                                }
                            } catch (Exception e) {
                                LOG.error("类" + clazz + "调用默认构造器异常！", e);
                            }
                            if (null == cloneObj) {
                                cloneObj = (T) JsonUtils.jsonToObject(JsonUtils.toJson(source), clazz);
                            } else {
                                copyProperties(source, cloneObj);
                            }
                        } catch (Exception e) {
                            LOG.error("类" + clazz + "拷贝异常！", e);
                        }
                    }
                }
            } else {
                cloneObj = source;
            }
        }
        return cloneObj;
    }

    /**
     * 数据转换
     *
     * @param name
     *            目标属性名
     *
     * @param value
     *            目标值
     *
     * @param formattersByClass
     *            根据类型格式化器
     *
     * @param formattersByName
     *            根据名称格式化器
     *
     * @param convertersByClass
     *            根据类型转换器
     *
     * @param convertersByName
     *            根据名称转换器
     *
     * @param isDeep
     *            是否深拷贝
     *
     * @param srcType
     *            原类型
     *
     *
     *
     * @param targetType
     * @return
     */
    private static Object convertValue(String name, Object value, Map<Class, Formatter> formattersByClass, Map<String, Formatter> formattersByName, Map<Class, Converter> convertersByClass,
                                       Map<String, Converter> convertersByName, boolean isDeep, Class srcType, Class targetType) {
        if (null != value) {

            // 根据类型格式化器
            Formatter formatterByClass = null;

            // 优先取传入的格式化器
            if (null != formattersByClass && !formattersByClass.isEmpty()) {
                formatterByClass = formattersByClass.get(value.getClass());
            }
            if (null == formatterByClass) {
                formatterByClass = FORMATTER_MAP.get(value.getClass());
            }
            if (null != formatterByClass) {
                value = formatterByClass.format(value);
            }

            // 根据名称格式化器
            Formatter formatterByName = null;

            // 优先取传入的格式化器
            if (null != formattersByName && !formattersByName.isEmpty()) {
                formatterByName = formattersByName.get(name);
            }
            if (null != formatterByName) {
                value = formatterByName.format(value);
            }

            // 数据类型转换
            if (!srcType.equals(targetType) && !targetType.isAssignableFrom(srcType)) {

                // 根据类型转换器
                Converter converterByClass = null;

                // 优先取传入的格式化器
                if (null != convertersByClass && !convertersByClass.isEmpty()) {
                    converterByClass = convertersByClass.get(targetType);
                }
                if (null != converterByClass) {
                    value = converterByClass.convert(targetType, value);
                }

                // 根据名称转换器
                Converter converterByName = null;

                // 优先取传入的格式化器
                if (null != convertersByName && !convertersByName.isEmpty()) {
                    converterByName = convertersByName.get(name);
                }
                if (null != converterByName) {
                    value = converterByName.convert(targetType, value);
                }

                if (null == converterByClass && null == formatterByName) {
                    value = convert(value, targetType);
                }
            }

            if (isDeep) {
                value = deepClone(value);
            }
        }
        return value;
    }

    /**
     * 获取字段的源数据
     *
     * @param source
     *            源对象
     *
     * @param name
     *            字段名
     *
     * @return
     */
    private static Object getSourceValue(Object source, String name) {
        Object value = null;
        if (source instanceof Map) {
            if (!((Map) source).containsKey(name)) {
                return value;
            }
            value = ((Map) source).get(name);
        } else {
            PropertyDescriptor sourcePd = org.springframework.beans.BeanUtils.getPropertyDescriptor(source.getClass(), name);
            if (null == sourcePd) {
                return value;
            }
            Method readMethod = sourcePd.getReadMethod();
            if (null != readMethod) {
                try {
                    value = readMethod.invoke(source, null);
                } catch (Exception e) {
                    LOG.error("Could not get property:" + name + " from class:" + source.getClass(), e);
                    return value;
                }
            } else {
                Field sourceField = null;
                try {
                    sourceField = source.getClass().getDeclaredField(name);
                } catch (Exception e) {
                    LOG.error("Could not get property:" + name + " from class:" + source.getClass(), e);
                    return value;
                }
                if (!sourceField.isAccessible()) {
                    sourceField.setAccessible(true);
                }
                try {
                    value = sourceField.get(source);
                } catch (Exception e) {
                    LOG.error("Could not get property:" + name + " from class:" + source.getClass(), e);
                    return value;
                }
            }
        }
        return value;
    }

    /**
     * 新建一个空的集合
     *
     * @param collection
     * @return
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private static Collection<?> newCollection(Collection<?> collection) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Collection<?> resultCol = null;
        Class<? extends Object> clazz = collection.getClass();
        if (clazz.isInterface()) {
            return resultCol;
        }
        Constructor<?> constructor = clazz.getDeclaredConstructor(Integer.TYPE);
        if (null != constructor) {
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            resultCol = (Collection<?>) constructor.newInstance(collection.size());
        } else {
            constructor = clazz.getDeclaredConstructor();
            if (null != constructor) {
                if (!constructor.isAccessible()) {
                    constructor.setAccessible(true);
                }
                resultCol = (Collection<?>) constructor.newInstance();
            }
        }
        return resultCol;
    }

    private interface Formatter {

        Object format(Object source);
    }

    private class AmountFormatter implements Formatter {

        private static final String DEFAULT_FORMAT = "0.00";

        // 格式
        private String format = DEFAULT_FORMAT;

        /**
         * 时间转换
         */
        @Override
        public Object format(Object source) {
            Object dest = null;
            DecimalFormat df = new DecimalFormat(format);
            if (null != source) {
                dest = df.format(source);
            }
            return dest;
        }
    }
}
