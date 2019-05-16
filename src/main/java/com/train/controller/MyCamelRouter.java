package com.train.controller;

import org.apache.camel.Exchange;
import org.apache.camel.Headers;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

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
//                .routeId("hello").routeGroup("hello-group")
//                . transform()
//                .method("myBean", "saySomething")
//                .filter(simple("${body} contains 'foo'"))
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        exchange.getIn().getHeader(Exchange.FILE_NAME_ONLY);
                    }
                })
                .to("file:///Users/user/Documents");
//                .end();
//                .to("file://Users/user/Documents");

    }
}
