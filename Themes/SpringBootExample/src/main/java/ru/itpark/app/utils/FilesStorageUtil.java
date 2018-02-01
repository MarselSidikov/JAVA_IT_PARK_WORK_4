package ru.itpark.app.utils;

import lombok.SneakyThrows;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.itpark.app.models.FileInfo;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class FilesStorageUtil {
  @Value("${storage.path}")
  private String storagePath;

  @SneakyThrows
  public void copyToStorage(MultipartFile file, String storageFileName) {
    Files.copy(file.getInputStream(), Paths.get(storagePath, storageFileName));
  }

  public FileInfo convertFromMultipart(MultipartFile file) {
    String storageName = createStorageName(file.getOriginalFilename());
    String fileUrl = getFileUrl(storageName);
    return FileInfo.builder()
        .originalFileName(file.getOriginalFilename())
        .size(file.getSize())
        .type(file.getContentType())
        .storageFileName(storageName)
        .url(fileUrl)
        .build();
  }

  private String getFileUrl(String storageFileName) {
    return storagePath + "/" + storageFileName;
  }

  private String createStorageName(String originalName) {
    String extension = FilenameUtils.getExtension(originalName);
    String newFileName = UUID.randomUUID().toString().replace("-", "");
    return newFileName + "." + extension;
  }

}
