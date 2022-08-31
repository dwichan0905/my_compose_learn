package idn.dwichan.gmailclone.util

import androidx.activity.ComponentActivity
import idn.dwichan.gmailclone.model.EmailModel
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

object AssetReader {
    fun loadJsonFromAsset(activity: ComponentActivity): String? {
        val json: String? = try {
            val `is`: InputStream = activity.assets.open("data.json")
            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer, Charset.defaultCharset())
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    fun getEmails(activity: ComponentActivity): List<EmailModel> {
        val result = arrayListOf<EmailModel>()
        val json = loadJsonFromAsset(activity)
        if (json != null) {
            val jsonArray = JSONArray(json)
            for (index in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(index)
                result.add(
                    EmailModel(
                        id = obj.getString("_id"),
                        sender = obj.getString("sender"),
                        email = obj.getString("email"),
                        contentMail = obj.getString("contentMail"),
                        time = obj.getString("time"),
                        title = obj.getString("title")
                    )
                )
            }
        }
        return result
    }
}