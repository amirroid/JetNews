package ir.amirroid.jetnews.home.mappers

import ir.amirroid.jetnews.domain.models.article.Article
import ir.amirroid.jetnews.home.models.ArticleUiModel

fun Article.toUiModel(): ArticleUiModel {
    return ArticleUiModel(
        id = id,
        title = title
    )
}