package com.sinaseyfi.log

interface Logger {

    fun error(message: String)

    fun error(throwable: Throwable)

    fun warn(message:String)

    fun warn(throwable: Throwable)

    fun info(message: String)

}