package com.httpservlet.test.httpservlets.servlet.service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import com.httpservlet.test.httpservlets.servlet.utils.PropertiesUtil;

import lombok.SneakyThrows;

public class ImageService {

    private static final ImageService INSTANCE = new ImageService();

    private final String basePath = PropertiesUtil.get("image.base.url");

    public static ImageService getInstance() {
        return INSTANCE;
    }

    private ImageService() {}

    @SneakyThrows
    public void upload(String imagePath, InputStream imageContent) {
        Path imageFullPath = Path.of(basePath + imagePath);
        try (imageContent) {
            Files.createDirectories(imageFullPath.getParent());
            Files.write(imageFullPath, imageContent.readAllBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }
    }
}
