package com.genesys.api.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component 
@WebFilter( filterName = "mdcFilter", urlPatterns = { "/*" } )
public class MDCFilter implements Filter  {
 
    @Override
    public void destroy() {
    }
 
    @Override
    public void doFilter( final ServletRequest request, 
    			final ServletResponse response, final FilterChain chain )
        throws IOException, ServletException {
 
        MDC.put( "UUid", UUID.randomUUID().toString());
 
        try {
            chain.doFilter( request, response );
        } finally {
            MDC.clear();
        }
    }
 
    @Override
    public void init( final FilterConfig filterConfig ) 
    	throws ServletException {
    }
}