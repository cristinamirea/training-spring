package com.train.controller;

import com.train.entity.Invoice;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Headers;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;

@Component
public class MyCamelRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
//        from("timer:hello?period={{timer.period}}").routeId("hello").routeGroup("hello-group")
//                .transform().method("myBean", "saySomething")
//                .filter(simple("${body} contains 'foo'"))
//                .to("log:foo")
//                .end()
//                .to("stream:out");
//    }

        from("file:///Users/user/camel?recursive=true")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        exchange.getIn().getHeader(Exchange.FILE_NAME_ONLY);
                    }
                })
                .to("file:///Users/user/Documents");

//Here is a typical Camel Route used to poll a directory for input files on every second.
//
//        from("file:////Users/user/Documents/testeCamel/camel?delay=1000")
//                .process(new Processor() {
//                    @Override
//                    public void process(Exchange exchange) throws Exception {
//                        exchange.getIn().getBody(File.class);
//
//
//                        String nume = exchange.getIn().getBody().getClass().getName();
////                        String extension = nume.split(".")[0];
//                        String extension= nume.substring(0, nume.lastIndexOf('.'));
//                       if(extension.equals("txt")){
//                            // to do transform in csv and change name and put a row in file
//                            extension = "csv";
//                            nume =nume.concat("_C");
//                            nume= nume.concat(extension);
//
//                        }
//
//                    }
//                })
//                .to("file:////Users/user/Documents/testeCamel/camel2");
//
//    }
//        @Autowired
//        public ConsumerTemplate consumerTemplate;

        from("file:///Users/user/Documents/testeCamel/camel?delay=1000&antInclude=*.txt&recursive=true")
                .process(new FileProcessor() {

                             // vaianta andrei
                             @Override
                             public void process(Exchange exchange) throws Exception {
//                                 exchange.getIn().getBody(File.class);

                                 String nume = exchange.getIn().getHeader(Exchange.FILE_NAME_ONLY, String.class);
                                 nume = nume.replace(".txt", ".csv");
                                 exchange.getIn().setHeader(Exchange.FILE_NAME_ONLY, nume);
//                                 Invoice invoice = consumerTemplate.receiveBody("jms:invoices", Invoice.class);
                                 byte[] body = exchange.getIn().getBody(byte[].class);
                                 exchange.getOut().setBody(("am modificat bodyul" + new String(body)).getBytes());


//                                 String body2 = exchange.getOut().getBody(String.class);
//                                 assertTrue(body2.endsWith("<goodbye>world!</goodbye>"));

                             }

                         }


                ).to("file:///Users/user/Documents/testeCamel/camel2");


    }
}


