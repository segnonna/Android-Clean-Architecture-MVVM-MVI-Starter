package hos.houns.presentation.base


import androidx.lifecycle.LiveData

interface BaseViewModel<in I : BaseIntent, out S : BaseViewState> {
    suspend fun processIntents(intent: I)

    fun states(): LiveData<out S>
}