package project.truckio.web.filter;

import org.springframework.context.annotation.Profile;
import project.truckio.model.Klient;
import project.truckio.model.Vraboten;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Klient klient = (Klient) request.getSession().getAttribute("klient");
        Vraboten vraboten = (Vraboten) request.getSession().getAttribute("vraboten");

        String path = request.getServletPath();

        if( !path.equals("/home") && !path.equals("/login") && !path.equals("/register") &&
                !path.startsWith("/webjars/") && !path.startsWith("/img/") && !path.startsWith("/css/style.css") &&
                (klient==null && vraboten==null)) {
            response.sendRedirect("/login");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
