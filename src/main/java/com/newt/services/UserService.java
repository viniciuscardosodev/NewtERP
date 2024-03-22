package com.newt.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newt.models.User;
import com.newt.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(UUID id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("User not found."));
    }

    @Transactional
    public User createUser(User user){

        user.setId(null);
        if (user != null)
            user = this.userRepository.save(user);
        return user;
    }

    @Transactional
    public void deleteUser(UUID id) {
       try {
        this.userRepository.deleteById(id);
       } catch (Exception e) {
        throw new RuntimeException("This user is linked with other entities.");
       }
    }

    @Transactional
    public User updateUser(User user, UUID id){
        
    }
}
