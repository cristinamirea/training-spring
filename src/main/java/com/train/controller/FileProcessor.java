package com.train.controller;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.io.File;

public class FileProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().getBody(File.class);

        String nume = exchange.getIn().getHeader(Exchange.FILE_NAME_ONLY,String.class);
        nume= nume.replace(".txt",".csv");
        exchange.getIn().setHeader(Exchange.FILE_NAME_ONLY,nume);
    }
}