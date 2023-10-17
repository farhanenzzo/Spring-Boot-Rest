package com.beta.turf_booking.Controller;

import com.beta.turf_booking.Model.User;
import com.beta.turf_booking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> showUser() {
        return userService.showAllUser();
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        userService.createNewUser(user);
        return "New user has been added !";
    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable Long id) {
       return userService.findUserById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUserById(id);
        if(deleted) {
            return "user has been deleted";
        } else {
            return "User not available";
        }
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User updateUser) {
        for(User user: userService.updateUserById()) {
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
