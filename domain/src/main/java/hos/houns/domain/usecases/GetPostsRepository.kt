package hos.houns.domain.usecases

import hos.houns.domain.base.error.Failure
import hos.houns.domain.base.functional.Either
import hos.houns.domain.entity.PostUiModel

interface GetPostsRepository {
    suspend fun fetchPosts(): Either<Failure, List<PostUiModel>>
}