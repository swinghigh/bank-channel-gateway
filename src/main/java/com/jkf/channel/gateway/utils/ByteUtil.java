package com.jkf.channel.gateway.utils;


/**
 * 提交
 *
 * @author generator
 * @date 2021/04/28
 */
@SuppressWarnings("all")
public class ByteUtil {
    public ByteUtil() {
    }

    public static String hexToStringGBK(String s) {
        byte[] baKeyword = new byte[s.length() / 2];

        for (int i = 0; i < baKeyword.length; ++i) {
            try {
                baKeyword[i] = (byte) (255 & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception var5) {
                var5.printStackTrace();
                return "";
            }
        }

        try {
            s = new String(baKeyword, "UTF-8");
            return s;
        } catch (Exception var4) {
            var4.printStackTrace();
            return "";
        }
    }

    public static byte[] hexStr2Bytes(String src) throws Exception {
        int l = src.length() / 2;
        byte[] ret = new byte[l];

        for (int i = 0; i < l; ++i) {
            int m = i * 2 + 1;
            int n = m + 1;
            ret[i] = uniteBytes(src.substring(i * 2, m), src.substring(m, n));
        }

        return ret;
    }

    private static byte uniteBytes(String src0, String src1) throws Exception {
        byte b0 = Byte.decode(appendField(new Object[]{"0x", src0}));
        b0 = (byte) (b0 << 4);
        byte b1 = Byte.decode(appendField(new Object[]{"0x", src1}));
        byte ret = (byte) (b0 | b1);
        return ret;
    }

    public static String byte2HexStr(byte[] b) throws Exception {
        String hs = "";
        String stmp = "";

        for (int n = 0; n < b.length; ++n) {
            stmp = Integer.toHexString(b[n] & 255);
            hs = appendField(new Object[]{hs, stmp.length() == 1 ? appendField(new Object[]{"0", stmp}) : stmp});
        }

        return hs.toUpperCase();
    }

    public static byte[] bytesXOR(byte[] src, byte[] src1) {
        try {
            int length = src.length;
            if (length != src1.length) {
                return null;
            } else {
                byte[] result = new byte[length];

                for (int i = 0; i < length; ++i) {
                    result[i] = byteXOR(src[i], src1[i]);
                }

                return result;
            }
        } catch (Exception var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public static byte byteXOR(byte src, byte src1) throws Exception {
        return (byte) (src & 255 ^ src1 & 255);
    }

    public static String parseByte2HexStr(byte[] buf) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < buf.length; ++i) {
            String hex = Integer.toHexString(buf[i] & 255);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }

            sb.append(hex.toUpperCase());
        }

        return sb.toString();
    }

    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        } else {
            byte[] result = new byte[hexStr.length() / 2];

            for (int i = 0; i < hexStr.length() / 2; ++i) {
                int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
                int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
                result[i] = (byte) (high * 16 + low);
            }

            return result;
        }
    }
    public static String appendField(Object... params) {
        StringBuffer sbf = new StringBuffer();
        Object[] var5 = params;
        int var4 = params.length;
        for(int var3 = 0; var3 < var4; ++var3) {
            Object str = var5[var3];
            sbf.append(str);
        }
        return sbf.toString();
    }
}
