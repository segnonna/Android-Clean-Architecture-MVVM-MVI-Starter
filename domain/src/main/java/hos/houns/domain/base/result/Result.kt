package hos.houns.domain.base.result

import hos.houns.domain.base.error.Failure

interface Result {
    open class Error(val error: Failure) : Result

    open class Success<T>(val data: T) : Result

    interface Loading
}
