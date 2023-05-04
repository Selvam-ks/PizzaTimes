package com.order.PizzaService.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        String authHeader = httpServletRequest.getHeader("Authorization");
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED,"UNAUTHORIZED");
            servletOutputStream.print("Missing or Invalid Token");
            servletOutputStream.close();
        }else {
            String jwtToken = authHeader.substring(7);
           Claims username = Jwts.parser().setSigningKey("platinumSecretKey").parseClaimsJws(jwtToken).getBody();
            System.out.println(username);
            httpServletRequest.setAttribute("email",username.get("User_email"));
            httpServletRequest.setAttribute("role",username.get("User_Role"));
            System.out.println(httpServletRequest);
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}