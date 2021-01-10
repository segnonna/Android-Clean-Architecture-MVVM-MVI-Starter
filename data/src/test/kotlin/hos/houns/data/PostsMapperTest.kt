package hos.houns.data

import hos.houns.domain.entity.PostRemote
import hos.houns.domain.entity.PostUiModel
import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class PostsMapperTest {

    @ParameterizedTest
    @MethodSource("provideData")
    fun `Test mapping`(input: List<PostRemote?>?, expected: List<PostUiModel>) {
        val mapper = PostsMapper.map(input)
        mapper.`should equal`(expected)

    }

    companion object {

        @JvmStatic
        fun provideData() = listOf(
            Arguments.of(emptyList<PostRemote?>(), emptyList<PostUiModel>())

        )
    }
}