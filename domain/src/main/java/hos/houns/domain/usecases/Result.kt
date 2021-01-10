package hos.houns.domain.usecases

import hos.houns.domain.base.error.Failure
import hos.houns.domain.base.result.Result
import hos.houns.domain.entity.PostUiModel

sealed class GetPostsResult : Result {
    object Progress : GetPostsResult()
    data class Success(val posts: List<PostUiModel>) : GetPostsResult()
    data class Error(val error: Failure) : GetPostsResult()
}