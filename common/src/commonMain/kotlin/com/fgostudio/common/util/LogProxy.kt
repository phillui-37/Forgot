package com.fgostudio.common.util

interface ILogProxy {
    fun d(msg: String)
    fun e(msg: String)
    fun i(msg: String)
    fun w(msg: String)

    fun d(msg: String, thr: Throwable)
    fun e(msg: String, thr: Throwable)
    fun i(msg: String, thr: Throwable)
    fun w(msg: String, thr: Throwable)
}

expect fun getLogProxy(tag: String): ILogProxy