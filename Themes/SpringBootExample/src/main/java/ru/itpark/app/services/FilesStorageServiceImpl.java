package ru.itpark.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itpark.app.models.FileInfo;
import ru.itpark.app.repositories.FileInfoRepository;
import ru.itpark.app.utils.FilesStorageUtil;

import javax.servlet.http.HttpServletResponse;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {

  @Autowired
  private FilesStorageUtil filesStorageUtil;

  @Autowired
  private FileInfoRepository fileInfoRepository;

  @Override
  public String saveFile(MultipartFile file) {
    FileInfo fileInfo = filesStorageUtil.convertFromMultipart(file);
    fileInfoRepository.save(fileInfo);
    filesStorageUtil.copyToStorage(file, fileInfo.getStorageFileName());
    return fileInfo.getStorageFileName();
  }

  @Override
  public void writeFileToResponse(String fileName, HttpServletResponse response) {

  }
}
