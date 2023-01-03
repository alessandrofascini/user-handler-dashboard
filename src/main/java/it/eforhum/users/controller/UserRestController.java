package it.eforhum.users.controller;

import it.eforhum.users.dto.UserUpdateRequest;
import it.eforhum.users.entity.User;
import it.eforhum.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/users", produces = "application/json")
@CrossOrigin
public class UserRestController {
    @Autowired
    private UserService service;

    @GetMapping(value = "/")
    public List<User> findAll() {
        return this.service.findAll();
    }

    @GetMapping(value = "/{id}")
    public User getById(@PathVariable("id") int id) {
        return this.service.findById(id);
    }

    @PutMapping(value = "/{id}")
    public User update(@PathVariable("id") int id, @RequestBody(required = true) UserUpdateRequest request) {
        User user = this.service.findById(id);
        System.out.println(user);
        if(request.getPassword() != null) {
            user.setPassword(request.getPassword());
        }
        if(request.getUsername() != null) {
            user.setUsername(request.getUsername());
        }
        if(request.getBornDate() != null) {
            user.setBornDate(request.getBornDate());
        }
        if(request.getRoles() != null) {
            user.setRoles(request.getRoles());
        }
        return this.service.save(user);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        this.service.deleteById(id);
    }

}
