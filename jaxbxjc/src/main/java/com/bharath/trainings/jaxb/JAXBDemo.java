package com.bharath.trainings.jaxb;

import java.io.StringReader;
import java.io.StringWriter;
import java.rmi.UnmarshalException;

import javax.xml.bind.*;

import com.bharatthippireddy.patient.Patient;

public class JAXBDemo {

	@SuppressWarnings("restriction")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			
			//marshalling
			Marshaller marshaller = context.createMarshaller();
			
			Patient patient = new Patient();
			patient.setId(123);
			patient.setName("Atin");
			
			StringWriter writer = new StringWriter();
			marshaller.marshal(patient, writer);
			
			System.out.println(writer.toString());
			
			//unmarshalling
			Unmarshaller unmarshaller = context.createUnmarshaller();
			StringReader reader = new StringReader(writer.toString());
			Patient pat = (Patient) unmarshaller.unmarshal(reader);
			System.out.println(pat.getName());
			
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
