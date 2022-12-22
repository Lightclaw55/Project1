package com.revature.daos;

import com.revature.models.User;

import java.util.ArrayList;

public interface UserDAOInterface {

    ArrayList<User> getUsers();

    User getUserById(int userId);

    User insertUser(User u);


}
