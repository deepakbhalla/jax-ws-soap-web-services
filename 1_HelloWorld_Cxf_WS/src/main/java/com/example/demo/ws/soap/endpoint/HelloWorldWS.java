package com.example.demo.ws.soap.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.cxf.feature.Features;

@WebService
@Features(features="org.apache.cxf.feature.LoggingFeature")
public class HelloWorldWS {

	@WebMethod
	public String helloWorld() {
		return "Hello World!";
	}
}
