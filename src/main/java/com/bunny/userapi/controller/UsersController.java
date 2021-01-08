package com.bunny.userapi.controller;

import com.bunny.userapi.domain.Users;
import com.bunny.userapi.dto.UsersDTO;
import com.bunny.userapi.service.UsersCommandService;
import com.bunny.userapi.service.UsersQueryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@RestController
@RequestMapping(value = "user")
public class UsersController
{
    private final UsersCommandService usersCommandService;
    private final UsersQueryService usersQueryService;

    public UsersController(UsersCommandService usersCommandService, UsersQueryService usersQueryService) {
        this.usersCommandService = usersCommandService;
        this.usersQueryService = usersQueryService;
    }

    @PostMapping
    public ResponseEntity<Users> updateUser(@RequestBody Users user){
        return ResponseEntity.ok(usersCommandService.updateUser(user));

    }

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestParam Long id){
        usersCommandService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Users>> listUsers(@RequestParam("page") int page,
                                                 @RequestParam("per_page") int size){
        page = page -1;
        return ResponseEntity.ok(usersQueryService.listUsers(PageRequest.of(page,size)));

    }


}
