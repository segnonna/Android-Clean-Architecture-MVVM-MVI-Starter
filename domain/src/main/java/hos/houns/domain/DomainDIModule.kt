package hos.houns.domain

import hos.houns.domain.base.dispatchers.CoroutineDispatchers
import hos.houns.domain.base.dispatchers.CoroutineDispatchersImpl
import hos.houns.domain.base.scope.CoroutineScopes
import hos.houns.domain.base.scope.CoroutineScopesImpl
import hos.houns.domain.usecases.GetPostsUseCase
import hos.houns.domain.usecases.GetPostsUseCaseImpl
import org.koin.dsl.module

val domainDIModule = module {
    single<CoroutineDispatchers> { CoroutineDispatchersImpl() }
    single<CoroutineScopes> { CoroutineScopesImpl() }
    single<GetPostsUseCase> { GetPostsUseCaseImpl(get()) }
}
