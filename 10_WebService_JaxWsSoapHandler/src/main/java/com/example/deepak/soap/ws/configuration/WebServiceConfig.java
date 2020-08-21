package com.example.deepak.soap.ws.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.deepak.soap.ws.handler.SiteHandler;
import com.example.deepak.soap.ws.service.PostalAddressFinderWsImpl;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint() {
        Endpoint endpoint = new EndpointImpl(bus, new PostalAddressFinderWsImpl());
        endpoint.publish("/postcodefinder");

        // Create Jax-Ws SOAP Handler chain
        List<Handler> handlerChain = new ArrayList<>();
        handlerChain.add(new SiteHandler());

        // Get jax-ws SOAPBiding from endpoint
        SOAPBinding binding = (SOAPBinding) endpoint.getBinding();

        // Add Handler chain to the soap binding object
        binding.setHandlerChain(handlerChain);

        return endpoint;
    }
}
