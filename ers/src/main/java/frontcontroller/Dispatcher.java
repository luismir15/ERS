package frontcontroller;

import controller.ReimbursementController;
import controller.UserController;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Dispatcher {

    UserController userController;

    /**
     * Constructor that will set up all of the routes
     * for the website
     *
     * @param app obj
     */
    public Dispatcher(Javalin app) {

        setupAllPaths(app);
    }

    /**
     * Set up paths for user and reimbursements
     *
     * @param app obj
     */
    public static void setupAllPaths(Javalin app) {

        setupUserPaths(app);
        setupReimbursementPaths(app);
    }

    /**
     * Set up the user path. this method will add
     * the functionality for any user to login, register,
     * and logout
     *
     * @param app obj
     */
    public static void setupUserPaths(Javalin app) {

        app.routes(() -> {
            path("/api", () -> {
                post(UserController::loginUser);
                get(UserController::getUser);
            });
            path("/api/registration", () -> {
               post(UserController::createUser);
            });
            path("/api/logout", () -> post(UserController::logoutUser));
        });
    }

    /**
     * Set up the reimbursements app. This method will give
     * the ability for the users to interact with the reimbursements
     *
     * @param app obj
     */
    public static void setupReimbursementPaths(Javalin app) {

        app.routes(() -> {
            path("/api/users/reimbursements", () -> {
                get(ReimbursementController::getReimbursement);
                path(":username", () -> get(ReimbursementController::getReimbursementByUsername));
                path("/get-reimbursement", () -> {
                    path(":id", () -> get(ReimbursementController::getReimbursementById));
                });
                path("/create-reimbursement", () -> post(ReimbursementController::createReimbursement));
                path("/edit-reimbursement", () -> post(ReimbursementController::updateReimbursement));
            });
        });
    }
}
