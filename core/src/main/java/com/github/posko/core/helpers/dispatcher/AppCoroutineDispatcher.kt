package com.github.posko.core.helpers.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface AppCoroutineDispatcher {

    fun ui () : CoroutineDispatcher

    fun io () : CoroutineDispatcher
}