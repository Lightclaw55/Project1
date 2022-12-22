package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.ReimbursementDAO;
import com.revature.models.Reimbursement;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class ReimbursementController {

    ReimbursementDAO rDAO = new ReimbursementDAO();

    public Handler updateReimbursement = (ctx) ->{

        if(AuthController.ses != null)
        {
            int roleID = (Integer) AuthController.ses.getAttribute("roleID");
            if (roleID == 1) {


                String reimbursementId = ctx.pathParam("reimbursementId");

                String reimbursementStatusId = ctx.pathParam("reimbursementStatusId");

                //need a DAO method to get reimbursements by ID
                Reimbursement r = rDAO.getReimbursementById(Integer.parseInt(reimbursementId));

                //if status is pending -> manager can change it otherwise no
                if (r.getrS().getReimbursementStatusId() == 1) {
                    if (rDAO.updateReimbursement(Integer.parseInt(reimbursementId), Integer.parseInt(reimbursementStatusId))) {
                        ctx.result("Update executed");
                        ctx.status(202);
                    }
                } else {
                    ctx.result("Updates can only be done on pending tickets...");
                    ctx.status(406); //406 "not acceptable"
                }
            }
        }
        else {
            ctx.result("You need to be logged in as a manager to do this!");
            ctx.status(401); //Unauthorized
        }



    };

    public Handler viewTickets = (ctx) ->{

        if (AuthController.ses != null) {
            int userID = (Integer) AuthController.ses.getAttribute("userID");


            ArrayList<Reimbursement> tickets = rDAO.viewReimbursementById(userID);

            Gson gson = new Gson();

            String JSONTickets = gson.toJson(tickets);

            System.out.println(JSONTickets);

            ctx.result(JSONTickets);

            ctx.status(202); //Accepted

        } else {
        ctx.result("You need to login to do this.");
        ctx.status(401); //unauthorized
    }



};

    public Handler createTicket = (ctx) ->{

        String body = ctx.body();

        Gson gson = new Gson();

        Reimbursement ticket = gson.fromJson(body, Reimbursement.class);

        if(rDAO.createReimbursement(ticket) != null){
            ctx.status(201); //201 created
            ctx.result(body); //send back the employee
        }
        else {
            ctx.status(406); //406 not acceptable
        }

    };

    public Handler viewPendingTickets = (ctx) ->{

        if(AuthController.ses != null) {
            int roleID = (Integer) AuthController.ses.getAttribute("roleID");
            if (roleID == 1) {


                ArrayList<Reimbursement> tickets = rDAO.viewPendingReimbursementById();

                Gson gson = new Gson();

                String JSONTickets = gson.toJson(tickets);

                ctx.result(JSONTickets);

                ctx.status(202); //Accepted
            }
            else {
                ctx.result("Only Managers can view Pending Reimbursements.");
                ctx.status(401); //unauthorized
            }

        }
        else
        {
            ctx.result("You need to be logged in as a manager to do this!");
            ctx.status(401); //Unauthorized
        }

    };

}
