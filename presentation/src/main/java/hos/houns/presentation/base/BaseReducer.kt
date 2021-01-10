package hos.houns.presentation.base

import hos.houns.domain.base.result.Result

interface BaseReducer<in R : Result, S : BaseViewState> {
    fun reduce(result: R, state: S?): S

    /**
     * This exception is thrown when an unknown Result is received by the Reducer
     */
    class UndefinedResultException : Throwable("Undefined Result")
}

