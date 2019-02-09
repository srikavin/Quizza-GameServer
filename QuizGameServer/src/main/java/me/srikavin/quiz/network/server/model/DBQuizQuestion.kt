package me.srikavin.quiz.network.server.model

import com.fasterxml.jackson.annotation.JsonProperty
import me.srikavin.quiz.network.common.model.data.Quiz
import me.srikavin.quiz.network.common.model.data.QuizQuestion
import me.srikavin.quiz.network.common.model.data.ResourceId
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.codecs.pojo.annotations.BsonProperty
import org.litote.kmongo.Id

data class DBQuizQuestion(
        @BsonId
        val _id: Id<Quiz>,
        override val answers: List<DBQuizAnswer>,
        @BsonProperty(value = "text")
        @JsonProperty(value = "text")
        override val contents: String
) : QuizQuestion {
    override val id: ResourceId = ResourceId(_id.toString())
}