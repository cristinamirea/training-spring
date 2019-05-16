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

    @RequestMapping(value = "/unmarshal", method = RequestMethod.GET, produces = "application/json")
    public generated.Invoice unmarshal() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(generated.Invoice.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("/Users/user/Documents/projects/task.xml");
        return  (generated.Invoice) unmarshaller.unmarshal(xml);
    }

}
