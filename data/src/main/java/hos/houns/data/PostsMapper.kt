package hos.houns.data

import hos.houns.domain.base.mapper.NullableInputListMapper
import hos.houns.domain.entity.PostRemote
import hos.houns.domain.entity.PostUiModel
import kotlin.random.Random

object PostsMapper : NullableInputListMapper<PostRemote?, PostUiModel> {
    override fun map(input: List<PostRemote?>?): List<PostUiModel> {
        val value = mutableListOf<PostUiModel>()
        input?.let {
            it.forEach { remote ->
                value.add(
                    PostUiModel(
                        remote?.userId ?: 0L,
                        remote?.id ?: 0L,
                        remote?.title ?: "",
                        0,
                        remote?.body ?: "",
                        Random(30).nextInt()
                    )
                )
            }
        }
        return value.toList()
    }
}