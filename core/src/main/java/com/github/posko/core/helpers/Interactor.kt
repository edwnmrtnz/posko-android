package com.github.posko.core.helpers

import kotlinx.coroutines.*
import com.github.posko.core.helpers.dispatcher.AppCoroutineDispatcher

/**
 * Created by edwin on 10/03/2018.
 */
abstract class  Interactor<out R, in P> (
    dispatcher: AppCoroutineDispatcher
) {
    private val job = SupervisorJob()
    private val scope : CoroutineScope = CoroutineScope(dispatcher.io() + job)

    abstract suspend fun start(param : P) : R

    //Use this method when in other use cases
    suspend fun execute(param : P) : R {
        val data = scope.async { start(param) }
        return data.await()
    }


    fun cancel() {
        scope.coroutineContext.cancelChildren()
    }
}