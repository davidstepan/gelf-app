package com.mycompany.api;

import static com.mycompany.GelfApp.CAMEL_CONTEXT_NAME;
import com.mycompany.processor.SimpleProcessor;
import javax.enterprise.context.ApplicationScoped;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.apache.camel.model.rest.RestBindingMode;

/**
 * @author david
 */
@ApplicationScoped
@ContextName(CAMEL_CONTEXT_NAME)
public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        /**
         * Configure Camel REST to use the camel-undertow component
         */
        restConfiguration()
            .bindingMode(RestBindingMode.json)
            .component("undertow")
            .contextPath("gelfapp/api/v1")
            .enableCORS(true)
            .apiProperty("api.title", "WildFly Camel REST API")
            .apiProperty("api.version", "1.0")
            .apiContextPath("swagger");

        /**
         * Configure REST API with a base path of /customers
         */
        rest("/test")

            .get()
                .route()
                    .process(SimpleProcessor.NAME)
                .endRest();
    }
}
