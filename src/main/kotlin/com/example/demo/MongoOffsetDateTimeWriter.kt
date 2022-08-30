package com.example.demo

import org.bson.Document
import org.springframework.core.convert.converter.Converter
import java.time.OffsetDateTime
import java.util.Date

val DATE_FIELD = "dateTime"
val OFFSET_FIELD = "offset"

class MongoOffsetDateTimeWriter: Converter<OffsetDateTime, Document> {
    override fun convert(offsetDateTime: OffsetDateTime): Document? {
        val document: Document = Document()
        document.put(DATE_FIELD, Date.from(offsetDateTime.toInstant()))
        document.put(OFFSET_FIELD, offsetDateTime.offset.toString())
        return document
    }

}