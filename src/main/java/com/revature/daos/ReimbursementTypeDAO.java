package com.revature.daos;

import com.revature.models.ReimbursementType;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReimbursementTypeDAO implements ReimbursementTypeDAOInterface{

    @Override
    public ReimbursementType getTypeById(int id) {

        try(Connection conn = ConnectionUtil.getConnection())
        {

            String sql = "SELECT * FROM ers_reimbursement_type WHERE reimbursement_type_id = ?;";


            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                ReimbursementType rT = new ReimbursementType(rs.getInt("reimbursement_type_id"), rs.getString("reimbursement_type"));
                return rT;
            }


        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
