This project is the client which consumes Customer Order web service exposed by another project '2_Wsdl_First_WS'.

Web-service proxy classes of Customer Order Web-service has been created using wsimport utility in another project 'CustomerOrderServiceClient'
and the generated proxy jar has been on build path of this project.

Using the proxy classes, client class makes a call to the web service's operations - getOrders() and createOrder().