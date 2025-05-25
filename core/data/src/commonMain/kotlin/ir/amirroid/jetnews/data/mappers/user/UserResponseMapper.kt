package ir.amirroid.jetnews.data.mappers.user

import ir.amirroid.jetnews.data.models.user.UserResponse
import ir.amirroid.jetnews.domain.models.user.User

fun UserResponse.toDomain(): User {
    return User(
        name = name,
        profileImage = profileImage90,
        userId = userId,
        username = username
    )
}