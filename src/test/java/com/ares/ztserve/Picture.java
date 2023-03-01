package com.ares.ztserve;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Base64;


public class Picture {


    public static void main(String[] args) throws Exception {
        //数据库连接
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@192.168.0.210:1521/HCPPROD";
        String user = "hcp";
        String password = "hcp";
        Connection conn = DriverManager.getConnection(url, user, password);

        //读取本地图片
        File file1 = new File("C:\\TEMP\\ZT40_01.jpg");
        //得到大小
        int length = (int) file1.length();
        //获得文件输入流
        InputStream input = new FileInputStream(file1);
        String imageBase = getImageBase("C:\\TEMP\\ZT40_01.jpg");
        System.out.println(imageBase);

        //数据库插入图片
        String sql = "insert into mail_images(img_id, img_name, img_desc, img_type, img,img_base64)   VALUES(?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, 100);
        stmt.setString(2, "ZT40_01");
        stmt.setString(3, "资通40周年");
        stmt.setString(4, ".jpg");

        stmt.setBinaryStream(5, input, length);
        stmt.setString(6, imageBase);

        stmt.execute();


    }

    public static String getImageBase(String src) throws Exception {

        File file = new File("C:\\TEMP\\ZT40_01.jpg");
        InputStream in = null;
        byte[] data = null;
        try {
            in = Files.newInputStream(file.toPath());
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(data);
    }
}