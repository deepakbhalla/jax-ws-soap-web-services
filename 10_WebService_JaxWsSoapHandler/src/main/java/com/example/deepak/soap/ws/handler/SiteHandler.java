package com.example.deepak.soap.ws.handler;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.MessageContext.Scope;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 * SOAP Handler class which implements SOAPHandler<SOAPMessageContext> which
 * provides access to full soap message not just only the body of of the
 * request.
 *
 */
public class SiteHandler implements SOAPHandler<SOAPMessageContext> {

    /**
     * This method gets called on both request as well as response.
     */
    @Override
    public boolean handleMessage(SOAPMessageContext context) {

        System.out.println("Inside handleMessage()");
        /**
         * check if this method is called on request or response by checking
         * MessageContext.MESSAGE_OUTBOUND_PROPERTY property which is set by CXF at
         * runtime. It's true if it's response else false.
         */
        boolean isResponse = (boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (!isResponse) {
            // retrieve soap message
            SOAPMessage soapMsg = context.getMessage();

            // retrieve information from soapMsg
            try {
                SOAPEnvelope envelope = soapMsg.getSOAPPart().getEnvelope();
                SOAPHeader header = envelope.getHeader();
                Iterator childElements = header.getChildElements();

                // Fetch Site Name coming in the request headers
                while (childElements.hasNext()) {
                    Node eachNode = (Node) childElements.next();
                    String name = eachNode.getLocalName();

                    if ("SiteName".equals(name)) {
                        System.out.println("Site Name : " + eachNode.getValue());

                        // Set SiteName in "SOAPMessageContext" so that it can be access by WebService
                        // implementation.
                        context.put("SITE_NAME", eachNode.getValue());
                        context.setScope("SITE_NAME", Scope.APPLICATION);
                    }
                }
            } catch (SOAPException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Response on the way");
        }
        return true;
    }

    /**
     * Called when an exception is thrown by the web service provider.
     */
    @Override
    public boolean handleFault(SOAPMessageContext context) {
        System.out.println("Inside handleFault()");
        return false;
    }

    /**
     * Called at the end of the flow before response goes out and at the end of
     * handler.
     */
    @Override
    public void close(MessageContext context) {
        System.out.println("Inside close()");
    }

    @Override
    public Set<QName> getHeaders() {
        System.out.println("Inside getHeaders()");
        return null;
    }

}
