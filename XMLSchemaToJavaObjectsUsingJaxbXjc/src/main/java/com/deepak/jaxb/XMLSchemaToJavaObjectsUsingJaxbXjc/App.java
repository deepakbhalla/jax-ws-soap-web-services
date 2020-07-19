package com.deepak.jaxb.XMLSchemaToJavaObjectsUsingJaxbXjc;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import com.deepakbhalla.patient.Gender;
import com.deepakbhalla.patient.Patient;

public class App {
	public static void main(String[] args) {
		try {
			JAXBContext context = JAXBContext.newInstance(Patient.class);

			// ---------------- Java to XML ---------------
			Marshaller marshaller = context.createMarshaller();

			Patient patient = new Patient();
			patient.setAge(34);
			patient.setGender(Gender.M);
			patient.setName("ABCD");

			StringWriter writer = new StringWriter();

			marshaller.marshal(patient, writer);
			System.out.println("MARSHALLING   => " + writer.toString());

			// --------------- XML to Java ---------------
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Patient p = (Patient) unmarshaller.unmarshal(new StringReader(writer.toString()));
			System.out.println(
					"UNMARSHALLING => Age: " + p.getAge() + ", Gender: " + p.getGender() + ", Name: " + p.getName());

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
