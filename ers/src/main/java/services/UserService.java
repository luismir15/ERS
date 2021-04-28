package services;

import models.User;

import java.util.List;

/**
 * This public interface implements the DAO (Data Access Object) Pattern
 * which is implemented for the User Model. Simple CRUD methods
 * will be operating.
 */
public interface UserService {

    /**
     * Insert user to ers_users
     *
     * @param user user
     */
    public void createUser(User user, String userType);

    /**
     * Select all the user from ers_users
     *
     * @return list of users
     */
    public List<User> getAllUsers();

    /**
     * Select a specific user by their username
     *
     * @param username unique
     *
     * @return user
     */
    public User getUserByUsername(String username);

    public String getUserRole(String role);

    /**
     * update ers_user
     *
     * @param user user
     *
     * @return true or false
     */
    public void updateUser(User user);

    /**
     * delete ers_user
     *
     * @param user user
     * @return true or false
     */
    public void deleteUser(User user);
}
