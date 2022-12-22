
package com.revature.daos;

import com.revature.models.Reimbursement;

import java.util.ArrayList;

public interface ReimbursementDAOInterface {

    Reimbursement createReimbursement(Reimbursement ticket);

    ArrayList<Reimbursement> viewReimbursementById(int id);

    boolean updateReimbursement(int reimbursementId, int newStatus);

    ArrayList<Reimbursement>viewPendingReimbursementById();

    Reimbursement getReimbursementById(int rId);

}
