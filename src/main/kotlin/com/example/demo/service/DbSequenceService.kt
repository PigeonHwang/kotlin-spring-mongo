package com.example.demo.service

import com.example.demo.model.DbSequence
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query.query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Component

@Component
class DbSequenceService(private var mongoTemplate: MongoTemplate) {
    fun generateSequence(seqName: String): Long {
        val counter: DbSequence? = mongoTemplate.findAndModify(
            query(Criteria.where("seq_name").`is`(seqName)),
            Update().inc("seq", 1),
            DbSequence::class.java
        )
        if (counter != null) {
            return counter.seq
        }
        return 0
    }
}