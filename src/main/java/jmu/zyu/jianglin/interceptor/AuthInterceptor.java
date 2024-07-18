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
        return true;  //debug时可以一律为true
//        String uri = request.getRequestURI();
//        String method = request.getMethod();
//
//
//        if ("/".equals(uri) || "/login".equals(uri)) {
//            System.out.println("ovo ok gogogogo");
//            return true;
//        }
//
//        if (userService.isAdmin(request.getSession())) {
//            return true;
//        }
//        // 跟路由测试页面和登录页面 对所有用户开放
//        // 管理员用户（使用后台的店家） 开放所有权限
//        // -------------------------------------
//        // 普通用户（顾客）做限制
//
//        // 除了template和tableinfo开头的接口，其他所有的实体类controller 都默认允许get方法
//        if ( !uri.startsWith("/template") && !uri.startsWith("/tableinfo")  ) {
//            if ( "GET".equalsIgnoreCase(method)) {
//                return true;
//            }
//        }
//
//        // 其余的都不允许，
//        // 即： 不允许游客访问template, tableinfo
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write("{\"message\":\"Request failed, no permission\"}");
//        return false;
    }
}
