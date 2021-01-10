package hos.houns.data

import hos.houns.domain.base.error.Failure
import hos.houns.domain.base.functional.Either
import hos.houns.domain.entity.PostRemote

interface GetPostsRemoteDataStore {
    suspend fun fetchPosts(): Either<Failure, List<PostRemote?>>
}