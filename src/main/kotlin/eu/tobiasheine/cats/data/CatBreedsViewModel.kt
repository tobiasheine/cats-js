package eu.tobiasheine.cats.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CatBreedsModelViewModel : CoroutineScope {
    var listener: (List<CatBreed>) -> Unit = {}

    private val getCatBreeds = GetCatBreeds()
    private var job = Job()
    override val coroutineContext: CoroutineContext
        get() = job

    fun loadCatBreeds() {
        launch {
            getCatBreeds()
                .also {
                    listener(it)
                }
        }
    }

    fun clear() {
        job.cancel()
    }
}
