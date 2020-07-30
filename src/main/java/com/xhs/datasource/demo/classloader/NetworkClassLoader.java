package com.xhs.datasource.demo.classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author xuhan  build  2019/4/4
 */
public class NetworkClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        try {
            byte[] byteArray = this.getNetWorkClassByte(className);
            return defineClass("com.weguard.test.Test",byteArray,0,byteArray.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private byte[] getNetWorkClassByte(String name) throws IOException {
        String rootUrl = "http://localhost/class/";

        URL url = new URL(rootUrl+name+".class");
        InputStream inputStream = url.openStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int byteBuffer = 1024;
        byte[] bytes = new byte[byteBuffer];
        int size = 0;
        while((size =inputStream.read(bytes))!=-1){
            byteArrayOutputStream.write(bytes,0,size);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        NetworkClassLoader networkClassLoader = new NetworkClassLoader();
        Class clazz = networkClassLoader.findClass("Test");
        Object o = clazz.newInstance();
        System.out.println(o.toString());

    }


}
