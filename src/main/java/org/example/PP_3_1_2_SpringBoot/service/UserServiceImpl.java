package org.example.PP_3_1_2_SpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.example.PP_3_1_2_SpringBoot.dao.UserDao;
import org.example.PP_3_1_2_SpringBoot.entity.User;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements org.example.PP_3_1_2_SpringBoot.service.UserService {
    private final UserDao userDAO;

    public UserServiceImpl(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUser(long id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }


    @Override
    @Transactional
    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }
}

