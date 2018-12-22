package com.chunking.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="mailto:kingdom2232@sina.com">Jonas Wang</a>
 * @date 2018-12-22 21:19
 */
public class AccessFilter extends ZuulFilter{

    private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
        try {
            doSomething();
        } catch (Exception e) {
            throw new ZuulException(e, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            // ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            // ctx.set("error.exception", e);
        }
        // Object accessToken = request.getParameter("accessToken");
        // if (accessToken == null) {
        //     logger.warn("access token is empty");
        //     ctx.setSendZuulResponse(false);
        //     ctx.setResponseStatusCode(HttpServletResponse.SC_UNAUTHORIZED);
        //     return null;
        // }
        // logger.info("access token ok");
        return null;
    }


    private void doSomething() {
        //throw new RuntimeException("Exist some errors....");
    }
}
