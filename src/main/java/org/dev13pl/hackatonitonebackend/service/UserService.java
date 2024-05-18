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

    public UserBudgetResponse getUserBudget(String userId) {
        User user = repository.findById(userId).orElseThrow(() -> new RuntimeException("No user found"));
        return new UserBudgetResponse(user.getBudget());
    }

    public void createNewUser(User requestBody) {
        repository.save(requestBody);
    }
}
