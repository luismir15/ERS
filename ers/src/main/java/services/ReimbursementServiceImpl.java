package services;

import dao.ReimbursementDaoImpl;
import models.Reimbursement;

import java.util.List;

/*=======================================================================
| Source code:  Sample.java 
|
| Author: Luis Miranda
| Assignment: Project 0 Part 2
|
| Instructor: Trevin Chester  
| Due Date: 
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	Luis Miranda [Signature]
|  
| Language:  Java
|
| Purpose:  The service layer is used to connect dirrectly to 
|           the dao layer. the purpose of this implementation
|           is for separations of concern. 
| *===========================================================================*/
public class ReimbursementServiceImpl implements ReimbursementService {

    ReimbursementDaoImpl reimbursementDao = new ReimbursementDaoImpl();

    /**
     * Insert reimbursement to ers_reimbursement
     *
     * @param reimbursement ers
     */
    @Override
    public void createReimbursementUser(Reimbursement reimbursement) {

        reimbursementDao.insertReimbursementUser(reimbursement);
    }

    /**
     * Insert reimbursement to ers_reimbursement
     *
     * @param reimbursement ers
     * @param type of reimbursements
     */
    @Override
    public void createReimbursementUser(Reimbursement reimbursement, String type) {

        reimbursementDao.insertReimbursementUser(reimbursement, type);
    }

    /**
     * Select all reimbursements from ers_reimbursement
     *
     * @return list of reimbursements
     */
    @Override
    public List<Reimbursement> getAllReimbursement() {

        return reimbursementDao.selectAllReimbursement();
    }

    /**
     * Select reimbursement by id
     *
     * @param username user
     * @return id
     */
    @Override
    public List<Reimbursement> getReimbursementByUsername(String username) {

        return reimbursementDao.selectReimbursementsByUsername(username);
    }

    public Reimbursement getReimbursementById(Reimbursement reimbursement) {

        return reimbursementDao.selectReimbursementById(reimbursement);
    }

    /**
     * update ers_user
     *
     * @param reimbursement ers
     */
    @Override
    public void updateReimbursements(Reimbursement reimbursement) {

        reimbursementDao.updateReimbursements(reimbursement);
    }

    /**
     * update ers_user
     *
     * @param reimbursement   ers
     * @param reimbursementId
     * @param status
     * @param statusId
     */
    @Override
    public void updateReimbursements(Reimbursement reimbursement, int reimbursementId, String status, int statusId) {

        reimbursementDao.updateReimbursements(reimbursement, reimbursementId, status, statusId);
    }

    /**
     * delete ers_user
     *
     * @param reimbursement ers
     */
    @Override
    public void deleteReimbursements(Reimbursement reimbursement) {

        reimbursementDao.deleteReimbursements(reimbursement);
    }
}
