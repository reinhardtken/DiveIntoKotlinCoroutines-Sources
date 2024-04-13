package com.bennyhuo.kotlin.coroutine.ch01

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

//fun log(msg: String) {
//    println("[${Thread.currentThread().name}] $msg")
//}
fun main(args: Array<String>) {
    loopMain {
        runOnIOThread {
            log("A")
            delay(1000) {
                log("B")
                runOnMainThread {
                    log("C")
                }
            }
        }
    }
}

fun loopMain(block: () -> Unit) {
    Looper.prepareMainLooper()
    runOnIOThread(block)
    Looper.loop()
}

val ioExecutor =
    Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
val delayExecutor = Executors.newScheduledThreadPool(1)
val mainExecutor by lazy { Handler(Looper.getMainLooper()) }

fun runOnIOThread(block: () -> Unit) {
    ioExecutor.execute(block)
}

fun runOnMainThread(block: () -> Unit) {
    mainExecutor.post(block)
}

fun delay(ms: Long, block: () -> Unit) {
    delayExecutor.schedule(block, ms, TimeUnit.MILLISECONDS)
}