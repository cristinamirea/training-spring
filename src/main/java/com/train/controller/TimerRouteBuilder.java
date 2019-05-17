package com.train.controller;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Here is a typical Camel Route used to poll a directory for input files on every second.


public class TimerRouteBuilder extends RouteBuilder {
    static Logger LOG = LoggerFactory.getLogger(TimerRouteBuilder.class);
    public void configure() {
        from("timer://timer1?period=1000")
                .process(new Processor() {
                    public void process(Exchange msg) {
                        LOG.info("Processing {}", msg);
                    }
                });
    }
}