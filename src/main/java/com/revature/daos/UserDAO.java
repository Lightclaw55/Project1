package com.revature.daos;


import com.revature.models.ReimbursementStatus;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO implements UserDAOInterface{


    @Override
    public ArrayList<User> getUsers() {

        try(Connection conn = ConnectionUtil.getConnection())
        {
            String sql = "SELECT * FROM ers_users;";

            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery(sql);

            ArrayList<User> userList = new ArrayList();

            while(rs.next())
            {

                int roleFK = rs.getInt("user_role_id_fk");
                User u = new User(
                        rs.getInt("user_id"),
                        rs.getString("user_first_name"),
                        rs.getString("user_last_name"),
                        rs.getString("user_username"),
                        rs.getString("user_password"),
                        roleFK
                );

                userList.add(u);

            }

            return userList;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public User insertUser(User u) {
        try(Connection conn = ConnectionUtil.getConnection())
        {
            String sql = "INSERT INTO ers_users(user_first_name, user_last_name, user_username, user_password, user_role_id_fk) VALUES (?, ?, ?, ?, 2);";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, u.getFirstName());
            ps.setString(2, u.getLastName());
            ps.setString(3, u.getUsername());
            ps.setString(4, u.getPassword());

            ps.executeUpdate();

            return u;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public User getUserById(int userId) {
        try(Connection conn = ConnectionUtil.getConnection())
        {

            String sql = "SELECT * FROM ers_users WHERE user_id = ?;";


            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                int roleFK = rs.getInt("user_role_id_fk");
                User u = new User(
                        rs.getInt("user_id"),
                        rs.getString("user_first_name"),
                        rs.getString("user_last_name"),
                        rs.getString("user_username"),
                        rs.getString("user_password"),
                        roleFK
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
}
