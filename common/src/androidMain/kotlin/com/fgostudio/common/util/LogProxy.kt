package com.fgostudio.common.util

import android.util.Log

actual fun getLogProxy(tag: String): ILogProxy {
    return object : ILogProxy {
        override fun d(msg: String) {
            Log.d(tag, msg)
        }

        override fun d(msg: String, thr: Throwable) {
            Log.d(tag, msg, thr)
        }

        override fun e(msg: String) {
            Log.e(tag, msg)
        }

        override fun e(msg: String, thr: Throwable) {
            Log.e(tag, msg, thr)
        }

        override fun i(msg: String) {
            Log.i(tag, msg)
        }

        override fun i(msg: String, thr: Throwable) {
            Log.i(tag, msg, thr)
        }

        override fun w(msg: String) {
            Log.w(tag, msg)
        }

        override fun w(msg: String, thr: Throwable) {
            Log.w(tag, msg, thr)
        }

    }
}