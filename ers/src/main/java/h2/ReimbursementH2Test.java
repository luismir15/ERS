package h2;

import dao.ReimbursementDao;
import models.Reimbursement;

import java.sql.*;
import java.util.List;

import static util.DataBaseConnector.*;

/*=======================================================================
| Source code:  ReimbursementDaoImpl.java
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
| Interfaces: ReimbursementDao.
| *===========================================================================*/
public class ReimbursementH2Test {

    /**
     * This method will populate the ers_reimbursement_status
     * to obtain the primary key which will be inserted to the
     *  the default value for the status will be 'in progress'
     *  
     * @return status id
     */
    private int insertReimbursementStatus() {

        int statudId = 0;
        String status = "in progress";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            String sql = "INSERT INTO ers_reimbursement_status(reimb_status) VALUES (?)";

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, status); //the 1st "?"

            ps.executeUpdate();

            //PRINTING THE PRIMARY KEY
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("The returned statusPK: "+ rs.getInt("reimb_status_id"));
                statudId = rs.getInt("reimb_status_id");
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return statudId;
    }

    /**
     * 
     * @return
     */
//    private int insertReimbursementType(String type) {
//
//        int typeId = 0;
//
//        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
//
//            String sql = "INSERT INTO ers_reimbursement_type(reimb_type) VALUES (?)";
//
//            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, type); //the 1st "?"
//
//            ps.executeUpdate();
//
//            //PRINTING THE PRIMARY KEY
//            ResultSet rs = ps.getGeneratedKeys();
//            if (rs.next()) {
//                System.out.println("The returned typePK: "+ rs.getInt("reimb_type_id"));
//                typeId = rs.getInt("reimb_type_id");
//            }
//
//        } catch(SQLException e) {
//            e.printStackTrace();
//        }
//
//        return typeId;
//    }
    
    /**
     * Insert reimbursement to ers_reimbursement
     *
     * @param reimbursement ers
     */
//    public void insertReimbursementUser(Reimbursement reimbursement, String type) {
//
//        int statusId = insertReimbursementStatus();
//        int typeId = insertReimbursementType(type);
//
//        try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)){
//
//            String sql = "INSERT INTO ers_reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id) " +
//                    "VALUES (?, ?, ?, ?, ?, ?)";
//
//            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            ps.setDouble(1, reimbursement.getReimbursementAmount());//the 1st "?"
//            ps.setObject(2, reimbursement.getReimbursementSubmitted());
//            ps.setString(3, reimbursement.getReimbursementDescription());
//            ps.setInt(4, reimbursement.getReimbursementAuthorId());
//            ps.setInt(5, statusId);
//            ps.setInt(6, typeId);
//
//            ps.executeUpdate();
//
//            //PRINTING THE PRIMARY KEY
//            ResultSet rs = ps.getGeneratedKeys();
//            if (rs.next()) {
//                System.out.println("The returned PK: "+ rs.getInt("reimb_id"));
//            }
//
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//    }

    /**
     * Select all reimbursements from ers_reimbursement
     *
     * @return list of reimbursements
     */
    public List<Reimbursement> selectAllReimbursement() {
        return null;
    }

    /**
     * Select reimbursement by id
     *
     * @param id pk
     * @return id
     */
    public Reimbursement selectReimbursementById(int id) {
        return null;
    }

    /**
     * update ers_user
     *
     * @param reimbursement ers
     */
//    public void updateReimbursements(Reimbursement reimbursement, int reimbursementId, String status, int statusId) {
//
//        updateReimbursementsStatus(status, statusId);
//
//        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
//
//            String sql = "UPDATE ers_reimbursement SET reimb_resolved = ?, reimb_resolver = ? WHERE reimb_id = ?";
//
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setObject(1, reimbursement.getReimbursementResolved());//the 1st "?"
//            ps.setInt(2, reimbursement.getReimbursementResolverId());//the 2nd "?"
//            ps.setInt(3, reimbursementId);
//
//            ps.executeUpdate();
//
//        } catch(SQLException e) {
//            e.printStackTrace();
//        }
//    }

    private void updateReimbursementsStatus(String status, int statusId) {

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            String sql = "UPDATE ers_reimbursement_status SET reimb_status = ? WHERE reimb_status_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status);//the 1st "?"
            ps.setInt(2, statusId);//the 2nd "?"

            ps.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * delete ers_user
     *
     * @param reimbursement ers
     */
    public void deleteReimbursements(Reimbursement reimbursement) {

    }
}
