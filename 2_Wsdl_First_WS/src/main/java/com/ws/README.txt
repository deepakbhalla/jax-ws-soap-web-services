Maven plugin 'cxf-codegen-plugin' generates Java classes from wsdl and adds at '/target/generated/cxf'
path with package location 'com/ws/deepakbhalla'.

These classes do not get automatically added at the build path of the project.

Hence, I have copied these generated source files from location 'target/generated/cxf' and added them 
at location 'src/main/java/com/ws/deepakbhalla'.