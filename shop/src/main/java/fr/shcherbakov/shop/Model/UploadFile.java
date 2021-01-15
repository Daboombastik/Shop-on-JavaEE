package fr.shcherbakov.shop.Model;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class UploadFile {

    String file;
    String description;

    public UploadFile() {
    }

    public void mapDescription(HttpServletRequest request) {
        setFile(request.getParameter("description"));
    }
    public void mapFile(HttpServletRequest request) {
        setFile(request.getParameter("file"));
    }


    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
