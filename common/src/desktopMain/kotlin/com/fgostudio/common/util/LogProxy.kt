package com.fgostudio.common.util

import org.slf4j.LoggerFactory

class LogProxy(private val tag: String) : ILogProxy {

    private val logger = LoggerFactory.getLogger(tag)

    override fun d(msg: String) {
        logger.debug(msg)
    }

    override fun d(msg: String, thr: Throwable) {
        logger.debug(msg, thr)
    }

    override fun e(msg: String) {
        logger.error(msg)
    }

    override fun e(msg: String, thr: Throwable) {
        logger.error(msg, thr)
    }

    override fun i(msg: String) {
        logger.info(msg)
    }

    override fun i(msg: String, thr: Throwable) {
        logger.info(msg, thr)
    }

    override fun w(msg: String) {
        logger.warn(msg)
    }

    override fun w(msg: String, thr: Throwable) {
        logger.warn(msg, thr)
    }

}

actual fun getLogProxy(tag: String): ILogProxy = LogProxy(tag)