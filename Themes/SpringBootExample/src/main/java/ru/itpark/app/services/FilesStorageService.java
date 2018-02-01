package ru.itpark.app.services;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FilesStorageService {
  String saveFile(MultipartFile file);
  void writeFileToResponse(String fileName, HttpServletResponse response);
}
