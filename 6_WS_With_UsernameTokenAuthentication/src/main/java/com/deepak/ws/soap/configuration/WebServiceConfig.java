package com.deepak.ws.soap.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.dom.WSConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.deepak.ws.soap.PaymentProcessorImpl;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new PaymentProcessorImpl());
        endpoint.publish("/payment-processor");

        // Use HashMap to fill Username Token authentication profile details and pass it
        // to WSS4JInterceptor.
        Map<String, Object> inProps = new HashMap<String, Object>();

        // Action name
        inProps.put(ConfigurationConstants.ACTION, ConfigurationConstants.USERNAME_TOKEN);
        // Password type
        inProps.put(ConfigurationConstants.PASSWORD_TYPE, WSConstants.PASSWORD_TEXT);
        // Provides username and password details
        inProps.put(ConfigurationConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());

        // Intercept the incoming request message using WSS4JInInterceptor
        WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
        endpoint.getInInterceptors().add(wssIn);

        return endpoint;
    }
}
