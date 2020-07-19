1. Maven plugin 'maven-jaxb2-plugin' has been used in this project to convert xml schema files (.xsd) 
   into Java Objects. Maven goal 'generate' for this plugin has been used for this purpose.
   
2. When this maven projet is executed, it generates Java stubs in the 'generated' folder. Configuration
   of source directory containing xsd files (.xsd), binding directory containing binding file (.xjb) and
   generated directory where stubs will be generated has been mentioned in the 'configuration' of
   'maven-jaxb2-plugin'.
   
3. Steps 1 and 2 are sufficient to generate java stubs (.java) from schema files (.xsd).

4. This step demonstrates Jaxb Marshelling (Java Object to XML conversion) and Jaxb Unmarshelling (XML to Java).
   This has been coded in App.java file.