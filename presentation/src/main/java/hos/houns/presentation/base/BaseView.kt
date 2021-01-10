package hos.houns.presentation.base

import kotlinx.coroutines.flow.Flow

interface BaseView<out I : BaseIntent, in S : BaseViewState> {
    fun intents(): Flow<I>

    fun render(state: S)
}