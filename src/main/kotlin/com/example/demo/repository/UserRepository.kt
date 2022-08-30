package com.example.demo.repository

import com.example.demo.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Update
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: MongoRepository<User, String> {
    fun findUserByUserIdx(idx: Long): User
    fun deleteByUserIdx(idx: Long): User
}