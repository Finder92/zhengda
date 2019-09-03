package com.yckj.modules.megvii.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName HttpClientFilter
 * @Description TODO
 * @Author Finder
 * @Date 2019/7/29 14:39
 **/
@Slf4j
@Configuration
@WebFilter(filterName = "httpclientFilter",urlPatterns = "/*")
public class HttpClientFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain){
        try {
            filterChain.doFilter(servletRequest,servletResponse);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            HttpServletRequest httpServletRequest =(HttpServletRequest) servletRequest;
            log.info("httpServletRequest.getQueryString():{},httpServletRequest.getRequestURI():{}",httpServletRequest.getQueryString(),httpServletRequest.getRequestURI());
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
