public interface UserService {

    User save(User user);

    User getById(Long id);

    List<User> getAll();

    void delete(Long id);
}
