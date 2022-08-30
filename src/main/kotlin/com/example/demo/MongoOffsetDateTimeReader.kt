package com.example.demo

import org.bson.Document
import org.springframework.core.convert.converter.Converter
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.util.Date

class MongoOffsetDateTimeReader: Converter<Document, OffsetDateTime> {
    override fun convert(document: Document): OffsetDateTime? {
        val dateTime: Date = document.getDate(DATE_FIELD)
        val offset: ZoneOffset = ZoneOffset.of(document.getString(OFFSET_FIELD))
        return OffsetDateTime.ofInstant(dateTime.toInstant(), offset)
    }
}