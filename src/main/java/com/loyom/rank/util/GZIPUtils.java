package com.loyom.rank.util;
import java.io.ByteArrayInputStream;  
import java.io.ByteArrayOutputStream;  
import java.io.IOException;  
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.zip.GZIPInputStream;  
import java.util.zip.GZIPOutputStream;  
  


  
  
/** 
 *  
 * @author wenqi5 
 *  
 */  
public class GZIPUtils {  
  
    public static final String GZIP_ENCODE_UTF_8 = "UTF-8";  
  
    public static final String GZIP_ENCODE_ISO_8859_1 = "ISO-8859-1";  
  
    /** 
     * 字符串压缩为GZIP字节数组 
     *  
     * @param str 
     * @return 
     */  
    public static byte[] compress(String str) {  
        return compress(str, GZIP_ENCODE_UTF_8);  
    }  
  
    /** 
     * 字符串压缩为GZIP字节数组 
     *  
     * @param str 
     * @param encoding 
     * @return 
     */  
    public static byte[] compress(String str, String encoding) {  
        if (str == null || str.length() == 0) {  
            return null;  
        }  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        GZIPOutputStream gzip;  
        try {  
            gzip = new GZIPOutputStream(out);  
            gzip.write(str.getBytes(encoding));  
            gzip.close();  
        } catch (IOException e) {  
          /*  ApiLogger.error("gzip compress error.", e); */ 
        }  
        return out.toByteArray();  
    }  
  
    /** 
     * GZIP解压缩 
     *  
     * @param bytes 
     * @return 
     */  
    public static byte[] uncompress(byte[] bytes) {  
        if (bytes == null || bytes.length == 0) {  
            return null;  
        }  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);  
        try {  
            GZIPInputStream ungzip = new GZIPInputStream(in);  
            byte[] buffer = new byte[256];  
            int n;  
            while ((n = ungzip.read(buffer)) >= 0) {  
                out.write(buffer, 0, n);  
            }  
        } catch (IOException e) {  
            /*ApiLogger.error("gzip uncompress error.", e);*/  
        }  
  
        return out.toByteArray();  
    }  
  
    /** 
     *  
     * @param bytes 
     * @return 
     */  
    public static String uncompressToString(byte[] bytes) {  
        return uncompressToString(bytes, GZIP_ENCODE_UTF_8);  
    }  
  
    /** 
     *  
     * @param bytes 
     * @param encoding 
     * @return 
     */  
    public static String uncompressToString(byte[] bytes, String encoding) {  
        if (bytes == null || bytes.length == 0) {  
            return null;  
        }  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);  
        try {  
            GZIPInputStream ungzip = new GZIPInputStream(in);  
            byte[] buffer = new byte[256];  
            int n;  
            while ((n = ungzip.read(buffer)) >= 0) {  
                out.write(buffer, 0, n);  
            }  
            return out.toString(encoding);  
        } catch (IOException e) {  
            /*ApiLogger.error("gzip uncompress to string error.", e); */ 
        }  
        return null;  
    }  
  
    public static void main(String[] args) throws UnsupportedEncodingException {  
        String str = "压缩后字符串";  
        String keyWord = URLDecoder.decode(str, "utf-8");
        System.out.println(keyWord);
        System.out.println("原长度：" + str.length());  
        System.out.println("压缩后字符串：" + new String(GZIPUtils.compress(str)));  
//        System.out.println("解压缩后字符串：" + StringUtils.newStringUtf8(GZIPUtils.uncompress(str.getBytes())));  
        System.out.println("解压缩后字符串：" + GZIPUtils.uncompressToString(new String(GZIPUtils.compress(str)).getBytes(),"utf-8"));  
    }  
} 