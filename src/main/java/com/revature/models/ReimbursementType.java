package com.revature.models;

public class ReimbursementType {

    private int reimbursementTypeId;
    private String reimbursementType;

    public ReimbursementType()
    {

    }

    public ReimbursementType(int x)
    {
        this.reimbursementTypeId = x;
    }

    public ReimbursementType(int reimbursementTypeId, String reimbursementType) {
        this.reimbursementTypeId = reimbursementTypeId;
        this.reimbursementType = reimbursementType;
    }

    public int getReimbursementTypeId() {
        return reimbursementTypeId;
    }

    public String getReimbursementType() {
        return reimbursementType;
    }

    public void setReimbursementTypeId(int reimbursementTypeId) {
        this.reimbursementTypeId = reimbursementTypeId;
    }

    public void setReimbursementType(String reimbursementType) {
        this.reimbursementType = reimbursementType;
    }

    @Override
    public String toString() {
        return "ReimbursementType{" +
                "reimbursementTypeId=" + reimbursementTypeId +
                ", reimbursementType='" + reimbursementType + '\'' +
                '}';
    }
}
