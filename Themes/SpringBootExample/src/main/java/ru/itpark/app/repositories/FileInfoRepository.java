package ru.itpark.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.app.models.FileInfo;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
  FileInfo findOneByStorageFileName(String fileName);
}
