Namespaces:

- From this lecture you will learn what namespaces are and why we need them.Namespaces uniquely identify the elements and attributes of a XML document.

- When we are creating a schema file for example let's say we are working on creating schema files for amazon.com and ebay.com to handle their orders.

- The first step would be when we define a schema will assign target namespace for all the elements in Amazon's order by using the target namespace attribute from xml schema specification and we will use a unique url from Amazon.

- It is always a good practice to use a url of the company because it is unique across the world and across the internet for a namespace.

- And then if you are defining a target namespace for eBay it would look like this where in it use the eBay's domain name or the ebays URL.

- Once we define a target namespace in their respective schema files we can use a prefix instead of using this entry URL to qualify each element in the XML schema and xml Later on we can use a prefix like this.xmlns stands for xml namespace. This attribute is from xml specification colon whatever prefix we want to use this prefix.

- From this point in time will refer to this url and then we can qualify all the elements using this amz instead of this entire URL.

- Similarly, if we are defining a prefix for eBay here is the xmlns colon eBay is the prefix this could be x y z or anything.

- And then the actual namespace.Once we define the target namespace and qualify all the elements that we create with these prefixes when we create the xml document that document also should use the exact namespace.

- For example, the order for amazon the root element for order will have xmlns colon prefix defined for the namespace and all the elements in that order will be qualified with that prefix.

- Similarly, the order for eBay will use xmlns colon eBay and then all the elements inside again will be qualified with the eBay's namespace for some business reason,if we have to use multiple orders from eBay and Amazon in a single XML document looking at the namespace .We know from which company or if the order is from Amazon or is the order from ebay.

- To summarize namespaces allow us to uniquely identify the elements and attributes in a xml document, we create target namespaces in the schema file which tells that all the elements in that schema file should follow a certain namespace and then instead of using the entire url to qualify each element in the schema we use a prefix.

- If you are from a object oriented or programming background in the world of Java namespace is nothing but a package where-in you create classes and put them into a certain package and in the dot net world it is called namespace, where you create classes and put them into namespaces.

- You will learn some advanced namespace topics in sections later on.But for now this information is pretty good for you to get started with xml schema creation and you will be creating target name spaces prefixing the elements in that schema file with those namespaces.
