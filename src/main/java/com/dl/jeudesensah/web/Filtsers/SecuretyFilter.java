package com.dl.jeudesensah.web.Filtsers;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "SecuretyFilter" , urlPatterns = {"/play" , "/gameover" })
public class SecuretyFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (request instanceof HttpServletRequest) {
            HttpServletRequest req = (HttpServletRequest) request;
            if (req.getSession().getAttribute("user") == null) {
                HttpServletResponse res = (HttpServletResponse) response;
                res.sendRedirect(req.getContextPath() + "/Login");
                return;
            }
        }
        chain.doFilter(request, response);
    }
}
