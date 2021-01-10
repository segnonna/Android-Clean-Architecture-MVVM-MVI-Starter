package hos.houns.domain.base.mapper


interface Mapper<in Input, out Output> {
    fun map(input: Input): Output
}


// Non-nullable to Non-nullable
interface ListMapper<Input, Output> : Mapper<List<Input>, List<Output>>

class ListMapperImpl<Input, Output>(
    private val mapper: Mapper<Input, Output>
) : ListMapper<Input, Output> {
    override fun map(input: List<Input>): List<Output> {
        return input.map { mapper.map(it) }
    }
}


// Nullable to Non-nullable
interface NullableInputListMapper<Input, Output> : Mapper<List<Input>?, List<Output>>

class NullableInputListMapperImpl<Input, Output>(
    private val mapper: Mapper<Input, Output>
) : NullableInputListMapper<Input, Output> {
    override fun map(input: List<Input>?): List<Output> {
        return input?.map { mapper.map(it) }.orEmpty()
    }
}


// Non-nullable to Nullable
interface NullableOutputListMapper<Input, Ouput> : Mapper<List<Input>, List<Ouput>?>

class NullableOutputListMapperImpl<Input, Ouput>(
    private val mapper: Mapper<Input, Ouput>
) : NullableOutputListMapper<Input, Ouput> {
    override fun map(input: List<Input>): List<Ouput>? {
        return if (input.isEmpty()) null else input.map { mapper.map(it) }
    }
}