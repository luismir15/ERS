package services;

import dao.UserDaoImpl;
import models.User;

import java.util.List;

/*=======================================================================
| Source code:  Sample.java 
|
| Author: Luis Miranda
| Assignment: Project 1
|
| Instructor: Trevin Chester  
| Due Date: April 2, 2021, start of day
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	Luis Miranda [Signature]
|  
| Language:  Java
|
| Purpose:  This public interface implements the DAO (Data Access Object) Pattern
|           which is implemented for the User Model. Simple CRUD methods
|           will be operating.
|*===========================================================================*/
public class UserServiceImpl implements UserService {

    UserDaoImpl userDao = new UserDaoImpl();

    /**
     * Insert user to ers_users
     *
     * @param user     user
     */
    public void createUser(User user) {

        userDao.insertUser(user);
    }

    /**
     * Insert user to ers_users
     *
     * @param user     user
     * @param userType
     */
    @Override
    public void createUser(User user, String userType) {

        userDao.insertUser(user, userType);
    }

    /**
     * Select all the user from ers_users
     *
     * @return list of users
     */
    @Override
    public List<User> getAllUsers() {

        return userDao.selectAllUsers();
    }

    /**
     * Select a specific user by their username
     *
     * @param username unique
     * @return user
     */
    @Override
    public User getUserByUsername(String username) {

        return userDao.selectUserByUsername(username);
    }

    @Override
    public String getUserRole(String role) {

        return userDao.selectUserType(role);
    }

    public boolean checkUsernameAndPassword(User user) {

        return userDao.selectUserAndPassword(user);
    }

    /**
     * update ers_user
     *
     * @param user user
     * @return true or false
     */
    @Override
    public void updateUser(User user) {

        userDao.updateUser(user);
    }

    /**
     * delete ers_user
     *
     * @param user user
     * @return true or false
     */
    @Override
    public void deleteUser(User user) {

        userDao.deleteUser(user);
    }
}
