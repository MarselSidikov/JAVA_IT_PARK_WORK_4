package ru.itpark.app.services;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FilesStorageService {
  String saveFile(MultipartFile file);
  void writeFileToResponse(String fileName, HttpServletResponse response);

  String saveImage(Authentication authentication, MultipartFile file);
}
