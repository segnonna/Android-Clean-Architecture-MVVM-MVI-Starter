package hos.houns.presentation.base

import hos.houns.domain.base.result.Result

interface BaseStore<in R : Result> {
    fun dispatchState(result: R)
}
