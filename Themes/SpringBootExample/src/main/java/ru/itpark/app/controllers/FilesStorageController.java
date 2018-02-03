package ru.itpark.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itpark.app.services.FilesStorageService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class FilesStorageController {

  @Autowired
  private FilesStorageService storageService;

  @PostMapping(value = "/images")
  @ResponseBody
  public String handleImageUpload(@RequestParam("file") MultipartFile file) {
    return storageService.saveImage(file);
  }

  @PostMapping(value = "/files")
  @ResponseBody
  public String handleFileUpload(@RequestParam("file") MultipartFile file) {
    return storageService.saveFile(file);
  }

  @GetMapping(value = "/files/{file-name:.+}")
  public void getFile(@PathVariable("file-name") String fileName,
                      HttpServletResponse response) {
    storageService.writeFileToResponse(fileName, response);
  }
}
