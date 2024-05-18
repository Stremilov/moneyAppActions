package org.dev13pl.hackatonitonebackend.service;

import org.dev13pl.hackatonitonebackend.exception.UserExistsException;
import org.dev13pl.hackatonitonebackend.exception.UserNotFoundException;
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
        User user = repository.findById(userId).orElseThrow(UserNotFoundException::new);
        return new UserBudgetResponse(user.getBudget());
    }

    public UserBudgetResponse setUserBudget(User requestBody) {
        repository.findById(requestBody.getId()).orElseThrow(UserNotFoundException::new);
        User user = repository.save(requestBody);
        return new UserBudgetResponse(user.getBudget());
    }

    public User createNewUser(User requestBody) {
        if (repository.findById(requestBody.getId()).isPresent()) {
            throw new UserExistsException();
        }
        return repository.save(requestBody);
    }
}
