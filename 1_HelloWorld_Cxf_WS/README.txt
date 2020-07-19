[@WebService]

  The starting point for developing a JAX-WS web service is a Java class annotated with the 
  javax.jws.WebService annotation. 

  @WebService annotation defines the class as a web service endpoint.

  In this example, the implementation class, HelloWorldWS, is annotated as a web service endpoint using the 
  @WebService annotation. 

[@WebMethod]

  HelloWorldWS declares a single method named helloWorld, annotated with the @WebMethod annotation. 
  @WebMethod exposes the annotated method to web service clients.