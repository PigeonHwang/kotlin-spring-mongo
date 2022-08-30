package com.example.demo.model

import org.springframework.data.mongodb.core.mapping.Field
import java.time.OffsetDateTime

open class BaseDocument {
    @Field("created_at")
    open var createdAt: OffsetDateTime = OffsetDateTime.now()
    @Field("updated_at")
    open var updatedAt: OffsetDateTime = OffsetDateTime.now()
}