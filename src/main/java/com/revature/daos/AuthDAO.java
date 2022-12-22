package com.revature.daos;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAO {

    public User login(String username, String password)
    {
        try(Connection conn = ConnectionUtil.getConnection())
        {
            String sql = "SELECT * FROM ers_users WHERE user_username = ? and user_password = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                User u = new User(
                        rs.getInt("user_id"),
                        rs.getString("user_first_name"),
                        rs.getString("user_last_name"),
                        rs.getString("user_username"),
                        rs.getString("user_password"),
                        rs.getInt("user_role_id_fk")
                );

                return u;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }


    public User registerNewUser(String first_name, String last_name, String username, String password, int role_id) {
        UserDAO uDAO = new UserDAO();
        User newUser = new User(first_name, last_name, username, password, role_id);

        User registeredUser = uDAO.insertUser(newUser);

        return registeredUser;
    }

}
