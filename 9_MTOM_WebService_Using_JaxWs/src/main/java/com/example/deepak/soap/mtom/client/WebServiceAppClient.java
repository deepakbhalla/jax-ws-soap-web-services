package com.example.deepak.soap.mtom.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.ws.soap.MTOMFeature;

import com.example.deepak.soap.mtom.client.wsproxies.FileTransferer;
import com.example.deepak.soap.mtom.client.wsproxies.FileTransfererService;

/**
 * A client program that demonstrates how to use MTOM to optimize binary data
 * transfer with JAX-WS web services.
 * 
 * @author www.codejava.net
 *
 */
public class WebServiceAppClient {

    private static final String CLIENT_UPLOAD_DIRECTORY = "C:\\Temp\\Test\\Client\\Upload\\";
    private static final String CLIENT_DOWNLOAD_DIRECTORY = "C:\\Temp\\Test\\Client\\Download\\";
    private static final String IMAGE_TO_BE_UPLOADED = "sparrow_image.jpg";
    private static final String IMAGE_TO_BE_DOWNLOADED = "lion_image.jpg";

    public static void main(String[] args) {
        // connects to the web service
        FileTransfererService service = new FileTransfererService();
        FileTransferer port = service.getFileTransfererPort(new MTOMFeature(10240));

        // Upload Image
        upload(port, IMAGE_TO_BE_UPLOADED);
        // Download Image
        download(port, IMAGE_TO_BE_DOWNLOADED);
    }

    private static void download(FileTransferer port, String fileName) {

        String filePath = CLIENT_DOWNLOAD_DIRECTORY + fileName;
        System.out.println("CLIENT | UPLOAD | File Path: " + filePath);
        byte[] fileBytes = port.download(fileName);

        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            BufferedOutputStream outputStream = new BufferedOutputStream(fos);
            outputStream.write(fileBytes);
            outputStream.close();

            System.out.println("CLIENT | DOWNLOAD | File downloaded: " + filePath);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private static void upload(FileTransferer port, String fileName) {

        String filePath = CLIENT_UPLOAD_DIRECTORY + fileName;
        System.out.println("CLIENT | UPLOAD | File Path: " + filePath);
        File file = new File(filePath);

        // uploads a file
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream inputStream = new BufferedInputStream(fis);
            byte[] imageBytes = new byte[(int) file.length()];
            inputStream.read(imageBytes);

            System.out.println("CLIENT | UPLOAD | File Name: " + file.getName());
            port.upload(file.getName(), imageBytes);

            inputStream.close();
            System.out.println("CLIENT | UPLOAD | File uploaded: " + filePath);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}