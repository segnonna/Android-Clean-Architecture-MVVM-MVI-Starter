package hos.houns.remote.retrofit

import okhttp3.ResponseBody
import org.json.JSONObject


object ErrorParser {
    private const val MESSAGE_KEY = "message"
    private const val STATUS_KEY = "status"
    fun parse(responseBody: ResponseBody?): ApiError {
        return try {
            val jsonObject = JSONObject(responseBody?.string()!!)
            ApiError().apply {
                if (jsonObject.has(MESSAGE_KEY)) {
                    this.message = jsonObject.getString(MESSAGE_KEY)
                }
                if (jsonObject.has(STATUS_KEY)) {
                    this.status = jsonObject.getInt(STATUS_KEY)
                }
            }
        } catch (e: Exception) {
            ApiError()
        }
    }
}
