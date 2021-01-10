package hos.houns.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hos.houns.domain.base.result.Result
import hos.houns.domain.usecases.GetPostsResult
import hos.houns.domain.usecases.GetPostsUseCase
import hos.houns.presentation.base.BaseViewModel
import hos.houns.presentation.base.Store
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

@FlowPreview
@ExperimentalCoroutinesApi
class GetPostViewModel(
    private val store: Store<Result, GetPostState>,
    private val getPostsUseCase: GetPostsUseCase
) : BaseViewModel<GetPostIntent, GetPostState>, ViewModel() {

    private val _intentChannel = BroadcastChannel<GetPostIntent>(capacity = Channel.CONFLATED)

    override suspend fun processIntents(intent: GetPostIntent) = _intentChannel.send(intent)

    init {
        _intentChannel
            .asFlow()
            .getResult()
            .launchIn(viewModelScope)
    }

    override fun states(): LiveData<out GetPostState> = store.viewState

    private fun Flow<GetPostIntent>.getResult() = onEach {
        when (it) {
            GetPostIntent.LoadPostIntent -> fetchPosts()
        }
    }

    private fun fetchPosts() {
        flow {
            this.emit(getPostsUseCase())
        }.onStart { this.emit(GetPostsResult.Progress) }
            .onEach { store.dispatchState(it) }
            .launchIn(viewModelScope)
    }
}