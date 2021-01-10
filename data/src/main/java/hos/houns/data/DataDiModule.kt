package hos.houns.data

import hos.houns.domain.domainDIModule
import hos.houns.domain.usecases.GetPostsRepository
import org.koin.dsl.module


val dataDiModule = module {
    factory { PostsMapper }
    factory<GetPostsRepository> { GetPostsRepositoryImpl(get(), get(), get()) }

} + domainDIModule