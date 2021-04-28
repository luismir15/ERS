package models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import java.util.Date;

/*=======================================================================
| Source code: Reimbursement.java
|
| Author: Luis Miranda
| Assignment: Project 0 Part 2
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
| Purpose:  The purpose of this class is to serve as the Physical Model
|           for the reimbursement table.
| *===========================================================================*/
public class Reimbursement {

    private int reimbursementId;
    private double reimbursementAmount;
    private Date reimbursementSubmitted;
    private Date reimbursementResolved;
    private String reimbursementDescription;
    private int reimbursementAuthorId;
    private String reimbursementAuthor;
    private int reimbursementResolverId;
    private String reimbursementResolver;
    private int reimbursementStatusId;
    private String reimbursementStatus;
    private int reimbursementTypeId;
    private String reimbursementType;

    /**
     * No args constructor
     */
    public Reimbursement() {

    }

    /**
     * Define
     * @param reimbursementAmount
     * @param reimbursementSubmitted
     * @param reimbursementResolved
     * @param reimbursementDescription
     * @param reimbursementResolver
     * @param reimbursementStatus
     * @param reimbursementType
     */
    public Reimbursement(int reimbursementId, double reimbursementAmount, Timestamp reimbursementSubmitted,
                         Timestamp reimbursementResolved, String reimbursementDescription, String reimbursementResolver,
                         String reimbursementStatus, String reimbursementType) {
        this.reimbursementId = reimbursementId;
        this.reimbursementAmount = reimbursementAmount;
        this.reimbursementSubmitted = reimbursementSubmitted;
        this.reimbursementResolved = reimbursementResolved;
        this.reimbursementDescription = reimbursementDescription;
        this.reimbursementResolver = reimbursementResolver;
        this.reimbursementStatus = reimbursementStatus;
        this.reimbursementType = reimbursementType;
    }

    public Reimbursement(int reimbursementId, double reimbursementAmount, Timestamp reimbursementSubmitted,
                         Timestamp reimbursementResolved, String reimbursementDescription,
                         String reimbursementAuthor, String reimbursementResolver, String reimbursementStatus,
                         String reimbursementType) {
        this.reimbursementId = reimbursementId;
        this.reimbursementAmount = reimbursementAmount;
        this.reimbursementSubmitted = reimbursementSubmitted;
        this.reimbursementResolved = reimbursementResolved;
        this.reimbursementDescription = reimbursementDescription;
        this.reimbursementAuthor = reimbursementAuthor;
        this.reimbursementResolver = reimbursementResolver;
        this.reimbursementStatus = reimbursementStatus;
        this.reimbursementType = reimbursementType;
    }

    public Reimbursement(int reimbursementId, double reimbursementAmount, Timestamp reimbursementSubmitted,
                         Timestamp reimbursementResolved, String reimbursementDescription, int reimbursementAuthorId,
                         int reimbursementResolverId, int reimbursementStatusId, int reimbursementTypeId) {
        this.reimbursementId = reimbursementId;
        this.reimbursementAmount = reimbursementAmount;
        this.reimbursementSubmitted = reimbursementSubmitted;
        this.reimbursementResolved = reimbursementResolved;
        this.reimbursementDescription = reimbursementDescription;
        this.reimbursementAuthorId = reimbursementAuthorId;
        this.reimbursementResolverId = reimbursementResolverId;
        this.reimbursementStatusId = reimbursementStatusId;
        this.reimbursementTypeId = reimbursementTypeId;
    }

    public Reimbursement(int reimbursementId, double reimbursementAmount, Timestamp reimbursementSubmitted,
                         Timestamp reimbursementResolved, String reimbursementDescription, int reimbursementAuthorId,
                         String reimbursementAuthor, int reimbursementResolverId, String reimbursementResolver,
                         int reimbursementStatusId, String reimbursementStatus, int reimbursementTypeId,
                         String reimbursementType) {
        this.reimbursementId = reimbursementId;
        this.reimbursementAmount = reimbursementAmount;
        this.reimbursementSubmitted = reimbursementSubmitted;
        this.reimbursementResolved = reimbursementResolved;
        this.reimbursementDescription = reimbursementDescription;
        this.reimbursementAuthorId = reimbursementAuthorId;
        this.reimbursementAuthor = reimbursementAuthor;
        this.reimbursementResolverId = reimbursementResolverId;
        this.reimbursementResolver = reimbursementResolver;
        this.reimbursementStatusId = reimbursementStatusId;
        this.reimbursementStatus = reimbursementStatus;
        this.reimbursementTypeId = reimbursementTypeId;
        this.reimbursementType = reimbursementType;
    }

    public int getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public double getReimbursementAmount() {
        return reimbursementAmount;
    }

