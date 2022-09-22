package com.genesys.api.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import com.genesys.api.controller.MovilController;

import java.util.UUID;

@Component 
@WebFilter( filterName = "mdcFilter", urlPatterns = { "/*" } )
public class MDCFilter implements Filter  {
	private static final Logger logger = LogManager.getLogger(MDCFilter.class);
    @Override
    public void destroy() {
    }
 
    @Override
    public void doFilter( final ServletRequest request, 
    			final ServletResponse response, final FilterChain chain )
        throws IOException, ServletException {
    	//logger.info("conversionId: " +request.getParameter("conversionId"));
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