The wsimport tool is used to parse an existing Web Services Description Language (WSDL) file and 
generate required files (JAX-WS portable artifacts) for web service client to access the published web services. 

This wsimport tool is available in the $JDK/bin folder

Command to generate web service proxy client

	wsimport -keep -verbose http://localhost:8080/public/online/ws/customerordersservice?wsdl

This shows below messages on command line

	Picked up _JAVA_OPTIONS: -Xms1024M
	parsing WSDL...
	
	Generating code...
	
	com\ws\deepakbhalla\CreateOrdersRequest.java
	com\ws\deepakbhalla\CreateOrdersResponse.java
	com\ws\deepakbhalla\GetOrdersRequest.java
	com\ws\deepakbhalla\GetOrdersResponse.java
	com\ws\deepakbhalla\ObjectFactory.java
	com\ws\deepakbhalla\Order.java
	com\ws\deepakbhalla\Product.java
	com\ws\deepakbhalla\package-info.java
	com\example\ws\soap\endpoint\CustomerOrdersPortType.java
	com\example\ws\soap\endpoint\CustomerOrdersService.java
	
	Compiling code...

After this is completed, these proxy classes have been added in the src folder of this project and exported as jar file, 
named 'CustomerOrderService-1.0.jar'.

This jar file has been referenced in client project '3_CustomerOrdersWebServiceClient' which is calling the web service.