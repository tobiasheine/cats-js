import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import kotlinx.serialization.list

@UnstableDefault
class GetCatBreeds {

    private val httpClient = HttpClient(Js)

    suspend operator fun invoke(): List<CatBreed> {
        val jsonString = httpClient.get<String>(URL)
        return Json.nonstrict.parse(CatBreed.serializer().list, jsonString)
    }

    private companion object {
        const val URL = "https://api.thecatapi.com/v1/breeds?api_key=c85ccabd-68a5-4333-bc95-8133b8b7a9c4"
    }

}