package com.example.deepak.soap.ws.dto;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "PafResponse")
public class PafResponse {

    private String postalAddress;
    private boolean result;
    private String errorMessage;

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
