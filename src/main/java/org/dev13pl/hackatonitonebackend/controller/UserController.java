package org.dev13pl.hackatonitonebackend.controller;

import org.dev13pl.hackatonitonebackend.model.User;
import org.dev13pl.hackatonitonebackend.model.UserBudgetResponse;
import org.dev13pl.hackatonitonebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    ResponseEntity<UserBudgetResponse> createNewUser(@RequestBody User body) {
        userService.createNewUser(body);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/budget")
    ResponseEntity<UserBudgetResponse> getUserBudget(@RequestParam String userId) {
        return ResponseEntity.ok(userService.getUserBudget(userId));
    }
}
