package ru.itpark;

public class HumanService {

  private UsersDao usersDao;

  public HumanService(UsersDao usersDao) {
    this.usersDao = usersDao;
  }

  public void registerUser(User user) {
    // смотрим, нет ли человека с таким именем,
    String name = user.getName();

    User existingUser = usersDao.findOneByName(name);

    if (existingUser != null) {
      // если есть - выбрасываем ошибку, если нет - сохраняем
      throw new IllegalArgumentException("Already exist");
    }

    usersDao.save(user);

  }
}
