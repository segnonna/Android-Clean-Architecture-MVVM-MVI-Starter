package hos.houns.remote

import hos.houns.data.GetPostsRemoteDataStore
import hos.houns.data.dataDiModule
import hos.houns.remote.retrofit.retrofitDIModule
import org.koin.dsl.module


val remoteFeaturesModule = module {
    factory { PostApi(get()) }
    factory { GetPostsErrorFactory() }
    single<GetPostsRemoteDataStore> { GetPostsRemoteDataStoreImpl(get(), get()) }
} + dataDiModule + retrofitDIModule


