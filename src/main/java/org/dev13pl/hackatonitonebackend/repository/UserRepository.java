package org.dev13pl.hackatonitonebackend.repository;

import org.dev13pl.hackatonitonebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {}
