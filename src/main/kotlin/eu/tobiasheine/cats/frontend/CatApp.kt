package eu.tobiasheine.cats.frontend

import eu.tobiasheine.cats.data.CatBreed
import eu.tobiasheine.cats.data.CatBreedsModelViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import react.*
import react.dom.*
import kotlin.coroutines.CoroutineContext

class CatApp : RComponent<RProps, AppState>(), CoroutineScope {
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

    override fun componentWillUnmount() {
        viewModel.clear()
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

interface AppState : RState {
    var breeds: List<CatBreed>?
}

fun RBuilder.catApp() = child(CatApp::class) {
}