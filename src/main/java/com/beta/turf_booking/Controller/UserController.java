package com.beta.turf_booking.Controller;

import com.beta.turf_booking.Model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final List<User> users = new ArrayList<>();
    private Long autoIncrementId = 1L;

    @GetMapping
    public List<User> findUser() {
        return users;
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        user.setId(autoIncrementId++);
        users.add(user);
        return "New user has been added !";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        for (User user: users){
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        Iterator<User> userObj = users.iterator();
        while (userObj.hasNext()) {
            User user = userObj.next();
            if(user.getId() == id) {
                userObj.remove();
            }
        }
        return "user has been deleted";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User updateUser) {
        for(User user: users) {
            if(user.getId() == id) {
                user.setName(updateUser.getName());
                user.setPhone(updateUser.getPhone());
                user.setCity(updateUser.getCity());
                user.setArea(updateUser.getArea());
            }
        }
        return "User has been updated !";
    }
}
