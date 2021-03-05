package hos.houns.presentation

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext

/**
 * Created by Sadate Tchamouza on 3/4/21.
 */

/**
 * This basically does two things:
 * set a delegate before each test that updates live data values immediately on the calling thread
 * remove the delegate after each tests to avoid influencing other tests.
 *
 * For JUnit 5 however the concept of Rule and TestRunner are merged
 * into one single concept of Extensions
 */

class InstantExecutorExtension : BeforeEachCallback, AfterEachCallback {

    override fun beforeEach(context: ExtensionContext?) {
        ArchTaskExecutor.getInstance()
            .setDelegate(object : TaskExecutor() {
                override fun executeOnDiskIO(runnable: Runnable) = runnable.run()

                override fun postToMainThread(runnable: Runnable) = runnable.run()

                override fun isMainThread(): Boolean = true
            })
    }

    override fun afterEach(context: ExtensionContext?) {
        ArchTaskExecutor.getInstance().setDelegate(null)
    }

}