package com.example.deepak.soap.ws.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;

import org.apache.cxf.feature.Features;

import com.example.deepak.soap.ws.dto.PafRequest;
import com.example.deepak.soap.ws.dto.PafResponse;

@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class PostalAddressFinderWsImpl implements PostalAddressFinderWs {

    @Resource
    private WebServiceContext ctx;

    private static final String UK = "UNITED_KINGDOM";
    private static final String INDIA = "INDIA";

    private Map<String, String> postalAddresses_UK = new HashMap<String, String>();
    private Map<String, String> postalAddresses_India = new HashMap<String, String>();

    /**
     * For the demonstration purpose, added only one address against the given
     * postcode. However, in real scenarios, there are multiple addresses mapped
     * against a single postcode.
     */
    public PostalAddressFinderWsImpl() {

        // Initialize UK Postal Addresses
        postalAddresses_UK.put("CR0 3RL", "16-15 Fatory Lane Croydon, London");
        postalAddresses_UK.put("LS1 8EQ", "44-48, The Headrow, Leeds");

        // Initialize India Postcodes/Pincodes
        postalAddresses_India.put("403512", "Bardez taluk of North Goa district, Goa state");
        postalAddresses_India.put("302001", "Jaipur taluk of Jaipur district, Rajasthan state");
    }

    public PafResponse getPostalAddress(PafRequest pafRequest) {

        PafResponse pafResponse = new PafResponse();

        // Retrieve the SITE_NAME set by SOAP Handler in the SOAPMessageContext in
        // SiteHandler.java class
        String siteName = (String) ctx.getMessageContext().get("SITE_NAME");

        System.out.println("SITE_NAME RETRIEVED FROM WebServiceContext: " + siteName);

        if (UK.equalsIgnoreCase(siteName)) {
            pafResponse.setResult(true);
            String postalAddress = postalAddresses_UK.get(pafRequest.getPostcode());
            if (postalAddress != null) {
                pafResponse.setPostalAddress(postalAddress);
            } else {
                pafResponse.setResult(false);
                pafResponse.setErrorMessage("Post code " + pafRequest.getPostcode() + " not found");
            }
        } else if (INDIA.equalsIgnoreCase(siteName)) {
            pafResponse.setResult(true);
            String postalAddress = postalAddresses_India.get(pafRequest.getPostcode());
            if (postalAddress != null) {
                pafResponse.setPostalAddress(postalAddress);
            } else {
                pafResponse.setResult(false);
                pafResponse.setErrorMessage("Post code " + pafRequest.getPostcode() + " not found");
            }
        } else {
            pafResponse.setResult(false);
            pafResponse.setErrorMessage("Invalid country name in request");
        }
        return pafResponse;
    }
}
