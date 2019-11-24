package com.mycompany;

import javax.inject.Inject;
import javax.inject.Named;
import org.apache.camel.CamelContext;
import org.apache.camel.cdi.ContextName;

/**
 * @author david
 */
@Named("gelf_app")
public class GelfApp {

    public static final String APPLICTION_NAME = "gelf-app";

    public static final String APPLICATION_VENDOR_ID = "com.mycompany";

    public static final String CAMEL_CONTEXT_NAME = "gelf-app-context";

    public static final String ERROR_LOG_URI = "log:errorLog?level=ERROR&showCaughtException=true&showStackTrace=true&showHeaders=true&showExchangeId=true";

    @Inject
    @ContextName(CAMEL_CONTEXT_NAME)
    private CamelContext context;
}
