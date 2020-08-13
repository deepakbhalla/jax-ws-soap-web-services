package com.deepak.ws.soap.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Originally, this was a pojo plain class. With purpose of exposing this legacy project as a web-service,
 * it's marked with  annotations using 'javax.xml.bind' package.
 * 
 * Please note that @XmlType annotation would used to create a complexType schema element of xml type. Parameter
 * 'name' is optional, if not defined, the classname would be considered.
 * 
 * Also, annotatoin @XmlElement is optional.
 * 
 * Example:  Map a class to a complex type with xs:sequence with a customized ordering of JavaBean properties. 
 *  
 *  @XmlType(propOrder={"street", "city" , "state", "zip", "name" })
 *  public class USAddress {
 *   String getName() {..};
 *    void setName(String) {..};
 *
 *    String getStreet() {..};
 *    void setStreet(String) {..};
 *
 *    String getCity() {..};
 *    void setCity(String) {..};
 *
 *    String getState() {..};
 *    void setState(String) {..};
 *
 *    java.math.BigDecimal getZip() {..};
 *    void setZip(java.math.BigDecimal) {..};
 *  }
 *
 *  <!-- XML Schema mapping for USAddress -->
 *  <xs:complexType name="USAddress">
 *    <xs:sequence>
 *      <xs:element name="street" type="xs:string"/>
 *      <xs:element name="city" type="xs:string"/>
 *      <xs:element name="state" type="xs:string"/>
 *      <xs:element name="zip" type="xs:decimal"/>
 *      <xs:element name="name" type="xs:string"/>
 *    </xs:all>
 *  </xs:complexType>
 *
 */

@XmlType(name = "PaymentProcessorRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentProcessorRequest {

    @XmlElement(name = "creditCardInfo", required = true)
    private CreditCardInfo creditCardInfo;

    @XmlElement(name = "amount", required = true)
    private Double amount;

    public CreditCardInfo getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setCreditCardInfo(CreditCardInfo creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
