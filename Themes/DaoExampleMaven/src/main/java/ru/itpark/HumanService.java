package ru.itpark;

public class HumanService {

  private HumansDao humansDao;

  public HumanService(HumansDao humansDao) {
    this.humansDao = humansDao;
  }

  public void registerUser(Human user) {
    // смотрим, нет ли человека с таким именем,
    String name = user.getName();

    Human existingHuman = humansDao.findOneByName(name);

    if (existingHuman != null) {
      // если есть - выбрасываем ошибку, если нет - сохраняем
      throw new IllegalArgumentException("Already exist");
    }

    humansDao.save(user);

  }
}
