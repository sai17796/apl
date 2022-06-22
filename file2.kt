import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

fun main(args : Array<String>) {


    val client = OkHttpClient()

    val request = Request.Builder()
        .url("https://edamam-food-and-grocery-database.p.rapidapi.com/parser?ingr=apple")
        .get()
        .addHeader("X-RapidAPI-Key", "633dab081fmsh36975f8c82c3764p121ec9jsned26e8e58094")
        .addHeader("X-RapidAPI-Host", "edamam-food-and-grocery-database.p.rapidapi.com")
        .build()

    val respons = client.newCall(request).execute()
    val gson= Gson()
    // val data=gson.fromJson(response.body?.string(),Data::class.java)
    //  print(data.parsed[0].food.foodId)
    print(respons.body?.string())


}

data class Data(
    val text:String,
    val parsed:Array<Parse>
)
data class Parse(

    val food:Food
)
data class Food(

    val foodId:String
)