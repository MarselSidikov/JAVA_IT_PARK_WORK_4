package ru.itpark.app.utils;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
public class ImagesFilesValidator {
  private final List<String> IMAGE_TYPES = Lists.newArrayList(
      "image/jpeg", "image/png"
  );

  public void validate(MultipartFile file) {
    if (IMAGE_TYPES.indexOf(file.getContentType()) == -1) {
      throw new IllegalArgumentException("Bad image format");
    }
  }
}
