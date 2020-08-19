This example shows that how MTOM (Message Transmission Optimization Mechanism) can be used to optimize binary data transfer through 
web services with JAX-WS (Java API for XML-based Web Services).

## Why MTOM?

By default, binary data is converted to base64Binary or hexBinary XML data type within a SOAP envelope, meaning that the raw bytes are 
encoded as a String using base64 technique. Basically, the base64 encoding technique bloats the original data by a factor of 1.33x 
(with UTF-8 encoding) or 2.66x (with UTF-16), so it becomes very inefficient when dealing with a large amount of data. To overcome this 
drawback, MTOM is defined as a specification for optimizing the transmission of this kind of data type in SOAP messages, and XOP 
(XML-binary Optimized Packaging) is the concrete implementation.

## Enabling MTOM in JAX-WS

In JAX-WS, it’s easy to enable MTOM for a web service endpoint by using either the @MTOM or @BindingType annotations. 

At the client side, MTOM can be enabled either by passing a new instance of MTOMFeature class when getting a reference to the web service 
endpoint (port), or by calling the SOAPBinding.setMTOMEnabled(true) method on the binding provider object.

## Steps to run server and client

* Run Application.java as java application. This would start the tomcat server with cxf web service deployed.
* Run wsimport command to generate web service proxies for client. On the succesful execution of the below command, proxies will be 
  generated at package 'com.example.deepak.soap.mtom.client\wsproxies'.
	
	wsimport -keep -verbose -p com.example.deepak.soap.mtom.client\wsproxies http://localhost:8080/api/jaxws/mtom/v1/fileWs?wsdl
	
* Run 'WebSeviceAppClient.java' as Java Application which will trigger both upload() and download() method.
* Screenshots of each step are present in 'screenshot' directory of this project.

## Application logs

* Client

	CLIENT | UPLOAD | File Path: C:\Temp\Test\Client\Upload\sparrow_image.jpg
	CLIENT | UPLOAD | File Name: sparrow_image.jpg
	CLIENT | DOWNLOAD | File downloaded: C:\Temp\Test\Client\Download\lion_image.jpg

* Server

	SERVER | UPLOAD | Received file: c:/Temp/Test/Server/Upload/sparrow_image.jpg
	SERVER | DOWNLOAD | Sending file: c:/Temp/Test/Server/Download/lion_image.jpg
  Client

	CLIENT | UPLOAD | File Path: C:\Temp\Test\Client\Upload\sparrow_image.jpg
	
	CLIENT | UPLOAD | File Name: sparrow_image.jpg
	
	CLIENT | DOWNLOAD | File downloaded: C:\Temp\Test\Client\Download\lion_image.jpg

  Server

	SERVER | UPLOAD | Received file: c:/Temp/Test/Server/Upload/sparrow_image.jpg
	
	SERVER | DOWNLOAD | Sending file: c:/Temp/Test/Server/Download/lion_image.jpg
