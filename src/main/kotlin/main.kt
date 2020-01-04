import kotlinx.coroutines.*
import react.*
import react.dom.*
import kotlin.browser.document
import kotlin.coroutines.CoroutineContext

fun main() {
    document.addEventListener("DOMContentLoaded", {
        render(document.getElementById("root")) {
            app()
        }
    })
}

interface AppState : RState {
    var breeds: List<Breed>
}

private class App : RComponent<RProps, AppState>(), CoroutineScope {
    val getCatBreeds = GetCatBreeds()
    private var job = Job()
    override val coroutineContext: CoroutineContext
        get() = job

    override fun componentWillMount() {
//        launch {
//            val breeds = getCatBreeds()
//            setState {
//                this.breeds = breeds
//            }
//        }

        setState {
            this.breeds = emptyList()
        }

    }

    override fun RBuilder.render() {
        label {
            +"Foo"
        }


//        div {
//            h3 {
//                ul {
//                    state.breeds.forEach { item ->
//                        li {
//                            label {
//                                +item.name
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }
}

fun RBuilder.app() = child(App::class) {
}

