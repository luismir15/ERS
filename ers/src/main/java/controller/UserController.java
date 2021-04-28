package controller;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import models.User;
import org.jetbrains.annotations.NotNull;
import services.ReimbursementServiceImpl;
import services.UserServiceImpl;
import java.util.ArrayList;
import java.util.List;

/**
 * The user controller will serve as the requests
 * handler for each route. each method will user the
 * User Service.
 */
public class UserController {

    private static UserServiceImpl userService = new UserServiceImpl();
    private static List<User> userList= new ArrayList<>();

    /**
     * get all the users
     *
     * @param context app
     */
    public static void getAllUsers(Context context) {

        context.json(userService.getAllUsers());
    }

    /**
     * get user by username. this will use the path param
     *
     * @param context app
     */
    public static void getUserByUsername(Context context) {

        String username = context.pathParam("username");
        context.json(userService.getUserByUsername(username));
    }

    /**
     * When the user is registering, this handler
     * will trigger.
     *
     * @param context app
     */
    public static void createUser(Context context) {

        System.out.println("\ncreate user handler has fired");
        User newUser = context.bodyAsClass(User.class);

        System.out.println("\ncreating user");
        System.out.println(newUser.toString());

        System.out.println("\ninserting user to table");
        userService.createUser(newUser);

        context.json(newUser).status(201);
    }

//    public static void loginUser(Context context) {
//
//        System.out.println("login handler has fired");
//
//        String username = context.formParam("user");
//        String password = context.formParam("password");
//        System.out.println("\ncreating User object from user input: {" + "username: " + username + ", password: " + password + "}");
//
//
//        //verify if the credentials are valid
//        System.out.println("\nverifying credentials");
//        User userInput = new User();
//        userInput.setUsername(username);
//        userInput.setPassword(password);
//
//        if (userService.checkUsernameAndPassword(userInput)) {
//
//            System.out.println("\ncorrect credentials");
//
//            //creating user from input
//            System.out.println("\ncreating user");
//            User loginUser = userService.getUserByUsername(username);
//            System.out.println(loginUser.toString());
//            context.sessionAttribute("currentUser", loginUser);
//
//            System.out.println("\nverifying user role");
//
//            String userRole = loginUser.getRoleType();
//
//            if (userRole.equals("employee")) {
//
//                System.out.println("\nthe user is an employee");
//                System.out.println("redirecting to employee dashboard");
//                context.redirect("/employee/employee-dashboard.html");
//            }
//
//        }
//    }

    /**
     * Get user according to the sessionAttribute
     *
     * @param context app
     */
    public static void getUser(Context context) {

        System.out.println("\ngetting user");
        User user = context.sessionAttribute("currentUser");
        System.out.println("session: " + context.req.getSession().toString());

        if (user == null) {

            System.out.println("no user loggedin");
        }

        else {

            context.json(user);
        }
    }

    /**
     * When the handler fires it will set the session
     * attribute at null throwing it to the garbage collector
     *
     * @param context obj
     */
    public static void logoutUser(Context context) {

        System.out.println("logout handler has fired");
        context.sessionAttribute("currentUser", null);
        System.out.println("succesfully logged out");
        context.redirect("/index.html");
    }

    /**
     * When the user logins this method handler will
     * fire. the login will take the context body
     * as class to get the username and password
     * to use the userservice to verify if they exist
     *
     * @param context
     */
    public static void loginUser(Context context) {

        System.out.println("login handler has fired");

        User user = context.bodyAsClass(User.class);
        System.out.println("\ncreating User object from user input: {" + "username: " + user.getUsername() +
                ", password: " + user.getPassword() + "}");

        //verify if the credentials are valid
        System.out.println("\nverifying credentials");

        if (userService.checkUsernameAndPassword(user)) {

            System.out.println("\ncorrect credentials");

            //creating user from input
            System.out.println("\ncreating user");
            User loginUser = userService.getUserByUsername(user.getUsername());
            System.out.println(loginUser.toString());
            context.sessionAttribute("currentUser", loginUser);

            System.out.println("\nverifying user role");

            String userRole = loginUser.getRoleType();

            if (userRole.equals("employee")) {

                System.out.println("\nthe user is an employee");
                System.out.println("redirecting to employee dashboard");
                context.result(userRole);
            }

            else {

                System.out.println("\nthe user is a manager");
                System.out.println("redirecting to the manager dashboard");
                context.result(userRole);
            }
        }
        else {

            context.result("false");
        }
    }

    public static Handler getHandlerReference() {

        return new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {

                ctx.json(userList);
            }
        };
    }
}
