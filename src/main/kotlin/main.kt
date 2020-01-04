import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.html.dom.append
import kotlinx.html.h1
import kotlinx.html.label
import kotlinx.html.li
import kotlinx.html.ul
import kotlin.browser.document

fun main() {
    val getCatBreeds = GetCatBreeds()

    GlobalScope.launch {
        val breeds = getCatBreeds()
        render(breeds)
    }
}

private fun render(breeds: List<CatBreed>) {
    document.getElementById("app")
        ?.also { it.innerHTML = "" }
        ?.append {
            h1 { +"Cat Breeds" }
            ul {
                breeds.forEach {
                    li {
                        label {
                            text(it.name)
                        }
                    }
                }
            }
        }
}