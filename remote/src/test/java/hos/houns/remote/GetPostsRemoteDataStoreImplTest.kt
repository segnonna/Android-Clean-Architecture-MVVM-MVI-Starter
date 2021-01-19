package hos.houns.remote

import hos.houns.domain.base.functional.Either
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class GetPostsRemoteDataStoreImplTest {

    private lateinit var store: GetPostsRemoteDataStoreImpl
    private lateinit var api: PostApi
    private lateinit var errorFactory: GetPostsErrorFactory

    @BeforeAll
    fun beforeAll() {
        api = mockk()
        errorFactory = mockk()

        coEvery { api.getPosts() } returns emptyList()
        store = GetPostsRemoteDataStoreImpl(api, errorFactory)
    }


    @Test
    fun `Fetch posts with success`() {
        val response = runBlocking { store.fetchPosts() }
        response.shouldBeInstanceOf(Either.Right::class)

    }


}