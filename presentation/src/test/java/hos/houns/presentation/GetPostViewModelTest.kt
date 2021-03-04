package hos.houns.presentation

import hos.houns.domain.base.error.Failure
import hos.houns.domain.base.result.Result
import hos.houns.domain.entity.PostUiModel
import hos.houns.domain.usecases.GetPostsResult
import hos.houns.domain.usecases.GetPostsUseCase
import hos.houns.presentation.base.Store
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

/**
 * Created by Sadate Tchamouza on 3/4/21.
 */
@ExperimentalCoroutinesApi
@FlowPreview
@ExtendWith(InstantExecutorExtension::class, CoroutinesTestExtension::class)
internal class GetPostViewModelTest {
    private lateinit var getPostsUseCase: GetPostsUseCase
    private lateinit var reducer: GetPostsReducer
    private lateinit var viewModel: GetPostViewModel
    private lateinit var store: Store<Result, GetPostState>

    @BeforeEach
    fun setUp() {
        reducer = mockk(relaxed = true)
        store = Store(reducer, GetPostState.InitialState)
        getPostsUseCase = mockk()
        viewModel = GetPostViewModel(store, getPostsUseCase)
    }

    @Test
    fun `Check if viewModel dispatch success result in case of success`() {
        runBlocking {
            coEvery {  getPostsUseCase() } returns GetPostsResult.Success(
                listOf(PostUiModel.EMPTY)
            )
            viewModel.processIntents(GetPostIntent.LoadPostIntent)
            coVerify { store.dispatchState(GetPostsResult.Success(listOf(PostUiModel.EMPTY))) }
        }
    }

    @Test
    fun `Check if viewModel dispatch error result in case of error`() {
        runBlocking {
            coEvery {
                getPostsUseCase()
            } returns GetPostsResult.Error(Failure.ServerError)

            viewModel.processIntents(GetPostIntent.LoadPostIntent)

            coVerify { store.dispatchState(GetPostsResult.Error(Failure.ServerError)) }
        }
    }
}