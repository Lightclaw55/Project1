package com.revature.daos;

import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReimbursementStatusDAO implements ReimbursementStatusDAOInterface {


    @Override
    public ReimbursementStatus getStatusById(int id) {

        try(Connection conn = ConnectionUtil.getConnection())
        {

            String sql = "SELECT * FROM ers_reimbursement_status WHERE reimbursement_status_id = ?;";


            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                ReimbursementStatus sT = new ReimbursementStatus(rs.getInt("reimbursement_status_id"), rs.getString("reimbursement_status"));
                return sT;
            }


        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
