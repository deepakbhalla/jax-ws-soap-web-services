
package com.example.deepak.soap.mtom.client.wsproxies;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "FileTransfererService", targetNamespace = "http://service.server.mtom.soap.deepak.example.com/", wsdlLocation = "http://localhost:8080/api/jaxws/mtom/v1/fileWs?wsdl")
public class FileTransfererService
    extends Service
{

    private final static URL FILETRANSFERERSERVICE_WSDL_LOCATION;
    private final static WebServiceException FILETRANSFERERSERVICE_EXCEPTION;
    private final static QName FILETRANSFERERSERVICE_QNAME = new QName("http://service.server.mtom.soap.deepak.example.com/", "FileTransfererService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/api/jaxws/mtom/v1/fileWs?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FILETRANSFERERSERVICE_WSDL_LOCATION = url;
        FILETRANSFERERSERVICE_EXCEPTION = e;
    }

    public FileTransfererService() {
        super(__getWsdlLocation(), FILETRANSFERERSERVICE_QNAME);
    }

    public FileTransfererService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FILETRANSFERERSERVICE_QNAME, features);
    }

    public FileTransfererService(URL wsdlLocation) {
        super(wsdlLocation, FILETRANSFERERSERVICE_QNAME);
    }

    public FileTransfererService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FILETRANSFERERSERVICE_QNAME, features);
    }

    public FileTransfererService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FileTransfererService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FileTransferer
     */
    @WebEndpoint(name = "FileTransfererPort")
    public FileTransferer getFileTransfererPort() {
        return super.getPort(new QName("http://service.server.mtom.soap.deepak.example.com/", "FileTransfererPort"), FileTransferer.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FileTransferer
     */
    @WebEndpoint(name = "FileTransfererPort")
    public FileTransferer getFileTransfererPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.server.mtom.soap.deepak.example.com/", "FileTransfererPort"), FileTransferer.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FILETRANSFERERSERVICE_EXCEPTION!= null) {
            throw FILETRANSFERERSERVICE_EXCEPTION;
        }
        return FILETRANSFERERSERVICE_WSDL_LOCATION;
    }

}
