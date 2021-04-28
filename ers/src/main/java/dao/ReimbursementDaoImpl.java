package dao;

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import models.Reimbursement;
import models.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
public class ReimbursementDaoImpl implements ReimbursementDao {

    /**
     * This method will populate the ers_reimbursement_status
     * to obtain the primary key which will be inserted to the
     *  the default value for the status will be 'in progress'
     *  
     * @return status id
     */
    private int insertReimbursementStatus() {

        int statudId = 0;
        String status = "pending";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            String sql = "INSERT INTO ers_reimbursement_status (reimb_status) VALUES (?)";

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
    private int insertReimbursementType(String type) {

        int typeId = 0;

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            String sql = "INSERT INTO ers_reimbursement_type(reimb_type) VALUES (?)";

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, type); //the 1st "?"

            ps.executeUpdate();

            //PRINTING THE PRIMARY KEY
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("The returned typePK: "+ rs.getInt("reimb_type_id"));
                typeId = rs.getInt("reimb_type_id");
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return typeId;
    }

    /**
     * Insert reimbursement to ers_reimbursement
     *
     * @param reimbursement ers
     */
    @Override
    public void insertReimbursementUser(Reimbursement reimbursement) {

        int statusId = insertReimbursementStatus();
        int typeId = insertReimbursementType(reimbursement.getReimbursementType());

        try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)){

            String sql = "INSERT INTO ers_reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, reimbursement.getReimbursementAmount());//the 1st "?"
            ps.setObject(2, reimbursement.getReimbursementSubmitted());
            ps.setString(3, reimbursement.getReimbursementDescription());
            ps.setInt(4, reimbursement.getReimbursementAuthorId());
            ps.setInt(5, statusId);
            ps.setInt(6, typeId);

            ps.executeUpdate();

            //PRINTING THE PRIMARY KEY
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("The returned PK: "+ rs.getInt("reimb_id"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Insert reimbursement to ers_reimbursement
     *
     * @param reimbursement ers
     */
    @Override
    public void insertReimbursementUser(Reimbursement reimbursement, String type) {

        int statusId = insertReimbursementStatus();
        int typeId = insertReimbursementType(type);

        try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)){

            String sql = "INSERT INTO ers_reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, reimbursement.getReimbursementAmount());//the 1st "?"
            ps.setObject(2, reimbursement.getReimbursementSubmitted());
            ps.setString(3, reimbursement.getReimbursementDescription());
            ps.setInt(4, reimbursement.getReimbursementAuthorId());
            ps.setInt(5, statusId);
            ps.setInt(6, typeId);

            ps.executeUpdate();

            //PRINTING THE PRIMARY KEY
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("The returned PK: "+ rs.getInt("reimb_id"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Select all reimbursements from ers_reimbursement
     *
     * @return list of reimbursements
     */
    @Override
    public List<Reimbursement> selectAllReimbursement() {

        List<Reimbursement> reimbursementList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            String sql = "SELECT * FROM reimb_join_full";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                reimbursementList.add(
                        new Reimbursement(
                                rs.getInt(1),
                                rs.getDouble(2),
                                rs.getTimestamp(3),
                                rs.getTimestamp(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7),
                                rs.getString(8),
                                rs.getString(9)
                        )
                );
            }
        }

        catch (SQLException e) {

            e.printStackTrace();
        }

        return reimbursementList;
    }

    /**
     * Select reimbursement by id
     *
     * @param username
     * @return id
     */
    @Override
    public List<Reimbursement> selectReimbursementsByUsername(String username) {

        List<Reimbursement> reimbursementList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            String sql = "SELECT reimb_id AS id, reimb_amount AS amount , reimb_submitted AS submited, reimb_resolved AS resolved, " +
                    " reimb_description AS description, eua.ers_username AS author, eur.ers_username AS resolver, reimb_status AS status," +
                    " reimb_type AS type FROM ers_reimbursement r" +
                    " JOIN ers_users eua ON r.reimb_author = eua.ers_user_id" +
                    " LEFT JOIN ers_users eur ON r.reimb_resolver = eur.ers_user_id" +
                    " JOIN ers_reimbursement_status ers ON ers.reimb_status_id = r.reimb_status_id" +
                    " JOIN ers_reimbursement_type ert ON ert.reimb_type_id = r.reimb_type_id" +
                    " WHERE eua.ers_username = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                reimbursementList.add(
                        new Reimbursement(
                                rs.getInt(1), //id
                                rs.getDouble(2), //amount
                                rs.getTimestamp(3), //submitted
                                rs.getTimestamp(4), //resolved
                                rs.getString(5), //description
                                rs.getString(6), //author
                                rs.getString(7), //resolver
                                rs.getString(8), //status
                                rs.getString(9) //type
                        )
                );
            }
        }

        catch (SQLException e) {

            e.printStackTrace();
        }

        return reimbursementList;
    }

    public Reimbursement selectReimbursementById(Reimbursement reimbursement) {

        Reimbursement returnReimbursement = new Reimbursement();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            String sql = "SELECT * FROM reimb_join_full WHERE id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, reimbursement.getReimbursementId());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                returnReimbursement.setReimbursementId(rs.getInt(1));
                returnReimbursement.setReimbursementAmount(rs.getDouble(2));
                returnReimbursement.setReimbursementSubmitted(rs.getTimestamp(3));
                returnReimbursement.setReimbursementResolved(rs.getTimestamp(4));
                returnReimbursement.setReimbursementDescription(rs.getString(5));
                returnReimbursement.setReimbursementAuthor(rs.getString(6));
                returnReimbursement.setReimbursementResolver(rs.getString(7));
                returnReimbursement.setReimbursementStatusId(rs.getInt(8));// <-- status id
                returnReimbursement.setReimbursementStatus(rs.getString(9));
                returnReimbursement.setReimbursementType(rs.getString(10));
            }
        }

        catch (SQLException e) {

            e.printStackTrace();
        }

        return returnReimbursement;
    }

    /**
     * update ers_user
     *
     * @param reimbursement ers
     */
    @Override
    public void updateReimbursements(Reimbursement reimbursement) {

        updateReimbursementsStatus(reimbursement.getReimbursementStatus(), reimbursement.getReimbursementStatusId());

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            String sql = "UPDATE ers_reimbursement SET reimb_resolved = ? /*, reimb_resolver = ?*/ WHERE reimb_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setTimestamp(1, (Timestamp) reimbursement.getReimbursementResolved());//the 1st "?"
            //ps.setInt(2, reimbursement.getReimbursementResolverId());//the 2nd "?"
            ps.setInt(2, reimbursement.getReimbursementId());

            ps.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * update ers_user
     *
     * @param reimbursement ers
     */
    @Override
    public void updateReimbursements(Reimbursement reimbursement, int reimbursementId, String status, int statusId) {

        updateReimbursementsStatus(status, statusId);

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            String sql = "UPDATE ers_reimbursement SET reimb_resolved = ?, reimb_resolver = ? WHERE reimb_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, reimbursement.getReimbursementResolved());//the 1st "?"
            ps.setInt(2, reimbursement.getReimbursementResolverId());//the 2nd "?"
            ps.setInt(3, reimbursementId);

            ps.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

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
    @Override
    public void deleteReimbursements(Reimbursement reimbursement) {

    }
}
