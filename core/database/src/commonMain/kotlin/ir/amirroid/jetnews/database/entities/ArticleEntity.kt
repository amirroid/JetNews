package ir.amirroid.jetnews.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.amirroid.jetnews.database.ARTICLES

@Entity(ARTICLES)
class ArticleEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    val coverImage: String?,
    val language: String?,
    val createdAt: String,
    val commentsCount: Int,
    val username: String,
    val userProfileImage: String?,
    val userId: Int,
    val userUsername: String,
)