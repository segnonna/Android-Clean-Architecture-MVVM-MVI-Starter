package hos.houns.data

import hos.houns.domain.base.dispatchers.CoroutineDispatchersImpl
import hos.houns.domain.base.error.Failure
import hos.houns.domain.base.functional.Either
import hos.houns.domain.entity.PostUiModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldHaveTheSameClassAs
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class GetPostsRepositoryImplTest {

    private lateinit var repo: GetPostsRepositoryImpl
    private lateinit var store: GetPostsRemoteDataStore
    private lateinit var mapper: PostsMapper

    @BeforeAll
    fun setUp() {
        store = spyk()
        mapper = mockk()

        repo = GetPostsRepositoryImpl(CoroutineDispatchersImpl(), store, mapper)
    }


    @Nested
    inner class `In success scenario` {
        init {
            coEvery { mapper.map(any()) } returns emptyList()
            coEvery { store.fetchPosts() } returns Either.Right(emptyList())
        }

        @Test
        fun `Check if fetchPosts is called`() = runBlocking {
            repo.fetchPosts()
            coVerify { store.fetchPosts() }
        }

        @Test
        fun `should return Success when repo send Either type Right`() {
            val response = runBlocking { repo.fetchPosts() }
            response shouldBeInstanceOf Either.Right::class
            response shouldHaveTheSameClassAs Either.Right(emptyList<PostUiModel>())
        }
    }

    @Nested
    inner class `In failure scenario` {
        init {
            coEvery { mapper.map(any()) } returns emptyList()
            coEvery { store.fetchPosts() } returns Either.Left(Failure.ServerError)
        }

        @Test
        fun `should return Success when repo send Either type Right`() {
            val failure = Either.Left(Failure.ServerError)

            val response = runBlocking { repo.fetchPosts() }

            response shouldBeInstanceOf Either.Left::class
            response shouldEqual failure

        }
    }
}