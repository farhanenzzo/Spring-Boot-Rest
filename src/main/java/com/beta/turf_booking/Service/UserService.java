package com.beta.turf_booking.Service;

import com.beta.turf_booking.Model.User;
import com.beta.turf_booking.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> showAllUser() {
        return userRepo.findAll();
    }

    public void createNewUser(User user) {
        userRepo.save(user);
    }

    public User findUserById(long id) {
        return userRepo.findById(id).orElse(null);
    }

    public boolean updateUserById(long id, User updateUser) {
        Optional<User> userOptional = userRepo.findById(id);

        if(userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(updateUser.getName());
            user.setPhone(updateUser.getPhone());
            user.setCity(updateUser.getCity());
            user.setArea(updateUser.getArea());
            userRepo.save(user);

            return true;
        }
        return false;
    }

    public boolean deleteUserById(long id) {
        try {
            userRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
