package fr.shcherbakov.shop.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Enumeration;

public class Client implements Serializable {

    private Long id;
    private String name;
    private String email;
    transient private String password;
    private Timestamp dateInscription;

    public Timestamp getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Timestamp dateInscription) {
        this.dateInscription = dateInscription;
    }
    private String surname;
    private String address;
    private String phone;

    private static final long serialVersionUID = 1234L;

    public Client() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public void mapClient (HttpServletRequest request) {
//        Enumeration<String> params = request.getParameterNames();
//        while (params.hasMoreElements()) {
//            String temp = params.nextElement();
//            switch (temp) {
//                case "clientFName":
//                    setName(request.getParameter(temp));
//                    break;
//                case "clientLName":
//                    setSurname(request.getParameter(temp));
//                    break;
//                case "clientAddress":
//                    setAddress(request.getParameter(temp));
//                    break;
//                case "clientPhoneNumber":
//                    setPhone(request.getParameter(temp));
//                    break;
//                case "clientEmail":
//                    setEmail(request.getParameter(temp));
//                    break;
//                case "clientPassword":
//                    setPassword(request.getParameter(temp));
//                    break;
//            }
//        }
//    }

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
