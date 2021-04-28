package dao;

import models.Reimbursement;
import models.User;

import java.util.List;

/**
 * This public interface implements the DAO (Data Access Object) Pattern
 * which is implemented for the User Model. Simple CRUD methods
 * will be operating.
 */
public interface ReimbursementDao {

    /**
     * Insert reimbursement to ers_reimbursement
     *
     * @param reimbursement ers
     */
    public void insertReimbursementUser(Reimbursement reimbursement);

    /**
     * Insert reimbursement to ers_reimbursement
     *
     * @param reimbursement ers
     */
    public void insertReimbursementUser(Reimbursement reimbursement, String type);


    /**
     * Select all reimbursements from ers_reimbursement
     *
     * @return list of reimbursements
     */
    public List<Reimbursement> selectAllReimbursement();

    /**
     * Select reimbursement by id
     *
     * @param id pk
     *
     * @return id
     */
    public List<Reimbursement> selectReimbursementsByUsername(String username);

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
    public void updateReimbursements(Reimbursement reimbursement, int reimbursementId, String status, int StatusId);

    /**
     * delete ers_user
     *
     * @param reimbursement ers
     */
    public void deleteReimbursements(Reimbursement reimbursement);
}
