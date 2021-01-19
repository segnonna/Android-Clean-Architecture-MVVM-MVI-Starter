package hos.houns.domain.entity

data class PostUiModel(
    val userId: Long,
    val id: Long,
    val title: String,
    val image: Int,
    val body: String,
    val peopleCount: Int
) {
    companion object {
        val EMPTY = PostUiModel(0L, 0L, "", 0, "", 0)
    }
}