package ir.amirroid.jetnews.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.amirroid.jetnews.database.ARTICLES_REMOTE_KEYS

@Entity(ARTICLES_REMOTE_KEYS)
data class ArticleRemoteKeyEntity(
    @PrimaryKey
    val articleId: Int,
    val nextKey: Long?,
)