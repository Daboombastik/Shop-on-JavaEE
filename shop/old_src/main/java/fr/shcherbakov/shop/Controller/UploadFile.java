package fr.shcherbakov.shop.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/uploadFile")
@MultipartConfig(location = "",
                 maxFileSize = 0,
                 maxRequestSize = 0,
                 fileSizeThreshold = 0)
public class UploadFile extends HttpServlet {
    fr.shcherbakov.shop.Model.UploadFile uploadFile;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        uploadFile = new fr.shcherbakov.shop.Model.UploadFile();
        uploadFile.mapFile(request);
        uploadFile.mapDescription(request);
        request.setAttribute("uploadFile", uploadFile);

        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
