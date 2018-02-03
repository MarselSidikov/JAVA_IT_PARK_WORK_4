package ru.itpark.app.services;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itpark.app.models.FileInfo;
import ru.itpark.app.repositories.FileInfoRepository;
import ru.itpark.app.utils.FilesStorageUtil;
import ru.itpark.app.utils.ImagesFilesValidator;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {

  @Autowired
  private FilesStorageUtil filesStorageUtil;

  @Autowired
  private FileInfoRepository fileInfoRepository;

  @Autowired
  private ImagesFilesValidator imagesFilesValidator;

  @Override
  public String saveFile(MultipartFile file) {
    FileInfo fileInfo = filesStorageUtil.convertFromMultipart(file);
    fileInfoRepository.save(fileInfo);
    filesStorageUtil.copyToStorage(file, fileInfo.getStorageFileName());
    return fileInfo.getStorageFileName();
  }

  @Override
  @SneakyThrows
  public void writeFileToResponse(String fileName, HttpServletResponse response) {
    FileInfo fileInfo = fileInfoRepository.findOneByStorageFileName(fileName);
    response.setContentType(fileInfo.getType());
    InputStream inputStream = new FileInputStream(new File(fileInfo.getUrl()));
    IOUtils.copy(inputStream, response.getOutputStream());
    response.flushBuffer();
  }

  @Override
  public String saveImage(MultipartFile file) {
    imagesFilesValidator.validate(file);
    return saveFile(file);
  }
}
