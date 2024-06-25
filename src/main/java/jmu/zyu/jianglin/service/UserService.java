package jmu.zyu.jianglin.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;



@Service
public class UserService {
    public static final String USER_SESSION_KEY = "user";

    public boolean isAdmin(HttpSession session) {
        Object user = session.getAttribute(USER_SESSION_KEY);
        return user != null && "admin".equals(user);
    }

    public void login(HttpSession session, String username) {

        session.setAttribute(USER_SESSION_KEY, username);
    }

    public void logout(HttpSession session) {
        session.removeAttribute(USER_SESSION_KEY);
    }
}
