package com.mycompany.processor;

import java.util.Date;
import javax.inject.Named;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * https://logging.paluch.biz/examples/log4j-1.2.x-json.html
 *
 * @author david
 */
@Slf4j
@Named(SimpleProcessor.NAME)
public class SimpleProcessor implements Processor {

    public static final String NAME = "simpleProcessor";

    @Override
    public void process(Exchange exchange) throws Exception {

        log.info("Simple message at " + new Date());
    }
}
