package com.example.deepak.soap.client.UsernameTokenWSClient;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import com.deepak.ws.soap.PaymentProcessor;
import com.deepak.ws.soap.PaymentProcessorImplService;
import com.deepak.ws.soap.PaymentProcessorRequest;
import com.deepak.ws.soap.PaymentProcessorResponse;

public class UsernameTokenWebserviceClient {

    public static void main(String[] args) {

        PaymentProcessorImplService service = new PaymentProcessorImplService();
        PaymentProcessor port = service.getPaymentProcessorImplPort();

        Client client = ClientProxy.getClient(port);
        Endpoint endpoint = client.getEndpoint();

        Map<String, Object> props = new HashMap<>();
        props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
        props.put(WSHandlerConstants.USER, "deepakUsername");
        props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        props.put(WSHandlerConstants.PW_CALLBACK_CLASS, UsernameTokenCallbackHandler.class.getName());

        WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(props);
        endpoint.getOutInterceptors().add(wssOut);

        PaymentProcessorResponse response = port.processPayment(new PaymentProcessorRequest());
        System.out.println("------------------------------------");
        System.out.println("Webservice response: " + response.isResult());
        System.out.println("------------------------------------");
    }

}
