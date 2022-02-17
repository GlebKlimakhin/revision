package com.gklim.interpr.controller;

import com.gklim.interpr.exceptions.UserNotFoundException;
import com.gklim.interpr.models.User;
import com.gklim.interpr.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findById(@PathVariable long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user with provided id not found"));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public User update(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@RequestParam long id) {
        userRepository.deleteById(id);
    }
}
