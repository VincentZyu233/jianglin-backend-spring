package jmu.zyu.jianglin.interceptor;

import jmu.zyu.jianglin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        String method = request.getMethod();

        // Allow access to root and login pages
        if ("/".equals(uri) || "/login".equals(uri)) {
            System.out.println("ovo ok gogogogo");
            return true;
        }

        // Allow GET requests to paths starting with /product or /banner
        if ( uri.startsWith("/product")  && "GET".equalsIgnoreCase(method)) {
            return true;
        }

        if ( uri.startsWith("/banner") && "GET".equalsIgnoreCase(method)) {
            return true;
        }

        // Allow access to admin users
        if (userService.isAdmin(request.getSession())) {
            return true;
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("{\"message\":\"Request failed, no permission\"}");

        return false;
    }
}
