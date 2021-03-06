
package com.deepak.ws.soap;

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
@WebService(name = "PaymentProcessor", targetNamespace = "http://soap.ws.deepak.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PaymentProcessor {


    /**
     * 
     * @param paymentProcessorRequest
     * @return
     *     returns com.deepak.ws.soap.PaymentProcessorResponse
     */
    @WebMethod
    @WebResult(name = "response", targetNamespace = "")
    @RequestWrapper(localName = "processPayment", targetNamespace = "http://soap.ws.deepak.com/", className = "com.deepak.ws.soap.ProcessPayment")
    @ResponseWrapper(localName = "processPaymentResponse", targetNamespace = "http://soap.ws.deepak.com/", className = "com.deepak.ws.soap.ProcessPaymentResponse")
    public PaymentProcessorResponse processPayment(
        @WebParam(name = "paymentProcessorRequest", targetNamespace = "")
        PaymentProcessorRequest paymentProcessorRequest);

}
