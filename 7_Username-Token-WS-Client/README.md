* This project generates the proxy classes from PaymentProcessorImplService.wsdl (resources\META-INF\wsdl). This wsdl file has been downloaded from location 'http://localhost:8081/payment/api/v1/payment-processor?wsdl' which is exposed by web service project named '6_WS_With_UsenameTokenAuthentication'.

* The wsimport tool is used to parse an existing Web Services Description Language (WSDL) file and generate required files (JAX-WS portable artifacts) for web service client to access the published web services.

* This wsimport tool is available in the $JDK/bin folder

* Command to generate web service proxy client

	wsimport -keep -verbose http://localhost:8081/payment/api/v1/payment-processor?wsdl -clientjar PaymentProcessorClient.jar

* This generates proxy client jar named 'PaymentProcessorClient.jar'
 
* Add this jar on the build path of the project

* Implement call back handler class (UsernameTokenCallbackHandler.java)

* Implement client class using WSS4JOutInterceptor provided by cxf web-services security implementation.

* Run the client class as a Java application.

* Look for the response status logged in the console output.

For more details on CXF WS Security, please refer:

	http://cxf.apache.org/docs/ws-security.html