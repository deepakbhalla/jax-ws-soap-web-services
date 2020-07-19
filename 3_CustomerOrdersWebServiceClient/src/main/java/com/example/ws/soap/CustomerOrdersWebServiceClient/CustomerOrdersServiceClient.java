package com.example.ws.soap.CustomerOrdersWebServiceClient;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.example.ws.soap.endpoint.CustomerOrdersPortType;
import com.example.ws.soap.endpoint.CustomerOrdersService;
import com.ws.deepakbhalla.CreateOrdersRequest;
import com.ws.deepakbhalla.CreateOrdersResponse;
import com.ws.deepakbhalla.GetOrdersRequest;
import com.ws.deepakbhalla.GetOrdersResponse;
import com.ws.deepakbhalla.Order;
import com.ws.deepakbhalla.Product;

public class CustomerOrdersServiceClient {

    public static void main(String[] args) throws MalformedURLException {

        // service object can be created from either by calling customer with parameters
        // or without parameters.
        // Good practice is to call non parameterized constructor.

        // If wsdl location is not accessible due to security constraints, then service
        // calling would fail in this
        // implementation. To overcome this situation, please use jax-ws-catalog.xml
        // inside 'META-INF' of the project.
        // This file redirects the Get request to wsdl location to locally provided wsdl
        // file avoiding any call to
        // internet to download the wsdl.
        CustomerOrdersService service = new CustomerOrdersService(
                new URL("http://localhost:8080/public/online/ws/customerordersservice?wsdl"));

        CustomerOrdersPortType customerOrdersPort = service.getCustomerOrdersPort();

        // Get Orders service request
        getCustomerOrdersServiceCall(customerOrdersPort);

        // Create order service request
        createCustomerOrderServiceCall(customerOrdersPort);

        // Get Orders service request
        getCustomerOrdersServiceCall(customerOrdersPort);
    }

    private static void createCustomerOrderServiceCall(CustomerOrdersPortType customerOrdersPort) {
        CreateOrdersRequest createOrderRequest = new CreateOrdersRequest();
        createOrderRequest.setCustomerId(BigInteger.valueOf(1));

        List<Product> products = new ArrayList<Product>();
        Product product = new Product();
        product.setDescription("Product B Description");
        product.setId("2");
        product.setQuantity(BigInteger.valueOf(200));
        products.add(product);

        Order order = new Order();
        order.setId(BigInteger.valueOf(2));
        order.getProduct().add(product);

        createOrderRequest.setOrder(order);
        CreateOrdersResponse createOrdersResponse = customerOrdersPort.createOrders(createOrderRequest);
        System.out.println(createOrdersResponse.isResult());
    }

    private static GetOrdersResponse getCustomerOrdersServiceCall(CustomerOrdersPortType customerOrdersPort) {
        GetOrdersRequest getOrdersRequest = new GetOrdersRequest();
        getOrdersRequest.setCustomerId(BigInteger.valueOf(1));
        GetOrdersResponse getOrdersResponse = customerOrdersPort.getOrders(getOrdersRequest);
        responseLogger(getOrdersResponse);
        return getOrdersResponse;
    }

    private static void responseLogger(GetOrdersResponse orders) {
        List<Order> ordersReceived = orders.getOrder();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ordersReceived.size(); i++) {
            List<Product> products = ordersReceived.get(i).getProduct();
            BigInteger orderId = ordersReceived.get(i).getId();
            sb.append("Order Id: " + orderId + "\n");
            for (int j = 0; j < products.size(); j++) {
                sb.append("  Product Id: " + products.get(j).getId() + "\n");
                sb.append("    Description: " + products.get(j).getDescription() + "\n    Quantity: "
                        + products.get(j).getQuantity() + "\n");
            }
        }

        System.out.println(sb.toString());
    }
}
