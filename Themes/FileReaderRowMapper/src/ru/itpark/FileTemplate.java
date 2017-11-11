package ru.itpark;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Класс, который шаблонно умеет оперирвать с файлами
public class FileTemplate {
  // читалка потоков
  private BufferedReader reader;

  // принимает на вход имя файла
  public FileTemplate(String dataSource) {
    try {
      // создаем объект Reader
      this.reader = new BufferedReader(
          new FileReader(dataSource)
      );
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
  }

  // шаблонная функция для построчного чтения
  // из файла и возврата списка объектов
  public <T> List<T> findAll(RowMapper<T>  rowMapper) {
    List<T> result = new ArrayList<>();

    try {
      String row = reader.readLine();
      while (row != null) {
        // для каждой строки применяем функцию
        // отображения строки в объект типа T
        T element = rowMapper.mapRow(row);
        result.add(element);
        row = reader.readLine();
      }
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }

    return result;
  }
}
