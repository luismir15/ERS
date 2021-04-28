package services;

import models.Reimbursement;

import java.util.List;

/**
    The service layer is used to connect dirrectly to 
    the dao layer. the purpose of this implementation
    is for separations of concern. 
 */
public interface ReimbursementService {

    /**
     * Insert reimbursement to ers_reimbursement
     *
     * @param reimbursement ers
     */
    public void createReimbursementUser(Reimbursement reimbursement);

    /**
     * Insert reimbursement to ers_reimbursement
     *
     * @param reimbursement ers
     */
    public void createReimbursementUser(Reimbursement reimbursement, String type);


    /**
     * Select all reimbursements from ers_reimbursement
     *
     * @return list of reimbursements
     */
    public List<Reimbursement> getAllReimbursement();

    /**
     * Select reimbursement by id
     *
     * @param id pk
     *
     * @return id
     */
    public List<Reimbursement> getReimbursementByUsername(String username);

    /**
     * update ers_user
     *
     * @param reimbursement ers
     *
     */
    public void updateReimbursements(Reimbursement reimbursement);

    /**
     * update ers_user
     *
     * @param reimbursement ers
     *
     */
    public void updateReimbursements(Reimbursement reimbursement, int reimbursementId, String status, int statusId);

    /**
     * delete ers_user
     *
     * @param reimbursement ers
     */
    public void deleteReimbursements(Reimbursement reimbursement);
}
