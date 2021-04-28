package dao;

import models.User;


import java.util.List;

/**
 * This public interface implements the DAO (Data Access Object) Pattern
 * which is implemented for the User Model. Simple CRUD methods
 * will be operating.
 */
public interface UserDao {

    /**
     * Insert user to ers_users
     *
     * @param user user
     */
    public void insertUser(User user);

    /**
     * Insert user to ers_users
     *
     * @param user user
     */
    public void insertUser(User user, String userType);

    /**
     * Select all the user from ers_users
     *
     * @return list of users
     */
    public List<User> selectAllUsers();

    /**
     * Select a specific user by their username
     *
     * @param username unique
     *
     * @return user
     */
    public User selectUserByUsername(String username);

    public String selectUserType(String type);

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
