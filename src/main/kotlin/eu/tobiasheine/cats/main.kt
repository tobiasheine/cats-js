package eu.tobiasheine.cats

import eu.tobiasheine.cats.frontend.catApp
import react.dom.render
import kotlin.browser.document

fun main() {
    render(document.getElementById("app")) {
        catApp()
    }
}
