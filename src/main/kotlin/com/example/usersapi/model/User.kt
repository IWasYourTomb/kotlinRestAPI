package com.example.usersapi.model

import javax.persistence.*

@Entity
@Table( name= "user")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
    val name: String,
    val middle_name: String,
    val last_name: String
)