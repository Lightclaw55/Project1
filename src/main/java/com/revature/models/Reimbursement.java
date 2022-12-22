package com.revature.models;

public class Reimbursement {

    private int reimbursementId;
    private int reimbursementAmount;
    private String reimbursementDescription;
    private User user;
    private ReimbursementType rT;
    private ReimbursementStatus rS;

    private int userId;
    private int reimbursementTypeId;
    private int reimbursementStatusId;

    public Reimbursement(int reimbursementAmount, String reimbursementDescription, int userId, int reimbursementTypeId, int reimbursementStatusId) {
        this.reimbursementAmount = reimbursementAmount;
        this.reimbursementDescription = reimbursementDescription;
        this.userId = userId;
        this.reimbursementTypeId = reimbursementTypeId;
        this.reimbursementStatusId = reimbursementStatusId;
    }

    public Reimbursement() {
    }

    public Reimbursement(int reimbursementAmount, String reimbursementDescription, User user, ReimbursementType rT, ReimbursementStatus rS) {
        this.reimbursementAmount = reimbursementAmount;
        this.reimbursementDescription = reimbursementDescription;
        this.user = user;
        this.rT = rT;
        this.rS = rS;
    }

    public Reimbursement(int reimbursementId, int reimbursementAmount, String reimbursementDescription, User user, ReimbursementType rT, ReimbursementStatus rS) {
        this.reimbursementId = reimbursementId;
        this.reimbursementAmount = reimbursementAmount;
        this.reimbursementDescription = reimbursementDescription;
        this.user = user;
        this.rT = rT;
        this.rS = rS;
    }

    public int getUserId() {
        return userId;
    }

    public int getReimbursementTypeId() {
        return reimbursementTypeId;
    }

    public int getReimbursementStatusId() {
        return reimbursementStatusId;
    }

    public int getReimbursementId() {
        return reimbursementId;
    }

    public int getReimbursementAmount() {
        return reimbursementAmount;
    }

    public String getReimbursementDescription() {
        return reimbursementDescription;
    }

    public User getUser() {
        return user;
    }

    public ReimbursementType getrT() {
        return rT;
    }

    public ReimbursementStatus getrS() {
        return rS;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public void setReimbursementAmount(int reimbursementAmount) {
        this.reimbursementAmount = reimbursementAmount;
    }

    public void setReimbursementDescription(String reimbursementDescription) {
        this.reimbursementDescription = reimbursementDescription;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setrT(ReimbursementType rT) {
        this.rT = rT;
    }

    public void setrS(ReimbursementStatus rS) {
        this.rS = rS;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setReimbursementTypeId(int reimbursementTypeId) {
        this.reimbursementTypeId = reimbursementTypeId;
    }

    public void setReimbursementStatusId(int reimbursementStatusId) {
        this.reimbursementStatusId = reimbursementStatusId;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursementId=" + reimbursementId +
                ", reimbursementAmount=" + reimbursementAmount +
                ", reimbursementDescription='" + reimbursementDescription + '\'' +
                ", user=" + user +
                ", rT=" + rT +
                ", rS=" + rS +
                '}';
    }
}
