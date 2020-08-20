package com.example.deepak.soap.ws.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "PafRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class PafRequest {

    @XmlElement(name = "postcode")
    private String postcode;

    @XmlElement(name = "country")
    private String country;

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
