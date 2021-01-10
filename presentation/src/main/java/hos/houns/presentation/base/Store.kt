package hos.houns.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.distinctUntilChanged
import hos.houns.domain.base.result.Result

class Store<in R : Result, out S : BaseViewState>(
    private val reducer: BaseReducer<R, S>,
    private val initialState: S
) : BaseStore<R> {

    private val _viewStateD = MutableLiveData<S>().apply { value = initialState }

    //val viewState: LiveData<out S> = _viewStateD.distinctUntilChanged()
    val viewState: LiveData<out S> = _viewStateD.distinctUntilChanged()

    // TODO make this function suspend and perform context switching to set state value
    override fun dispatchState(result: R) {
        val state = reducer.reduce(result, viewState.value)
        _viewStateD.postValue(state)
    }


    companion object {
        const val SUFFIX = "Store"
    }

}