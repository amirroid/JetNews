package ir.amirroid.jetnews.database.entities

import androidx.room.Entity
import ir.amirroid.jetnews.database.ARTICLES

@Entity(ARTICLES)
class ArticleEntity(
    val title: String
)