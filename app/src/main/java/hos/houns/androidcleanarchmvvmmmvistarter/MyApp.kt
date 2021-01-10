package hos.houns.androidcleanarchmvvmmmvistarter

import androidx.multidex.MultiDexApplication
import hos.houns.presentation.sharedPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class MyApp : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(sharedPresentationModule)
        }
    }
}