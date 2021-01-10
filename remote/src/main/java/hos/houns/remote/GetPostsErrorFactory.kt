package hos.houns.remote

import hos.houns.domain.base.error.Failure
import hos.houns.remote.retrofit.ApiError
import hos.houns.remote.retrofit.FailureFactory

class GetPostsErrorFactory : FailureFactory() {
    override fun handleFeatureError(error: ApiError): Failure {
        return when (error.status) {

            else -> Failure.UnknownError
        }
    }
}