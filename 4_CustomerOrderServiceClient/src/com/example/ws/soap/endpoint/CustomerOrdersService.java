
package com.example.ws.soap.endpoint;

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
@WebServiceClient(name = "CustomerOrdersService", targetNamespace = "http://endpoint.soap.ws.example.com/", wsdlLocation = "http://localhost:8080/public/online/ws/customerordersservice?wsdl")
public class CustomerOrdersService
    extends Service
{

    private final static URL CUSTOMERORDERSSERVICE_WSDL_LOCATION;
    private final static WebServiceException CUSTOMERORDERSSERVICE_EXCEPTION;
    private final static QName CUSTOMERORDERSSERVICE_QNAME = new QName("http://endpoint.soap.ws.example.com/", "CustomerOrdersService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/public/online/ws/customerordersservice?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CUSTOMERORDERSSERVICE_WSDL_LOCATION = url;
        CUSTOMERORDERSSERVICE_EXCEPTION = e;
    }

    public CustomerOrdersService() {
        super(__getWsdlLocation(), CUSTOMERORDERSSERVICE_QNAME);
    }

    public CustomerOrdersService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CUSTOMERORDERSSERVICE_QNAME, features);
    }

    public CustomerOrdersService(URL wsdlLocation) {
        super(wsdlLocation, CUSTOMERORDERSSERVICE_QNAME);
    }

    public CustomerOrdersService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CUSTOMERORDERSSERVICE_QNAME, features);
    }

    public CustomerOrdersService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CustomerOrdersService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CustomerOrdersPortType
     */
    @WebEndpoint(name = "CustomerOrdersPort")
    public CustomerOrdersPortType getCustomerOrdersPort() {
        return super.getPort(new QName("http://endpoint.soap.ws.example.com/", "CustomerOrdersPort"), CustomerOrdersPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CustomerOrdersPortType
     */
    @WebEndpoint(name = "CustomerOrdersPort")
    public CustomerOrdersPortType getCustomerOrdersPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://endpoint.soap.ws.example.com/", "CustomerOrdersPort"), CustomerOrdersPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CUSTOMERORDERSSERVICE_EXCEPTION!= null) {
            throw CUSTOMERORDERSSERVICE_EXCEPTION;
        }
        return CUSTOMERORDERSSERVICE_WSDL_LOCATION;
    }

}