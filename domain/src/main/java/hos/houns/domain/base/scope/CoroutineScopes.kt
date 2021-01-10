package hos.houns.domain.base.scope

import kotlinx.coroutines.CoroutineScope

interface CoroutineScopes {
    val main: CoroutineScope
    val io: CoroutineScope
    val default: CoroutineScope
}