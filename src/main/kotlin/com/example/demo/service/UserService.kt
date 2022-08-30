package com.example.demo.service

import com.example.demo.generated.types.UserIdxInput
import com.example.demo.generated.types.UserInput
import com.example.demo.model.USER_SEQUENCE_NAME
import com.example.demo.model.User
import com.example.demo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    private lateinit var userRepository: UserRepository
    @Autowired
    private lateinit var dbSequenceService: DbSequenceService

    fun findAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun findUserByIdx(input: Long): User {
        return userRepository.findUserByUserIdx(input)
    }

    fun createUser(userInput: UserInput): User {
        var user = User()
        user.userIdx = dbSequenceService.generateSequence(USER_SEQUENCE_NAME)
        user.userName = userInput.username
        user.password = userInput.password
        user.roles = userInput.roles!!
        return userRepository.save(user)
    }

    fun updateUser(userIdxInput: UserIdxInput, userInput: UserInput): User {
        var user = findUserByIdx(userIdxInput.userIdx)
        user.userName = userInput.username
        user.password = userInput.password
        user.roles = userInput.roles
        return userRepository.save(user)
    }

    fun deleteUser(userIdxInput: UserIdxInput): User {
        return userRepository.deleteByUserIdx(userIdxInput.userIdx)
    }
}