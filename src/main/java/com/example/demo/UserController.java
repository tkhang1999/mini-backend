package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UserController {
    
    @Autowired
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/users")
    public User newUser(@RequestBody User user) {
        return repository.save(user);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return repository.findAll();
    }
    
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
    
    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User updatedUser, @PathVariable Long id) {
        return repository.findById(id)
            .map(user -> {
                user.setUsername(updatedUser.getUsername());
                user.setFirstName(updatedUser.getFirstName());
                user.setLastName(updatedUser.getLastName());
                user.setEmail(updatedUser.getEmail());
                user.setPhoneNumber(updatedUser.getPhoneNumber());
                return repository.save(user);
            })
            .orElseThrow(() -> new UserNotFoundException(id));
    }
    
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
