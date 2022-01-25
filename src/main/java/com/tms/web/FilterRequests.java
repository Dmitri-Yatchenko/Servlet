package com.tms.web;

import javax.servlet.*;
import java.io.IOException;

public class FilterRequests implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String id = servletRequest.getParameter("id");
        if (id.equals("")){
            servletRequest.getRequestDispatcher("/WEB-INF/pages/error.html").forward(servletRequest, servletResponse);
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
