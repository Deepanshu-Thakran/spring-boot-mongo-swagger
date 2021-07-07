package com.thakran.springbootmongo.dao;

import com.thakran.springbootmongo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String addUser(User user) {
        userRepository.save(user);
        return "Added new user: "+user.getName();
    }


    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(int id) {
        return userRepository.findById(id);
    }

    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "Deleted user with id:   "+id;
    }
}
