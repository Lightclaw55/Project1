package com.revature;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbursementController;
import com.revature.daos.ReimbursementDAO;
import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;
import io.javalin.Javalin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Launcher {

    public static void main(String[] args) {

        try(Connection conn = ConnectionUtil.getConnection())
        {
            System.out.println("CONNECTION SUCCESSFUL");
        }
        catch(SQLException e)
        {
            System.out.println("Connection failed :(");
        }

        Javalin app = Javalin.create(
                config -> {
                }
        ).start(3055);

        ReimbursementController rc = new ReimbursementController();
        AuthController ac = new AuthController();

        app.post("/login", ac.loginHandler);
        app.post("/register", ac.registerHandler);

        app.patch("/updateTicketStatus/{reimbursementId}/{reimbursementStatusId}", rc.updateReimbursement);
        app.post("/createTicket", rc.createTicket);
        app.get("/reimbursements", rc.viewTickets);
        app.post("/viewPending", rc.viewPendingTickets);


        //////////////////////////////////////////////////////////////

        ReimbursementDAO rDAO = new ReimbursementDAO();

        //ArrayList<Reimbursement> reimbursements = rDAO.viewReimbursementById(1);
        ArrayList<Reimbursement> reimbursements = rDAO.viewPendingReimbursementById();


        for(Reimbursement rs : reimbursements)
        {
            System.out.println(rs);
        }

    }

}
