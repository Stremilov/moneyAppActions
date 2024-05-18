package org.dev13pl.hackatonitonebackend.service;

import org.dev13pl.hackatonitonebackend.model.User;
import org.dev13pl.hackatonitonebackend.model.UserBudgetResponse;
import org.dev13pl.hackatonitonebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public UserBudgetResponse getUserBudget(Integer userId) {
        User user = repository.findById(userId).orElseThrow(() -> new RuntimeException("No user find"));
        return new UserBudgetResponse(user.getBudget());
    }
}
