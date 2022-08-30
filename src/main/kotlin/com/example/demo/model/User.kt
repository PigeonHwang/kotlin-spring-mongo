package com.example.demo.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Transient
const val USER_SEQUENCE_NAME = "users"

@Document(collection = "users")
class User: BaseDocument() {
    @Id
    lateinit var id: String
    @Field("user_idx")
    var userIdx: Long = 0
    @Field("user_name")
    lateinit var userName: String
    lateinit var password: String
    lateinit var roles: List<UserRole?>
}