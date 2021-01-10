package hos.houns.presentation

import hos.houns.domain.base.error.Failure
import hos.houns.domain.entity.PostUiModel
import hos.houns.presentation.base.BaseIntent
import hos.houns.presentation.base.BaseViewState

sealed class GetPostState : BaseViewState {
    object LoadingState : GetPostState()
    data class ErrorState(val failure: Failure) : GetPostState()
    data class SuccessState(val data: List<PostUiModel>) : GetPostState()
}

sealed class GetPostIntent : BaseIntent {
    object LoadPostIntent : GetPostIntent()
}
