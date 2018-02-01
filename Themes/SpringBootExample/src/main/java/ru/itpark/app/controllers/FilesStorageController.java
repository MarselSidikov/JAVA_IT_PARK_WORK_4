package ru.itpark.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import ru.itpark.app.services.FilesStorageService;

@Controller
public class FilesStorageController {

  @Autowired
  private FilesStorageService storageService;

  @PostMapping(value = "/files")
  @ResponseBody
  public String handleFileUpload(@RequestParam("file") MultipartFile file) {
    return storageService.saveFile(file);
  }

}
