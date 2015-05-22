/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Zeming
 */
public class IoUtil {
     // 用字节流来复制文件
    public static void copyFileBySteam(String sourePath, String destPath) {
        try {
            // 1读取文件，就是输入流，inputStream
            File file = new File(sourePath);
            if (file.exists()) {
                // 1 如果文件存在，则创建输入的字节流，读取文件的内容到程序中，是输入流
                // FileInputStream fin = new FileInputStream(sourePath);
                FileInputStream fin = new FileInputStream(file);
                // 创建输出流，就是输出到文件中，写文件内容，将程序中的数据写到文件中，是输出流
                FileOutputStream fout = new FileOutputStream(destPath);
                // 2 创建一个临时变量
                int temp = 0;
                // 3 fin.read()返回文件的输入流的数据
                // 先将读取的数据赋值给temp,如果temp！=-1，表示还有数据，
                // 就将temp先写到文件中
                while ((temp = fin.read()) != -1) {
                    fout.write(temp);
                }
                // 5 关闭资源
                fout.flush();// 强制清空剩下的数据
                fout.close();
                fin.close();
            } else {
                System.out.println(sourePath + ">>>文件不存在!");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("复制失败");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("复制失败");
        }
        System.out.println("复制成功");
    }
}
