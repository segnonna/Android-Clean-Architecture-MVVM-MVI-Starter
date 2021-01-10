package hos.houns.remote

import hos.houns.data.GetPostsRemoteDataStore
import hos.houns.domain.base.error.Failure
import hos.houns.domain.base.functional.Either
import hos.houns.domain.entity.PostRemote

class GetPostsRemoteDataStoreImpl(
    private val postApi: PostApi,
    private val getPostsErrorFactory: GetPostsErrorFactory
) : GetPostsRemoteDataStore {
    override suspend fun fetchPosts(): Either<Failure, List<PostRemote?>> {
        return try {
            val response = postApi.getPosts()
            Either.Right(response)
        } catch (exception: Exception) {
            exception.printStackTrace()
            Either.Left(getPostsErrorFactory.produce(exception))
        }
    }
}