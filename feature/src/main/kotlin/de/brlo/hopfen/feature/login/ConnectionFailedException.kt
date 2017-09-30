package de.brlo.hopfen.feature.login

import com.google.android.gms.common.ConnectionResult
import org.json.JSONException
import org.json.JSONObject

class ConnectionFailedException internal constructor(result: ConnectionResult) : Throwable(getStatusCode(result)) {

  companion object {

    private val CONNECTION_RESULT = "ConnectionResult"
    private val STATUS_CODE = "statusCode"

    private fun getStatusCode(result: ConnectionResult): String {
      return try {
        JSONObject(result.toString().substring(CONNECTION_RESULT.length)).getString(STATUS_CODE)
      } catch (ignored: JSONException) {
        "PARSE_EXCEPTION"
      }
    }
  }
}
