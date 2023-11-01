package com.jkf.channel.gateway.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * The class ClassUtils.
 * <p>
 * Description:
 *
 * @author: wuweikun
 * @since: 2020/04/18
 */

public class ClassUtils {

    private static final Logger LOG = LoggerFactory.getLogger(ClassUtils.class);

    /**
     * @Description: 根据一个接口返回该接口的所有类
     * @param clazz
     *            接口
     * @return List<Class> 实现接口的所有类
     * @author LiYaoHua
     * @date 2012-4-5 上午11:22:24
     */
    public static <T> Class<T> getClassByInterface(Class<T> clazz) {
        Class<T> returnClass = null;

        //判断是不是接口,不是接口不作处理  
        if (clazz.isInterface()) {
            if (List.class.equals(clazz)) {
                returnClass = (Class<T>) ArrayList.class;
            } else if (Set.class.equals(clazz)) {
                returnClass = (Class<T>) HashSet.class;
            } else if (Map.class.equals(clazz)) {
                returnClass = (Class<T>) HashMap.class;
            }
            if (null == returnClass) {
                try {
                    returnClass = getClass(clazz.getPackage().getName(), clazz);//获得当前包以及子包下的所有类  
                } catch (Exception e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
        return returnClass;
    }

    /**
     *
     * @Description: 根据包名获得该包以及子包下的所有类不查找jar包中的
     * @param packageName
     *            包名
     * @return List<Class> 包下所有类
     * @author LiYaoHua
     * @date 2012-4-5 上午11:26:48
     */
    public static <T> Class<T> getClass(String packageName, Class<T> clazz) throws ClassNotFoundException, IOException {
        Class<T> target = null;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        while (null == target && null != classLoader) {
            String path = packageName.replace(".", "/");
            Enumeration<URL> resources = classLoader.getResources(path);
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                target = getClass(new File(resource.getFile()), packageName, clazz);
                if (null != target) {
                    break;
                }
            }
            classLoader = classLoader.getParent();
        }
        return target;
    }

    private static <T> Class<T> getClass(File directory, String packageName, Class<T> clazz) throws ClassNotFoundException {
        Class<T> target = null;
        if (!directory.exists()) {
            return target;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory() && !file.getName().contains(".")) {
                target = getClass(file, packageName + "." + file.getName(), clazz);
            } else if (file.getName().endsWith(".class")) {
                Class<?> tmp = Class.forName(packageName + "." + file.getName().substring(0, file.getName().length() - 6));
                if (!tmp.isInterface() && clazz.isAssignableFrom(tmp)) {
                    target = (Class<T>) tmp;
                }
            }
            if (null != target) {
                break;
            }
        }
        return target;
    }
}
