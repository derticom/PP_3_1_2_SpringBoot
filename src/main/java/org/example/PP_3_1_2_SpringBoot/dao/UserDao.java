package org.example.PP_3_1_2_SpringBoot.dao;

import org.example.PP_3_1_2_SpringBoot.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(long id);

    void deleteUser(long id);

    void updateUser(User user);
}
