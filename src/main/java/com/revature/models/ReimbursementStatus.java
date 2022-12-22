package com.revature.models;

public class ReimbursementStatus {

    private int reimbursementStatusId;
    private String reimbursementStatus;

    public ReimbursementStatus() {
    }

    public ReimbursementStatus(int x)
    {
        this.reimbursementStatusId = x;
    }

    public ReimbursementStatus(int reimbursementStatusId, String reimbursementStatus) {
        this.reimbursementStatusId = reimbursementStatusId;
        this.reimbursementStatus = reimbursementStatus;
    }

    public int getReimbursementStatusId() {
        return reimbursementStatusId;
    }

    public String getReimbursementStatus() {
        return reimbursementStatus;
    }

    public void setReimbursementStatusId(int reimbursementStatusId) {
        this.reimbursementStatusId = reimbursementStatusId;
    }

    public void setReimbursementStatus(String reimbursementStatus) {
        this.reimbursementStatus = reimbursementStatus;
    }

    @Override
    public String toString() {
        return "ReimbursementStatus{" +
                "reimbursementStatusId=" + reimbursementStatusId +
                ", reimbursementStatus='" + reimbursementStatus + '\'' +
                '}';
    }
}
