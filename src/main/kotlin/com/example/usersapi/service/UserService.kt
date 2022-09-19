package com.example.usersapi.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import com.example.usersapi.model.User
import com.example.usersapi.model.UserDto
import com.example.usersapi.repository.UserRepository
import org.springframework.web.server.ResponseStatusException

@Service
class UserService(val repository : UserRepository){
    fun getAll(): List<User> = repository.findAll()

    fun getById(id: Long): User = repository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    fun create(dto: UserDto): User = repository.save(User.fromDTO(dto))

    fun remove (id: Long){
        if(repository.existsById(id)) repository.deleteById(id)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    fun update(id: Long, dto: UserDto): User {
        return if (repository.existsById(id)) {
            dto.id = id
            repository.save(User.fromDTO(dto))
        } else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}