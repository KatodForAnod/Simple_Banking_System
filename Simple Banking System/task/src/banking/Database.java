package banking;

import java.util.List;

public interface Database {
    public List<User> getUsers();

    public boolean addUser(User user);
}
