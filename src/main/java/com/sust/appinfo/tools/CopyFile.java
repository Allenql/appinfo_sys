package com.sust.appinfo.tools;

import java.io.*;

/**
 * 拷贝文件
 */
public class CopyFile {

    public static boolean copyFile(File targetFile, String fileName) {
        int bytesum = 0;
        int byteread = 0;
        File oldfile = targetFile;
        if (oldfile.exists()) { //文件存在时
            InputStream inStream = null; //读入原文件
            FileOutputStream fs = null;
            try {
                inStream = new FileInputStream(targetFile);
                fs = new FileOutputStream("D:\\毕业设计-app信息管理平台\\appinfo_sys\\src\\main\\resources\\static\\uploadfiles\\" + fileName);
                byte[] buffer = new byte[1444];
                int length;
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; //字节数 文件大小
//                        System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                return true;
            } catch (Exception e) {
                System.out.println("复制单个文件操作出错");
                e.printStackTrace();
                return false;
            } finally {
                try {
                    fs.close();
                    inStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return false;
    }
}
