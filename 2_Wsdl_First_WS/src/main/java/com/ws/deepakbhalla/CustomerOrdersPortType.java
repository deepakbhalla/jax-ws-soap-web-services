package com.ws.deepakbhalla;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.3.7
 * 2020-07-19T19:34:52.861+05:30
 * Generated source version: 3.3.7
 *
 */
@WebService(targetNamespace = "http://www.deepakbhalla.ws.com", name = "CustomerOrdersPortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface CustomerOrdersPortType {

    @WebMethod(action = "http://www.deepakbhalla.ws.com/getOrders")
    @WebResult(name = "getOrdersResponse", targetNamespace = "http://www.deepakbhalla.ws.com", partName = "parameters")
    public GetOrdersResponse getOrders(

        @WebParam(partName = "parameters", name = "getOrdersRequest", targetNamespace = "http://www.deepakbhalla.ws.com")
        GetOrdersRequest parameters
    );

    @WebMethod(action = "http://www.deepakbhalla.ws.com/createOrders")
    @WebResult(name = "createOrdersResponse", targetNamespace = "http://www.deepakbhalla.ws.com", partName = "parameters")
    public CreateOrdersResponse createOrders(

        @WebParam(partName = "parameters", name = "createOrdersRequest", targetNamespace = "http://www.deepakbhalla.ws.com")
        CreateOrdersRequest parameters
    );
}