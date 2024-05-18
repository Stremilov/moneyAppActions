package org.dev13pl.hackatonitonebackend.controller;

import org.dev13pl.hackatonitonebackend.model.UserBudgetResponse;
import org.dev13pl.hackatonitonebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/budget")
    ResponseEntity<UserBudgetResponse> getUserBudget(@RequestParam Integer userId) {
        return ResponseEntity.ok(userService.getUserBudget(userId));
    }
}
