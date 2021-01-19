package hos.houns.domain.entity

data class PostRemote(
    val userId: Long?,
    val id: Long?,
    val title: String?,
    val body: String?,
    val peopleCount: Int?
) {
    companion object {
        val EMPTY = PostRemote(0L, 0L, "", "", 0)
    }
}