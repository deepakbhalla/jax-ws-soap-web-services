package com.example.deepak.soap.mtom.server.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

/**
 * A web service endpoint implementation that demonstrates the usage of MTOM
 * (Message Transmission Optimization Mechanism).
 * 
 * @author www.codejava.net
 *
 */
@WebService
@MTOM(enabled = true, threshold = 10240)
public class FileTransferer {

    @WebMethod
    public void upload(String fileName, byte[] imageBytes) {

        String filePath = "c:/Temp/Test/Server/Upload/" + fileName;

        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            BufferedOutputStream outputStream = new BufferedOutputStream(fos);
            outputStream.write(imageBytes);
            outputStream.close();

            System.out.println("SERVER | UPLOAD | Received file: " + filePath);

        } catch (IOException ex) {
            System.err.println(ex);
            throw new WebServiceException(ex);
        }
    }

    @WebMethod
    public byte[] download(String fileName) {
        String filePath = "c:/Temp/Test/Server/Download/" + fileName;
        System.out.println("SERVER | DOWNLOAD | Sending file: " + filePath);

        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream inputStream = new BufferedInputStream(fis);
            byte[] fileBytes = new byte[(int) file.length()];
            inputStream.read(fileBytes);
            inputStream.close();

            return fileBytes;
        } catch (IOException ex) {
            System.err.println(ex);
            throw new WebServiceException(ex);
        }
    }
}