package com.example.clinicas5_rodrigo

import com.example.clinicas5_rodrigo.User

object UserStorage {

    private val users = mutableListOf<User>()

    fun addUser(user: User) {
        users.add(user)
    }

    fun userExists(username: String): Boolean {
        return users.any { it.username == username }
    }

    fun validateUser(username: String, password: String): Boolean {
        return users.any { it.username == username && it.password == password }
    }
}
