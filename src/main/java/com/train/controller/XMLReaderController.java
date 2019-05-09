package com.train.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;


@RestController
public class XMLReaderController {

//    // you would rather:
//    @Autowired
//    private Jaxb2Marshaller  marshaller;
//    // than:
//    // JAXBContext jc = JAXBContext.newInstance(User.class);
//    // Marshaller marshaller = jc.createMarshaller();
//
//    // marshalls one object (of your bound classes) into a String.
//    public <T> String marshallXml(final T obj) throws JAXBException {
//        StringWriter sw = new StringWriter();
//        Result result = new StreamResult(sw);
//        marshaller.marshal(obj, result);
//        return sw.toString();
//    }
//
//    // (tries to) unmarshall(s) an InputStream to the desired object.
//    @SuppressWarnings("unchecked")
//    public <T> T unmarshallXml(final InputStream xml) throws JAXBException {
//        return (T) marshaller.unmarshal(new StreamSource(xml));
//    }


    @RequestMapping(value = "/unmarshal", method = RequestMethod.GET, produces = "application/json")
    public generated.Invoice unmarshal() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(generated.Invoice.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("/Users/user/Documents/projects/task.xml");
        return  (generated.Invoice) unmarshaller.unmarshal(xml);
    }



}
