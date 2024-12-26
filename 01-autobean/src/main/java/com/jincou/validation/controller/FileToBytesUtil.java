package com.jincou.validation.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

import javax.swing.filechooser.FileSystemView;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @author zhouguilong6
 * @date 2024/12/23 19:25
 */
public class FileToBytesUtil{
    /**
     * 将Byte数组转换成文件
     *
     * @param bytes    byte数组
     * @param filePath 文件路径  默认桌面 (地址要用 \\ 结尾)
     * @param fileName 文件名   默认为格式化后的当前时间 (test.pdf)
     */
    public static void fileToBytes(byte[] bytes, String filePath, String fileName) {

        if (StrUtil.isBlank(filePath)) {
            //文件默认存放到桌面
            filePath = FileSystemView.getFileSystemView().getHomeDirectory().getPath() + "\\";
        }

        if (StrUtil.isBlank(fileName)) {
            //文件类型根据数据情况自定义更改
            String type = ".pdf";

            //文件名称默认为当前时间
            fileName = DateUtil.date().toString("MM月dd日HH时mm分ss秒") + type;
        }

        String name = filePath + fileName;

        System.out.println("文件全路径:  " + name);

        //文件夹不存在则生成
        File file = new File(name);
        //文件夹不存在则生成
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        //把数组写入文件
        try (FileOutputStream fos = new FileOutputStream(file);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
