import kotlinx.serialization.Serializable

@Serializable
data class Breed(
    val id: String,
    val name: String
)