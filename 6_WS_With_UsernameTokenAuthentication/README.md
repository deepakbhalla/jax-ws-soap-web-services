Steps to introduce Username Token Authentication in a Web Service project -

1. Add security maven dependency. We are using 'cxf-rt-ws-security' dependency of apache -

	   <dependency>
	     <groupId>org.apache.cxf</groupId>
	     <artifactId>cxf-rt-ws-security</artifactId>
	     <version>3.3.7</version>
	   </dependency>

2. Configure WSS4J Interceptors
3. Create the Password Callback
4. User below <soapenv:Header> in the request

	<soapenv:Header>
	  <wsse:Security xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" soapenv:mustUnderstand="1">
		<wsse:UsernameToken xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" xmlns:wsu="	   http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd">
			<wsse:Username xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd">deepakUsername</wsse:Username>
			<wsse:Password xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" Type="	http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText">bhallaPassword</wsse:Password>
		</wsse:UsernameToken>
	  </wsse:Security>
	</soapenv:Header>

5. Run and test	