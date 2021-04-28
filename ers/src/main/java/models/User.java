package models;

/*=======================================================================
| Source code:  User.java
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
| Purpose: The purpose of this class is to serve as the Physical Model
|          for the user table.
| *===========================================================================*/
public class User {

    private int userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private int roleId;
    private String roleType;

    /**
     * No args constructor.
     */
    public User() {

    }

    public User( String username, String password, String firstName, String lastName, String email, String roleType) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roleType = roleType;
    }

    /**
     * Constructor to define all fields except id.
     * @param username unique
     * @param password user
     * @param firstName user
     * @param lastName user
     * @param email user
     * @param roleId employee or manager
     */
    public User(String username, String password, String firstName, String lastName, String email, int roleId) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roleId = roleId;
    }

    public User( String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(int userId, String username, String password, String firstName, String lastName, String email,
                String roleType) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roleType = roleType;
    }

    /**
     * Constructor to define all fields.
     * @param userId unique
     * @param username unique
     * @param password user
     * @param firstName user
     * @param lastName user
     * @param email user
     * @param roleId employee or manager
     */
    public User(int userId, String username, String password, String firstName, String lastName, String email,
                int roleId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roleId = roleId;
    }

    /**
     * Accessor
     *
     * @return int
     */
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Accessor
     *
     * @return String
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Accessor
     *
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Mutator
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Accessor
     *
     * @return String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Mutator
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Accessor
     *
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Mutator
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Accessor
     *
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Mutator
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Accessor
     *
     * @return int
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Mutator
     *
     * @param roleId
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", roleType='" + roleType + '\'' +
                '}';
    }
}
