package fr.shcherbakov.shop.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class Client {

    String name;
    String surname;
    String address;
    String phone;
    String email;

    public Client() {
    }

    public void mapClient (HttpServletRequest request) {
        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String temp = params.nextElement();
            switch (temp) {
                case "clientName":
                    setName(request.getParameter(temp));
                    break;
                case "clientSurname":
                    setSurname(request.getParameter(temp));
                    break;
                case "clientAddress":
                    setAddress(request.getParameter(temp));
                    break;
                case "clientPhoneNumber":
                    setPhone(request.getParameter(temp));
                    break;
                case "clientEmail":
                    setEmail(request.getParameter(temp));
                    break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
