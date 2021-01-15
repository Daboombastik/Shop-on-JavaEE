package fr.shcherbakov.shop.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.regex.Pattern;

public class SignUp {

    public boolean authMail(HttpServletRequest request) {
        String email = request.getParameter("email");
            return isMailValid(email);
    }

    public boolean authUser(HttpServletRequest request) {
        return false;
    }

    public boolean authPassword(HttpServletRequest request) {
        return false;
    }

    private boolean isMailValid(String email) {
        Pattern pattern = Pattern.compile("^[A-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[A-Z0-9.-]+$");
        return pattern.matcher(email).matches();
    }
}