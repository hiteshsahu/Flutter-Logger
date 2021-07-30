package com.hiteshsahu.basetemplate.common.log

import android.util.Log
import java.util.*

/**
 * Call [AppLog.addLogger] to register a logger. Eg: [AndroidLogger]
 *
 *
 * Tag names are automatically generated based on the current stack trace
 * as well as method and line numbers to help figure out where the logs come from.
 */
object AppLog {

    /**
     * Default tag prefix useful for finding logs easily in logcat
     */
    private const val DEFAULT_TAG_PREFIX = "PANEL"
    private val loggers: MutableList<Logger> = ArrayList()

    @JvmStatic fun clearLoggers() {
        loggers.clear()
    }

    @JvmStatic fun addLogger(logger: Logger) {
        loggers.add(logger)
    }

    @JvmStatic fun d(message: String, vararg args: Any) {
        log(Log.DEBUG, createTag(), formatMessage(message, args))
    }

    @JvmStatic fun d(tag: String, message: String, vararg args: Any) {
        log(Log.DEBUG, tag, formatMessage(message, args))
    }

    @JvmStatic fun i(message: String) {
        log(Log.INFO, createTag(), message)
    }

    @JvmStatic fun i(tag: String, message: String, vararg args: Any) {
        log(Log.INFO, tag, formatMessage(message, args))
    }

    @JvmStatic fun e(message: String) {
        log(Log.ERROR, createTag(), message)
    }

    @JvmStatic fun e(tag: String, message: String, vararg args: Any) {
        log(Log.ERROR, tag, formatMessage(message, args))
    }

    @JvmStatic fun w(message: String) {
        log(Log.WARN, createTag(), message)
    }

    @JvmStatic fun w(tag: String, message: String, vararg args: Any) {
        log(Log.WARN, tag, formatMessage(message, args))
    }

    @JvmStatic fun wtf(message: String) {
        log(Log.ASSERT, createTag(), message)
    }

    @JvmStatic fun wtf(tag: String, message: String, vararg args: Any) {
        log(Log.ASSERT, tag, formatMessage(message, args))
    }

    private fun formatMessage(message: String, args: Array<out Any>): String {
        return String.format(message, *args)
    }

    private fun log(priority: Int, tag: String, message: String) {
        val prefixedTag = addTagPrefix(tag)
        val logMessage = createLogMessage(message)
        for (logger in loggers) {
            logger.log(priority, prefixedTag, logMessage)
        }
    }

    private fun createTag(): String {
        return findStackTraceElement().fileName
            .replace(".kt", "")
            .replace(".java", "")
    }

    private fun addTagPrefix(tag: String): String {
        return "$DEFAULT_TAG_PREFIX|$tag"
    }

    private fun findStackTraceElement(): StackTraceElement {
        return Throwable().stackTrace
            .first { element -> element.fileName != AppLog::class.java.simpleName + ".kt" }
    }

    private fun createLogMessage(value: String): String {
        val reference = findStackTraceElement()
        return value +
                " (" + reference.fileName
            .replace(".java", "")
            .replace(".kt", "") +
                "#" + reference.methodName + ":" + reference.lineNumber + ")"
    }
}
