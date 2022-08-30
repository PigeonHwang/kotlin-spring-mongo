package com.example.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.convert.MongoCustomConversions
import java.util.Arrays

@Configuration
class MongoConfig {
    @Bean
    fun mongoCustomConversions(): MongoCustomConversions {
        return MongoCustomConversions(Arrays.asList(
            MongoOffsetDateTimeWriter(),
            MongoOffsetDateTimeReader()
        ))
    }
}