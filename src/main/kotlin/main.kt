import kotlinx.coroutines.*
import kotlin.browser.document
import kotlin.coroutines.CoroutineContext

fun main() {
    document.addEventListener("DOMContentLoaded", {
        Application().start()
    })
}

class Application : CoroutineScope {
    val getBreeds = GetBreeds()
    private var job = Job()
    override val coroutineContext: CoroutineContext
        get() = job

    fun start() {
        launch {
            val breeds = getBreeds()
            document.write(breeds[0].name)
        }
    }

}

