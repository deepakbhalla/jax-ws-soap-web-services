Why XML

1) Why XML or what are the advantages of XML? The number one advantage which you already know from the previous lecture is that we can create our own custom markup using XML For example if we are working on an e-commerce application we can create a order xml which has the order id, shipping info on all the product information etc.

2)The second and the major advantage of xml is it carries both the data and the Metadata.For example, let's say we are all together working for Amazon on their Amazon web application which allows the customers to place an order and then a Amazon shipping application which will ship the order for the customer when it is ready.

3) Now as soon as the customer places an order or when the product is ready for shipping the amazon web application sends the data to the Amazon shipping application as xml. The Amazon shipping application looking at this xml which has both the data which is 123 for order ID and our address for shipping info and the metadata which is the order ID the shipping info knows what to do with this data immediately know that this is for order 123 and the shipping info is where it should ship the order.

4) Finally xml follows certain well-formedness rules,So we have to make sure the applications that are producing XML have to make sure that they are sending in a clean xml,Otherwise the applications which are processing the xml can reject it.

5) Similarly, we have validation rules which are very powerful.We can create schema files for our xml.And then these applications which are exchanging data.For example, when the Amazon web application sends the data the shipping application can validate that data against a schema which they have agreed to even before these applications were developed.

6) To summarize, the main advantages of using XML are it allows us to create custom markup.It has both the Meta data and the data which makes it easy for applications to consume the data and make some sense out of it.Finally, it follows certain well formedness rules and also it allows us to do data validation before we do anything with that data.
