package com.revature.daos;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class ReimbursementDAO implements ReimbursementDAOInterface{


    @Override
    public Reimbursement createReimbursement(Reimbursement ticket) {
        try(Connection conn = ConnectionUtil.getConnection())
        {
            String sql = "INSERT INTO ers_reimbursements(reimbursement_amount, reimbursement_description, user_id_fk, reimbursement_type_id_fk, reimbursement_status_id_fk)" +
                    " VALUES (?, ?, ?, ?, 1);";
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setInt(1, ticket.getReimbursementId());

            ps.setInt(1, ticket.getReimbursementAmount());
            ps.setString(2, ticket.getReimbursementDescription());
            ps.setInt(3, ticket.getUserId()); //problem
            ps.setInt(4, ticket.getReimbursementTypeId()); //problem
            ps.executeUpdate();
            return ticket;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Reimbursement> viewReimbursementById(int rId) {

        ArrayList<Reimbursement> tickets = new ArrayList();

        try(Connection conn = ConnectionUtil.getConnection())
        {
            String sql = "SELECT * FROM ers_reimbursements WHERE reimbursement_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, rId);

            ResultSet rs = ps.executeQuery();


            while(rs.next())
            {

                Reimbursement ticket = new Reimbursement(
                        rs.getInt("reimbursement_id"),
                        rs.getInt("reimbursement_amount"),
                        rs.getString("reimbursement_description"),
                        null,
                        null,
                        null
                        );

                int userId = rs.getInt("user_id_fk");
                int typeId = rs.getInt("reimbursement_type_id_fk");
                int statusId = rs.getInt("reimbursement_status_id_fk");

                UserDAO uDAO = new UserDAO();
                User u = uDAO.getUserById(userId);

                ReimbursementStatusDAO rsDAO = new ReimbursementStatusDAO();
                ReimbursementStatus rS = rsDAO.getStatusById(statusId);

                ReimbursementTypeDAO rtDAO = new ReimbursementTypeDAO();
                ReimbursementType rt = rtDAO.getTypeById(typeId);

                ticket.setUser(u);
                ticket.setrT(rt);
                ticket.setrS(rS);

                tickets.add(ticket);

            }
            return tickets;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateReimbursement(int reimbursementId, int newStatus) {

        try(Connection conn = ConnectionUtil.getConnection())
        {
            String sql = "UPDATE ers_reimbursements SET reimbursement_status_id_fk = ? WHERE reimbursement_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, newStatus);
            ps.setInt(2, reimbursementId);
            ps.executeUpdate();
            ps.close();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<Reimbursement> viewPendingReimbursementById() {

        try(Connection conn = ConnectionUtil.getConnection())
        {
            String sql = "SELECT * FROM ers_reimbursements WHERE reimbursement_status_id_fk = 1;";

            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery(sql);

            ArrayList<Reimbursement> tickets = new ArrayList();


            while(rs.next())
            {
                Reimbursement ticket = new Reimbursement(
                        rs.getInt("reimbursement_id"),
                        rs.getInt("reimbursement_amount"),
                        rs.getString("reimbursement_description"),
                        null,
                        null,
                        null
                );

                int userId = rs.getInt("user_id_fk");
                int typeId = rs.getInt("reimbursement_type_id_fk");
                int statusId = rs.getInt("reimbursement_status_id_fk");

                UserDAO uDAO = new UserDAO();
                User u = uDAO.getUserById(userId);

                ReimbursementStatusDAO rsDAO = new ReimbursementStatusDAO();
                ReimbursementStatus rS = rsDAO.getStatusById(statusId);

                ReimbursementTypeDAO rtDAO = new ReimbursementTypeDAO();
                ReimbursementType rt = rtDAO.getTypeById(typeId);

                ticket.setUser(u);
                ticket.setrT(rt);
                ticket.setrS(rS);
                System.out.println("hey I'm in");
                tickets.add(ticket);
            }
            return tickets;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Reimbursement getReimbursementById(int rId) {
        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM ers_reimbursements WHERE reimbursement_id = ?; ";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, rId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Reimbursement reimbursement = new Reimbursement(
                        rs.getInt("reimbursement_id"),
                        rs.getInt("reimbursement_amount"),
                        rs.getString("reimbursement_description"),
                        null,
                        null,
                        null
                );
                // update objects
                int userId = rs.getInt("user_id_fk");
                int typeId = rs.getInt("reimbursement_type_id_fk");
                int statusId = rs.getInt("reimbursement_status_id_fk");

                UserDAO uDAO = new UserDAO();
                User u = uDAO.getUserById(userId);

                ReimbursementStatusDAO rsDAO = new ReimbursementStatusDAO();
                ReimbursementStatus rS = rsDAO.getStatusById(statusId);

                ReimbursementTypeDAO rtDAO = new ReimbursementTypeDAO();
                ReimbursementType rt = rtDAO.getTypeById(typeId);

                reimbursement.setUser(u);
                reimbursement.setrT(rt);
                reimbursement.setrS(rS);

                return reimbursement;
            }
        } catch(SQLException e){
            e.printStackTrace(); //if something goes wrong this will display and error message
        }
        return null;
    }
}
