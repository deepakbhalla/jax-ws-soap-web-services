package com.example.deepak.soap.ws.configuration;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.deepak.soap.ws.service.PostalAddressFinderWsImpl;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint() {
        Endpoint endpoint = new EndpointImpl(bus, new PostalAddressFinderWsImpl());
        endpoint.publish("/postcodefinder");
        return endpoint;
    }
}
