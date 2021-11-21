package com.sinaseyfi.cryptolistsample

import com.sinaseyfi.log.Logger
import timber.log.Timber
import javax.inject.Inject

class AppLogger @Inject constructor(): Logger {

    override fun error(message: String) {
        Timber.e(message)
    }

    override fun error(throwable: Throwable) {
        Timber.e(throwable)
    }

    override fun warn(message: String) {
        Timber.w(message)
    }

    override fun warn(throwable: Throwable) {
        Timber.w(throwable)
    }

    override fun info(message: String) {
        Timber.i(message)
    }

}