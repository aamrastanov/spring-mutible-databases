package com.example.demo.service;

import com.example.demo.db1.User1Repository;
import com.example.demo.db2.User2Repository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {

    private final User1Repository user1Repository;

    private final User2Repository user2Repository;

    @Autowired
    public UserService(User1Repository user1Repository, User2Repository user2Repository) {
        this.user1Repository = user1Repository;
        this.user2Repository = user2Repository;
    }

    @Transactional(readOnly = true)
    public List<User> getAll(){
        return Stream.concat(user1Repository.findAll().stream(), user2Repository.findAll().stream()).collect(Collectors.toList());
    }

}
