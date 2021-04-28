package driver;

import frontcontroller.FrontController;
import io.javalin.Javalin;
/*=======================================================================
| Source code:  MainDriver.java
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
|  Description: The goal of this program is to be the middle end of the
|               the Expense Reimbursement System web application. As of
|               now, this Java application is only interacting with the
|               back end which is a Postgresql Database. With this implementation
|               the DAO Pattern will be implemented for separation of concern.
|               Along with the DAO classes, a Service layer will be the only
|               one interacting with the DAO. Along side this layer, the Model
|               layer will be representing the database tables.
|
|               Project update: While still having the role of the middle end
|               this program now runs as the server with the help of the Javalin framework.
|               With this implemented framework, the app now introduces the Front Controller
|               design pattern to handle routes and session handler for the website.
|
| Process:  [Names of standard algorithms employed, explanations
|                 of why things were done they way they were done, etc.
|                 This is the place for technical information that another
|                 programmer would like to know.]
|
| Required Features Not Included: Most of the basic functionality (mvp) was
|                   completed which was to create user, create reimbursements
|                   and update reimbursements.
|
| Known Bugs: Currently the website is facing an issue when a manager is resolving
|             a reimbursement. It seems that the Context sessionAttributes does
|             not work appropriately IF the user is a manager.
|
|*===========================================================================*/
public class MainDriver {

    /**
     * the main method will construct a Javalin object to trigger
     * the functionalities which will be passed on to the FrontController.
     * Also it will add the front end of the app as static files located
     * in the resource folder.
     *
     * @param args [n/a]
     */
    public static void main(String[] args) {

        Javalin app = Javalin.create(
                config -> {
                   config.addStaticFiles("/website");
                }
        ).start(9001);

        FrontController frontController = new FrontController(app);
    }
}
