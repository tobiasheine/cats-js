import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import react.*
import react.dom.*
import kotlin.browser.document
import kotlin.coroutines.CoroutineContext

fun main() {
    render(document.getElementById("app")) {
        app()
    }
}

interface AppState : RState {
    var breeds: List<CatBreed>?
}

private class App : RComponent<RProps, AppState>(), CoroutineScope {
    private val viewModel = CatBreedsModelViewModel()
    private var job = Job()
    override val coroutineContext: CoroutineContext
        get() = job

    override fun componentDidMount() {
        viewModel.listener = {
            setState {
                this.breeds = it
            }
        }

        viewModel.loadCatBreeds()
    }

    override fun RBuilder.render() {
        div {
            h3 {
                label {
                    +"Cat Breeds:"
                }
                ul {
                    state.breeds?.forEach { item ->
                        li {
                            label {
                                +item.name
                            }
                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.app() = child(App::class) {
}
