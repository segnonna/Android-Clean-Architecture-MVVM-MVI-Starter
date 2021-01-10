package hos.houns.domain.usecases

import hos.houns.domain.base.error.Failure
import hos.houns.domain.base.functional.Either
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.`should be instance of`
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class GetPostsUseCaseImplTest {

    private lateinit var repo: GetPostsRepository

    private lateinit var usecase: GetPostsUseCaseImpl

    @BeforeAll
    fun setUp() {
        repo = mockk()
        usecase = GetPostsUseCaseImpl(repo)
    }

    @Nested
    inner class `In positive scenario` {

        init {
            coEvery { repo.fetchPosts() } returns Either.Right(emptyList())
        }

        @Test
        fun `Check if fetchPosts is called`() = runBlocking {
            usecase()
            coVerify { repo.fetchPosts() }
        }

        @Test
        fun `should return Success when repo send Either type Right`() = runBlocking {
            val registerNumber = usecase()
            registerNumber `should be instance of` GetPostsResult.Success::class
        }

    }

    @Nested
    inner class `In Negative scenario` {
        private var failure: Failure = Failure.UnknownError

        init {
            coEvery { repo.fetchPosts() } returns Either.Left(Failure.UnknownError)
        }

        @Test
        fun `should return Error when repo send Either type Left`() = runBlocking {

            val expectedError = runBlocking { usecase() }

            (expectedError as GetPostsResult.Error).error.`should be instance of`<Failure.UnknownError>()
            expectedError.error.`should be instance of`(failure::class)
        }
    }

}