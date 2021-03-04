package hos.houns.presentation

import hos.houns.domain.base.error.Failure
import hos.houns.domain.base.result.Result
import hos.houns.domain.entity.PostUiModel
import hos.houns.domain.usecases.GetPostsResult
import org.amshove.kluent.shouldHaveTheSameClassAs
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

/**
 * Created by Sadate Tchamouza on 3/4/21.
 */
internal class GetPostsReducerTest {
    @ParameterizedTest
    @MethodSource("providedData")
    fun `Test Get Post Reducer`(input: Result, output: GetPostState) {
        GetPostsReducer().reduce(input, null)
            .shouldHaveTheSameClassAs(output)
    }

    companion object {
        @JvmStatic
        fun providedData() = listOf(
            Arguments.of(
                GetPostsResult.Success(listOf(PostUiModel.EMPTY)),
                GetPostState.SuccessState(listOf(PostUiModel.EMPTY))
            ),
            Arguments.of(
                GetPostsResult.Error(Failure.ServerError),
                GetPostState.ErrorState(Failure.ServerError)
            )
        )
    }
}