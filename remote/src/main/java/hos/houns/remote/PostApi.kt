package hos.houns.remote

import hos.houns.domain.entity.PostRemote
import retrofit2.Retrofit
import retrofit2.http.GET

interface PostApi {

    @GET(GET_POSTS)
    suspend fun getPosts(): List<PostRemote>

    companion object {
        const val GET_POSTS = "posts"
        operator fun invoke(retrofit: Retrofit) = retrofit.create(PostApi::class.java)
    }
}