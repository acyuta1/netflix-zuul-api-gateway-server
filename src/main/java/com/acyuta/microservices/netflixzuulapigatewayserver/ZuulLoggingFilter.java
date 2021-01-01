package com.acyuta.microservices.netflixzuulapigatewayserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ZuulLoggingFilter extends ZuulFilter {


    /**
     * Should the filter be executed BEFORE (pre), AFTER (post) or ERROR (error)
     * @return String values between "pre"/"post"/"error"
     */
    @Override
    public String filterType() {
        return "pre"; // All requests before they are executed.
    }

    /**
     * Suppose we have multiple filters, we can set a priority order.
     * @return Integer indicating the priority.
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * Tells whether to execute this filter or not.
     * @return Boolean, indicating yes/no.
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        var request = RequestContext.getCurrentContext().getRequest(); // returns current http request.
        log.info("request -> {}, request-uri -> {}", request, request.getRequestURI());
        return null;
    }
}
