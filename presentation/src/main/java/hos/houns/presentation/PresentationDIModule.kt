package hos.houns.presentation

import hos.houns.presentation.base.Store
import hos.houns.remote.remoteFeaturesModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


@ExperimentalCoroutinesApi
@FlowPreview
val sharedPresentationModule = module {
    viewModel {
        GetPostViewModel(
            Store(
                get<GetPostsReducer>(named(GetPostsReducer.name)),
                GetPostState.LoadingState
            ), get()
        )
    }

    factory(named(GetPostsReducer.name)) { GetPostsReducer() }
} + remoteFeaturesModule
