[WSDL first WebService Steps]

    1. [Create the WSDL file]

       Create the WSDL file named 'CustomerOrders.wsdl' at location 'src/main/resources'

    2. [Generate Stubs from Wsdl2Java codegen maven plugin of cxf framework]
    
       User maven plugin named 'cxf-codegen-plugin' to generate Java Objects/stubs from above created wsdl file

    3. [Implement the endpoint]

       Using generated stubs, implement the endpoint implementation class 'CustomerOrdersWsImpl'.

    4. [Publish the endpoint]

       Create a configuration class file annotated with @Configuration (spring annotation) and publish
       endpoint to EndpointImpl class.

This project has been tested using SOAP UI and screenshots are available folder named 'screenshots'.
