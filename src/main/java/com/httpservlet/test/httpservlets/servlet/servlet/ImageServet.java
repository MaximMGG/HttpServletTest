package com.httpservlet.test.httpservlets.servlet.servlet;

import java.io.IOException;
import java.io.InputStream;

import com.httpservlet.test.httpservlets.servlet.service.ImageService;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

@WebServlet("/images/*")
public class ImageServet extends HttpServlet {

    private final ImageService imageService = ImageService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String imagePath = requestURI.replace("/images", "");

        imageService.get(imagePath)
                    .ifPresentOrElse(image -> {
                        resp.setContentType("application/octet-stream");
                        writeImage(image, resp);
                    }, () -> resp.setStatus(404));
    }

    @SneakyThrows
    private void writeImage(InputStream image, HttpServletResponse resp) {
        try (image; ServletOutputStream outputStream = resp.getOutputStream()) {
            int currentByne;
            while ((currentByne = image.read()) != -1) {
                outputStream.write(currentByne);
            }
        }
    }


    
}