    public void setReimbursementAmount(double reimbursementAmount) {
        this.reimbursementAmount = reimbursementAmount;
    }

    public Date getReimbursementSubmitted() {
        return reimbursementSubmitted;
    }

    public void setReimbursementSubmitted(Timestamp reimbursementSubmitted) {
        this.reimbursementSubmitted = reimbursementSubmitted;
    }

    public Date getReimbursementResolved() {
        return reimbursementResolved;
    }

    public void setReimbursementResolved(Timestamp reimbursementResolved) {
        this.reimbursementResolved = reimbursementResolved;
    }

    public String getReimbursementDescription() {
        return reimbursementDescription;
    }

    public void setReimbursementDescription(String reimbursementDescription) {
        this.reimbursementDescription = reimbursementDescription;
    }

    public int getReimbursementAuthorId() {
        return reimbursementAuthorId;
    }

    public void setReimbursementAuthorId(int reimbursementAuthorId) {
        this.reimbursementAuthorId = reimbursementAuthorId;
    }

    public String getReimbursementAuthor() {
        return reimbursementAuthor;
    }

    public void setReimbursementAuthor(String reimbursementAuthor) {
        this.reimbursementAuthor = reimbursementAuthor;
    }

    public int getReimbursementResolverId() {
        return reimbursementResolverId;
    }

    public void setReimbursementResolverId(int reimbursementResolverId) {
        this.reimbursementResolverId = reimbursementResolverId;
    }

    public String getReimbursementResolver() {
        return reimbursementResolver;
    }

    public void setReimbursementResolver(String reimbursementResolver) {
        this.reimbursementResolver = reimbursementResolver;
    }

    public int getReimbursementStatusId() {
        return reimbursementStatusId;
    }

    public void setReimbursementStatusId(int reimbursementStatusId) {
        this.reimbursementStatusId = reimbursementStatusId;
    }

    public String getReimbursementStatus() {
        return reimbursementStatus;
    }

    public void setReimbursementStatus(String reimbursementStatus) {
        this.reimbursementStatus = reimbursementStatus;
    }

    public int getReimbursementTypeId() {
        return reimbursementTypeId;
    }

    public void setReimbursementTypeId(int reimbursementTypeId) {
        this.reimbursementTypeId = reimbursementTypeId;
    }

    public String getReimbursementType() {
        return reimbursementType;
    }

    public void setReimbursementType(String reimbursementType) {
        this.reimbursementType = reimbursementType;
    }

    //    @Override
//    public String toString() {
//        return "\nReimbursement{" +
//                "reimbursementId=" + reimbursementId +
//                ", reimbursementAmount=" + reimbursementAmount +
//                ", reimbursementSubmitted=" + reimbursementSubmitted +
//                ", reimbursementResolved=" + reimbursementResolved +
//                ", reimbursementDescription='" + reimbursementDescription + '\'' +
//                ", reimbursementAuthor=" + reimbursementAuthor +
//                ", reimbursementResolver=" + reimbursementResolver +
//                ", reimbursementStatusId=" + reimbursementStatusId +
//                ", reimbursementStatus='" + reimbursementStatus + '\'' +
//                ", reimbursementTypeId=" + reimbursementTypeId +
//                ", reimbursementType='" + reimbursementType + '\'' +
//                '}';
//    }

//    @Override
//    public String toString() {
//        return "Reimbursement{" +
//                "reimbursementId=" + reimbursementId +
//                ", reimbursementAmount=" + reimbursementAmount +
//                ", reimbursementSubmitted=" + reimbursementSubmitted +
//                ", reimbursementResolved=" + reimbursementResolved +
//                ", reimbursementDescription='" + reimbursementDescription + '\'' +
//                ", reimbursementAuthor='" + reimbursementAuthor + '\'' +
//                ", reimbursementResolver='" + reimbursementResolver + '\'' +
//                ", reimbursementStatus='" + reimbursementStatus + '\'' +
//                ", reimbursementType='" + reimbursementType + '\'' +
//                '}';
//    }


    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursementId=" + reimbursementId +
                ", reimbursementAmount=" + reimbursementAmount +
                ", reimbursementSubmitted=" + reimbursementSubmitted +
                ", reimbursementResolved=" + reimbursementResolved +
                ", reimbursementDescription='" + reimbursementDescription + '\'' +
                ", reimbursementAuthor='" + reimbursementAuthor + '\'' +
                ", reimbursementResolver='" + reimbursementResolver + '\'' +
                ", reimbursementStatusId=" + reimbursementStatusId +
                ", reimbursementStatus='" + reimbursementStatus + '\'' +
                ", reimbursementType='" + reimbursementType + '\'' +
                '}';
    }
}
