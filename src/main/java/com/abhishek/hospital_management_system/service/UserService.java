package com.abhishek.hospital_management_system.service;

import com.abhishek.hospital_management_system.dto.UserLoginRequest;
import com.abhishek.hospital_management_system.dto.UserLoginResponse;
import com.abhishek.hospital_management_system.modal.User;
import com.abhishek.hospital_management_system.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User u){
        return userRepository.save(u);
    }

    public UserLoginResponse loginUser(UserLoginRequest userLoginRequest) {
        Optional<User> user=userRepository.findByEmail(userLoginRequest.getEmail());
        if(user.isPresent() && user.get().getPassword().equals(userLoginRequest.getPassword())){
            User u=user.get();
            return new UserLoginResponse(u.get_id(),u.getName(),u.getEmail(),u.getDob(),u.getContacts());
        }
        return null;
    }

    public Optional<User> getUserById(ObjectId objectId) {
        return userRepository.findById(objectId);
    }

    public Optional<User> updateUser(User userUpdateRequest, ObjectId id) {
        Optional<User> user=userRepository.findById(id);
        if(user.isPresent()){
            userRepository.save(userUpdateRequest);
        }
        return null;
    }
}
