package com.example.deepak.soap.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.example.deepak.soap.ws.dto.PafRequest;
import com.example.deepak.soap.ws.dto.PafResponse;

@WebService(name = "PostCodeFinder")
public interface PostalAddressFinderWs {

    @WebMethod
    public @WebResult(name = "response") PafResponse getPostalAddress(
            @WebParam(name = "pafRequest") PafRequest pafRequest);
}
