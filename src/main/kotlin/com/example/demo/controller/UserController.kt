package com.example.demo.controller

import com.example.demo.generated.types.UserIdxInput
import com.example.demo.generated.types.UserInput
import com.example.demo.model.User
import com.example.demo.service.UserService
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsMutation
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument

@DgsComponent
class UserController(var  userService: UserService) {
    @DgsQuery
    fun users(): List<User> {
        return userService.findAllUsers()
    }

    @DgsQuery
    fun findUserByIdx(input: UserIdxInput): User {
        return userService.findUserByIdx(input.userIdx)
    }

    @DgsMutation
    fun createUser(@InputArgument input: UserInput): User {
        return userService.createUser(input)
    }

    @DgsMutation
    fun updateUser(@InputArgument idxInput: UserIdxInput, @InputArgument userInput: UserInput): User {
        return userService.updateUser(idxInput, userInput)
    }

    @DgsMutation
    fun deleteUser(@InputArgument input: UserIdxInput): User {
        return userService.deleteUser(input)
    }
}