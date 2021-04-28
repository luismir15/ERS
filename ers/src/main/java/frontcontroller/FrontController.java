package frontcontroller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.User;

/**
 * The front controller will take the initial app from the main method
 * which it will then be passed on to the Dispatcher. Another role
 * for the front controller is that will be the security of the website
 * ensuring that each user does there role correctly.
 */
public class FrontController {

    Javalin app;
    Dispatcher dispatcher;

    /**
     * Constructor to trigger the before() method
     * and pass the app to the dispatcher.
     *
     * @param app obj
     */
    public FrontController(Javalin app) {

        this.app = app;
        app.before("*", FrontController::checkAllRequest);
        dispatcher = new Dispatcher(app);
    }

    /**
     * Verify the user
     *
     * @param context app
     */
    public static void checkAllRequest(Context context) {

        if (!context.path().equals("/api/api/users/reimbursements") && context.path().contains("api/")) {

            User user = context.sessionAttribute("currentUser");
        }
    }
}
