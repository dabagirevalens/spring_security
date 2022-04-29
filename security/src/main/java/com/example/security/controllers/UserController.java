package com.example.security.controllers;

import com.example.security.models.Role;
import com.example.security.models.User;
import com.example.security.services.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser( @RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("role/add_to_user")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUser roleToUser){
        userService.addRoleToUser(roleToUser.getUserName(),roleToUser.getRoleName());
        return ResponseEntity.ok().build();
    }

}

@Data
class RoleToUser{
    private String userName;
    private String roleName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
