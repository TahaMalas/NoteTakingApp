package com.appagroup.common.coroutines

import kotlin.coroutines.experimental.CoroutineContext

interface ICoroutineContextProvider {

    fun provideUIContext(): CoroutineContext

    fun provideBackgroundContext(): CoroutineContext

}