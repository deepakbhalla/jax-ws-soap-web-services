
package com.deepak.ws.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for processPayment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="processPayment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="paymentProcessorRequest" type="{http://soap.ws.deepak.com/}PaymentProcessorRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "processPayment", propOrder = {
    "paymentProcessorRequest"
})
public class ProcessPayment {

    protected PaymentProcessorRequest paymentProcessorRequest;

    /**
     * Gets the value of the paymentProcessorRequest property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentProcessorRequest }
     *     
     */
    public PaymentProcessorRequest getPaymentProcessorRequest() {
        return paymentProcessorRequest;
    }

    /**
     * Sets the value of the paymentProcessorRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentProcessorRequest }
     *     
     */
    public void setPaymentProcessorRequest(PaymentProcessorRequest value) {
        this.paymentProcessorRequest = value;
    }

}
