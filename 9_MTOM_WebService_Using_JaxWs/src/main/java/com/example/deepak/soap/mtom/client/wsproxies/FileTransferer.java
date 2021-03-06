
package com.example.deepak.soap.mtom.client.wsproxies;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "FileTransferer", targetNamespace = "http://service.server.mtom.soap.deepak.example.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FileTransferer {


    /**
     * 
     * @param arg0
     * @return
     *     returns byte[]
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "download", targetNamespace = "http://service.server.mtom.soap.deepak.example.com/", className = "com.example.deepak.soap.mtom.client.wsproxies.Download")
    @ResponseWrapper(localName = "downloadResponse", targetNamespace = "http://service.server.mtom.soap.deepak.example.com/", className = "com.example.deepak.soap.mtom.client.wsproxies.DownloadResponse")
    public byte[] download(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "upload", targetNamespace = "http://service.server.mtom.soap.deepak.example.com/", className = "com.example.deepak.soap.mtom.client.wsproxies.Upload")
    @ResponseWrapper(localName = "uploadResponse", targetNamespace = "http://service.server.mtom.soap.deepak.example.com/", className = "com.example.deepak.soap.mtom.client.wsproxies.UploadResponse")
    public void upload(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        byte[] arg1);

}
