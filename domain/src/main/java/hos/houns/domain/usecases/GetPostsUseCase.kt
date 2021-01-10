package hos.houns.domain.usecases

import hos.houns.domain.base.UseCaseWithoutParam
import hos.houns.domain.base.error.Failure
import hos.houns.domain.base.functional.Either
import hos.houns.domain.entity.PostUiModel

interface GetPostsUseCase : UseCaseWithoutParam<GetPostsResult> {
    suspend operator fun invoke() = execute()
}

class GetPostsUseCaseImpl(private val getPostsRepository: GetPostsRepository) : GetPostsUseCase {
    override suspend fun execute() = getPostsRepository.fetchPosts().toResult()

    private fun Either<Failure, List<PostUiModel>>.toResult() =
        when (this) {
            is Either.Left -> GetPostsResult.Error(this.a)
            is Either.Right -> GetPostsResult.Success(this.b)
        }

}