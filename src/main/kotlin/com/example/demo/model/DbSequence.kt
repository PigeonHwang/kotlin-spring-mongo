package com.example.demo.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "db_sequences")
class DbSequence {
    @Id
    var _id: String = ""
    @Field("seq_name")
    var seqName: String = ""
    var seq: Long = 0
}