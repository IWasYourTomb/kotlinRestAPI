package com.example.usersapi.controller

import com.example.usersapi.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import com.example.usersapi.model.User

@RequestMapping("api/v1/users")
@RestController
class UserController(val service : UserService){
    @GetMapping
    fun getAllUser() = service.getAll()

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long) = service.getById(id)

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun saveUser(@RequestBody user: User): User = service.create(user)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id: Long) = service.remove(id)

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody user: User) = service.update(id, user)
}