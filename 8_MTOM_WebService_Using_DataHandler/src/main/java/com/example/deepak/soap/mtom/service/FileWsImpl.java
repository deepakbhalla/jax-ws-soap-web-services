package com.example.deepak.soap.mtom.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

public class FileWsImpl implements FileWs {

    @Override
    public void upload(DataHandler attachment) {

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = attachment.getInputStream();
            outputStream = new FileOutputStream(new File("C:\\Temp\\uploaded\\uploaded.jpg"));
            byte[] b = new byte[10000];
            int byteRead = 0;
            while ((byteRead = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, byteRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public DataHandler download() {
        return new DataHandler(new FileDataSource(new File("C:\\Temp\\uploaded\\uploaded.jpg")));
    }

}
