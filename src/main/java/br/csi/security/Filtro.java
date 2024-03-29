package br.csi.security;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class Filtro implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("************ filtro ************ ");

        String url = ((HttpServletRequest)servletRequest).getRequestURL().toString();
        System.out.println(url);

        if(((HttpServletRequest)servletRequest).getRequestURL().toString().equals("http://localhost:8080/app_farm/index/login")){
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (((HttpServletRequest)servletRequest).getRequestURL().toString().equals("http://localhost:8080/app_farm/index/criar")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (((HttpServletRequest)servletRequest).getRequestURL().toString().equals("http://localhost:8080/app_farm/index/logar")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else{
            HttpSession session = ((HttpServletRequest)servletRequest).getSession();

            if(session.getAttribute("usuario_logado") != null){
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
                httpResponse.sendRedirect("/app_farm/index/login");
                return;
            }
        }
    }
}
