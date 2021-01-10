package hos.houns.presentation

import hos.houns.domain.base.result.Result
import hos.houns.domain.usecases.GetPostsResult
import hos.houns.presentation.base.BaseReducer

class GetPostsReducer : BaseReducer<Result, GetPostState> {
    override fun reduce(result: Result, state: GetPostState?): GetPostState {
        //println("GetPostsReducer: $result, $state")
        return when (result) {
            GetPostsResult.Progress -> GetPostState.LoadingState
            is GetPostsResult.Error -> GetPostState.ErrorState(result.error)
            is GetPostsResult.Success -> GetPostState.SuccessState(result.posts)
            else -> throw BaseReducer.UndefinedResultException()
        }
    }

    companion object {
        val name = GetPostsReducer::class.java.name
    }
}