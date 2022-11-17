package com.hva.helios.rest;

import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.Project;
import com.hva.helios.models.User;
import com.hva.helios.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    // TODO - Write a custom RequestBody that will parse all the string from the request
    // TODO - Use @RequestBody Map<String, Object> payload for the JSON string
    // TODO - Get object from JSON string by using payload.get("key"),

    private final UserRepository USER_REPO;

    public UserController (UserRepository USER_REPO) {
        this.USER_REPO = USER_REPO;
    }

    @GetMapping("")
    public List<User> getAll() {
        return USER_REPO.getAll(USER_REPO.getUsers());
    }

    /**
     * Get user by id
     * @param id - id of the user
     * @return - the user
     */
    @GetMapping(path = "{id}", produces = "application/json")
    public User getUser(@PathVariable int id) {
        User user = USER_REPO.getByItem(new User(id), USER_REPO.getUsers());

        if (user == null) throw new NotFoundException(String.format("No user found with id: %d", id));

        return user;
    }

    /**
     * Save user
     * @param user - user that needs to be saved
     * @return - the user that is saved
     */
    @PostMapping("")
    public User saveUser(@RequestBody User user) {
        User item = USER_REPO.saveItem(user);

        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}")
                .buildAndExpand(item.getId()).toUri();

        return ResponseEntity.created(location).body(user).getBody();
    }

    /**
     * Delete user
     * @param id - id of user that has to be deleted
     * @return - the user that is deleted
     */
    @DeleteMapping(path = "{id}", produces = "application/json")
    public User deleteUser(@PathVariable int id) {
        User item = USER_REPO.deleteById(id);

        if (item == null) throw new NotFoundException(String.format("No user found with id: %d", id));

        return ResponseEntity.ok(item).getBody();
    }
}
