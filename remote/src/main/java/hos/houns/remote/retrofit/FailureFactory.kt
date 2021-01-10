package hos.houns.remote.retrofit


import hos.houns.domain.base.error.Failure
import retrofit2.HttpException
import retrofit2.Response
import java.net.SocketTimeoutException


interface BaseFailureFactory {
    fun produce(exception: Exception): Failure
}

const val HTTP_INTERNAL_SERVER_ERROR = 500

abstract class FailureFactory : BaseFailureFactory {

    abstract fun handleFeatureError(error: ApiError): Failure


    override fun produce(exception: Exception): Failure {
        return when (exception) {
            is SocketTimeoutException -> Failure.ServerTimeoutError
            is HttpException -> {
                val response = exception.response()
                return handleHttpCode(response)
            }
            else -> Failure.UnknownError
        }
    }


    private fun <T> handleHttpCode(response: Response<T>?): Failure {
        return when (response?.code()) {
            HTTP_INTERNAL_SERVER_ERROR -> Failure.ServerError
            in arrayOf(400, 403) -> {
                val apiError = ErrorParser.parse(response?.errorBody())
                handleFeatureError(apiError)
            }
            else -> Failure.UnknownError
        }
    }
}
