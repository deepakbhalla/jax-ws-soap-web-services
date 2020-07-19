package com.example.ws.soap.endpoint;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.feature.Features;

import com.ws.deepakbhalla.CreateOrdersRequest;
import com.ws.deepakbhalla.CreateOrdersResponse;
import com.ws.deepakbhalla.CustomerOrdersPortType;
import com.ws.deepakbhalla.GetOrdersRequest;
import com.ws.deepakbhalla.GetOrdersResponse;
import com.ws.deepakbhalla.Order;
import com.ws.deepakbhalla.Product;

/**
 * Web Service Implementation.
 * 
 * @author Deepak Bhalla
 *
 */
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class CustomerOrders implements CustomerOrdersPortType {

    Map<BigInteger, List<Order>> customerOrders = new HashMap<>();

    public CustomerOrders() {
        init();
    }

    public void init() {
        List<Order> orders = new ArrayList<>();

        // Product
        Product product = new Product();
        product.setId("1");
        product.setQuantity(BigInteger.valueOf(100));
        product.setDescription("Product A description");

        // Order
        Order order = new Order();
        order.setId(BigInteger.valueOf(1));
        order.getProduct().add(product);

        orders.add(order);

        customerOrders.put(BigInteger.valueOf(1), orders);
    }

    @Override
    public GetOrdersResponse getOrders(GetOrdersRequest request) {

        BigInteger customerId = request.getCustomerId();
        List<Order> orders = customerOrders.get(customerId);

        GetOrdersResponse response = new GetOrdersResponse();
        response.getOrder().addAll(orders);

        return response;
    }

    @Override
    public CreateOrdersResponse createOrders(CreateOrdersRequest request) {

        BigInteger customerId = request.getCustomerId();
        List<Order> orders = customerOrders.get(customerId);
        orders.add(request.getOrder());

        customerOrders.put(request.getCustomerId(), orders);

        CreateOrdersResponse response = new CreateOrdersResponse();
        response.setResult(true);

        return response;
    }
}
