CXF File Upload With SOAP MTOM shows Implementing a SOAP service for uploading/sending large attachment using MTOM (SOAP Message Transmission Optimization Mechanism)

MTOM is Message Transmission Optimization Mechanism, is a method to send binary data over web service calls.  Usual web service calls does not let you pass large amounts of data as a part of Web Service method invocations. To solve this, one either employ SOAP with Attachments or Mtom. SOAP with attachments require you to modify the ‘binding’ part of the wsdl exposed by your webservice. With Mtom, you get to skip all that and more. Here i discuss Mtom

MTOM is used for encoding binary data in base64Binary and send as binary attachement than keeping it with actual SOAP message. MTOM is approved by WC3 and is a standard. MTOM very useful for transfering binary data such as MS documents, PDF, images etc. MTOM uses XML-binary Optimized Packaging (XOP) packages for transmitting binary data

MTOM is used for sending large attachments using WSDL based services (SOAP).

You can go through this sample web-service project, in order to learn how to use MTOM inside CXF.