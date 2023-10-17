package com.beta.turf_booking.Service;

import com.beta.turf_booking.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();
    private Long autoIncrementId = 1L;

    public List<User> showAllUser() {
        return users;
    }

    public void createNewUser(User user) {
        user.setId(autoIncrementId++);
        users.add(user);
    }

    public User findUserById(long id) {
        for (User user: users){
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public List<User> updateUserById() {
        return users;
    }

    public boolean deleteUserById(long id) {
        Iterator<User> userObj = users.iterator();
        while (userObj.hasNext()) {
            User user = userObj.next();
            if(user.getId() == id) {
                userObj.remove();
                return true;
            }
        }
        return false;
    }
}
