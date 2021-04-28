package dao;

import models.User;
import static util.DataBaseConnector.*;

import java.sql.*;
import java.util.ArrayList;
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
| Purpose: The purpose of this class is to connect directly to the database
|          and implement the dao interface with the respected model.
|
| Inherits From: None.
|
| Interfaces: UserDao.
| *===========================================================================*/
public class UserDaoImpl implements UserDao {

    /**
     * this method will insert the type of user role
     * in ers_user_role which will generate a primary key.
     * the goal is to insert this primary key in the ers_user
     * table in user_role_id column
     *
     * @param type employee or manager
     *
     * @return user role primary key
     */
    private int insertUserRole(String type) {

        int userRoleId = 0;

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            String sql = "INSERT INTO ers_user_roles(user_role) VALUES (?);";

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, type);     //the 1st "?"

            ps.executeUpdate();

            //PRINTING THE PRIMARY KEY
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("The returned PK: "+ rs.getInt("ers_user_role_id"));
                userRoleId = rs.getInt("ers_user_role_id");
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return userRoleId;
    }

    @Override
    public void insertUser(User user) {

        int userRoleId = insertUserRole(user.getRoleType());

        try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)){

            String sql = "INSERT INTO ers_users(ers_username, ers_password, user_first_name, user_last_time, user_email, user_role_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());//the 1st "?"
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getEmail());
            ps.setInt(6, userRoleId);

            ps.executeUpdate();

            //PRINTING THE PRIMARY KEY
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("The returned PK: "+ rs.getInt("ers_user_id"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Insert user to ers_users
     *
     * @param user user
     */
    @Override
    public void insertUser(User user, String userType) {

        int userRoleId = insertUserRole(userType);

        try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)){

            String sql = "INSERT INTO ers_users(ers_username, ers_password, user_first_name, user_last_time, user_email, user_role_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());//the 1st "?"
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getEmail());
            ps.setInt(6, userRoleId);

            ps.executeUpdate();

            //PRINTING THE PRIMARY KEY
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("The returned PK: "+ rs.getInt("ers_user_id"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Select all the user from ers_users
     *
     * @return list of users
     */
    @Override
    public List<User> selectAllUsers() {

        List<User> userList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            String sql = "SELECT * FROM ers_users";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                userList.add(
                        new User(
                                rs.getInt(1)
                                , rs.getString(2)
                                , rs.getString(3)
                                , rs.getString(4)
                                , rs.getString(5)
                                , rs.getString(6)
                                , rs.getInt(7)
                        )
                );
            }
        }

        catch (SQLException e) {

            e.printStackTrace();
        }

        return userList;
    }

    /**
     * Select a specific user by their username
     *
     * @param username unique
     * @return user
     */
    @Override
    public User selectUserByUsername(String username) {

        User ersUser = new User();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            //String sql = "SELECT ers_username FROM ers_users WHERE ers_username = ?";
            String sql = "SELECT * FROM user_join WHERE username = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                ersUser.setUserId(rs.getInt(1));
                ersUser.setUsername(rs.getString(2));
                ersUser.setPassword(rs.getString(3));
                ersUser.setFirstName(rs.getString(4));
                ersUser.setLastName(rs.getString(5));
                ersUser.setEmail(rs.getString(6));
                ersUser.setRoleType(rs.getString(7));
            }
        }

        catch (SQLException e) {

            e.printStackTrace();
        }

        return ersUser;
    }

    @Override
    public String selectUserType(String type) {

        String role = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            //String sql = "SELECT ers_username FROM ers_users WHERE ers_username = ?";
            String sql = "SELECT role FROM user_join WHERE username = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, type);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                type = rs.getString(1);
            }
        }

        catch (SQLException e) {

            e.printStackTrace();
        }

        return type;
    }

    public boolean selectUserAndPassword(User user) {

        try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)){

            String sql = "SELECT ers_username, ers_password FROM ers_users WHERE ers_username = ? AND ers_password = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            ps.executeQuery();

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return true;
            }

        } catch(SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    /**
     * update ers_user
     *
     * @param user user
     * @return true or false
     */
    @Override
    public void updateUser(User user) {
    }

    /**
     * delete ers_user
     *
     * @param user user
     * @return true or false
     */
    @Override
    public void deleteUser(User user) {
    }
}
