package com.train.controller;

import com.train.entity.Invoice;
import com.train.model.InvoiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.train.repository.InvoiceRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private InvoiceRepository invoiceRepository;


    @RequestMapping(value = "/putDTO", method = RequestMethod.PUT, produces = "application/json")
    public String importToDb() {

        System.out.println("intra aici");
        invoiceRepository.save(new Invoice("22","123","33",1));
        System.out.println("iese din metoda save");
        return "S-a inserat";

    }

    @RequestMapping(value = "/getDTO", method = RequestMethod.GET)
    public ResponseEntity getToDb() {

      Iterable<Invoice> invoice=  invoiceRepository.findAll();

      InvoiceDto response= new InvoiceDto();

      for(Invoice inv:invoice){
          response.setId(inv.getId());
          response.setIssue(inv.getIssue());
          response.setNr(inv.getNr());
          response.setTotal(inv.getTotal());
      }
        System.out.println(response);
      return ResponseEntity.ok(response);

    }


}
