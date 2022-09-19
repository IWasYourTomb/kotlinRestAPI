package com.example.usersapi.model

import javax.persistence.*

@Entity
@Table(name = "user")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long?,
    val name: String?,
    val middle_name: String?,
    val last_name: String?
) {
    fun toDto() = UserDto(
        id,
        name,
        middle_name,
        last_name
    )

    companion object {
        fun fromDTO(dto: UserDto) = User(
            dto.id,
            dto.name,
            dto.last_name,
            dto.middle_name
        )
    }

    override fun hashCode(): Int = javaClass.hashCode()
}