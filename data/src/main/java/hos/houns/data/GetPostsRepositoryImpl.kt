package hos.houns.data

import hos.houns.domain.base.dispatchers.CoroutineDispatchers
import hos.houns.domain.base.error.Failure
import hos.houns.domain.base.functional.Either
import hos.houns.domain.base.functional.flatMap
import hos.houns.domain.entity.PostUiModel
import hos.houns.domain.usecases.GetPostsRepository
import kotlinx.coroutines.withContext

class GetPostsRepositoryImpl(
    private val coroutineDispatchers: CoroutineDispatchers,
    private val getPostsRemoteDataStore: GetPostsRemoteDataStore,
    private val postMapper: PostsMapper
) : GetPostsRepository {
    override suspend fun fetchPosts(): Either<Failure, List<PostUiModel>> {
        return withContext(coroutineDispatchers.io) {
            getPostsRemoteDataStore.fetchPosts().flatMap {
                Either.Right(postMapper.map(it))
            }
        }
    }
}