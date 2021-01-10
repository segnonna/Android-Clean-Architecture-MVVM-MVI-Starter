package hos.houns.domain.base

import hos.houns.domain.base.result.Result

interface UseCaseWithoutParam<out T : Result> {
    suspend fun execute(): T
}


interface UseCaseWithParams<out T : Result, in Params> {
    suspend fun execute(params: Params): T
}
