package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;
import models.Reimbursement;
import models.User;
import services.ReimbursementServiceImpl;
import java.util.ArrayList;
import java.util.List;

/**
 * The reimbursement controller will serve as the requests
 * handler for each route. each method will user the
 * Reimbursement Service.
 */
public class ReimbursementController {

    private static ReimbursementServiceImpl reimbursementService = new ReimbursementServiceImpl();
    private static List<Reimbursement> reimbursementList = new ArrayList<>();

    /**
     * Load all the reimbursement
     *
     * @param context app
     */
    public static void getReimbursement(Context context) {
        System.out.println("getting user reimbursement information");
        //reimbursementList = reimbursementService.getReimbursementByUsername("luismir15");
        reimbursementList = reimbursementService.getAllReimbursement();
        System.out.println(reimbursementList);
        //context.result(reimbursementList.toString());
        context.json(reimbursementList);
    }

    /**
     * get reimbursement according to the specify user
     *
     * @param context
     * @throws JsonProcessingException
     */
    public static void getReimbursementByUsername(Context context) throws JsonProcessingException {
        User user = context.sessionAttribute("currentUser");
        System.out.println("getting user reimbursement information for: " + user.getUsername());
        reimbursementList = reimbursementService.getReimbursementByUsername(user.getUsername());
        System.out.println(reimbursementList);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(reimbursementList));
        context.json(reimbursementService.getReimbursementByUsername(user.getUsername()));
    }

    /**
     * get reimbursement by id
     *
     * @param context app
     */
    public static void getReimbursementById(Context context) {

        System.out.println("\nget reimb by id has fired");
        int reimbursementId = Integer.parseInt(context.pathParam("id"));
        System.out.println(reimbursementId);
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setReimbursementId(reimbursementId);
        System.out.println(reimbursement.getReimbursementId());
        System.out.println("getting user reimbursement information for: " + reimbursementId);
        System.out.println(reimbursementService.getReimbursementById(reimbursement));
        context.json(reimbursementService.getReimbursementById(reimbursement));
    }

    /**
     * create reimbursement: employee
     *
     * @param context
     */
    public static void createReimbursement(Context context) {
        System.out.println("create handler has fired");
        Reimbursement reimbursement = context.bodyAsClass(Reimbursement.class);
        System.out.println(reimbursement.toString());
        reimbursementService.createReimbursementUser(reimbursement);
        context.json(reimbursement).status(201);
    }

    /**
     * create reimbursement: manager
     *
     * @param context
     */
    public static void updateReimbursement(Context context) {

//        int reimbursementId = Integer.parseInt(context.pathParam("reimbursementId"));
        System.out.println("update handler has fired");
        Reimbursement reimbursement = context.bodyAsClass(Reimbursement.class);
        System.out.println(reimbursement.toString());
        reimbursementService.updateReimbursements(reimbursement);
        context.result("success");
    }
}
