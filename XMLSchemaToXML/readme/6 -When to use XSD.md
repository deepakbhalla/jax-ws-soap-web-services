When to use Xml Schema Definition

Why do we need xml schema file and where do we use it.

- The xml schema file is a contract between two XML users.That is if application one and application two are exchanging xml messages for some data without a contract to define for what elements and attributes should be dead in this xml document application one can send in any data in xml which application two doesn't even care or doesn't even understand.

- Similarly application two can also do something similar by sending the wrong data or additional data which application one doesn't care that is where xml schema definition comes into picture.

- And these two applications write when they are being developed can agree on a contract by defining all the elements and attributes inside the XML schema definition file for thi xml.

- Similarly let's say we bought a new employee management software for our enterprise.And now this employee management software from a third party has to access our employee database.

- And that third party software has asked us to use a xml configuration file so that we tell this software where our database and how to access it inside that xml configuration file.

- This third party software will validate our xml that we come up with against this schema file.And they provide us the schema fine so that by looking at the schema file we will know what elements we can include inside of that configuration file.

- So wherever and whenever you use xml to make sure that the xml is valid it is carrying valid data.

- We need a contract and that is where xml schema definition comes into picture and we can specify everything that xml can have inside a XML schema definition.
