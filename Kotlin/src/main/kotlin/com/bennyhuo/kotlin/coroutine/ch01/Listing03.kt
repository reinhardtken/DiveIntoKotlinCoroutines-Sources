package com.bennyhuo.kotlin.coroutine.ch01

import kotlin.concurrent.thread
fun log(msg: String) {
    println("[${Thread.currentThread().name}] $msg")
}
fun main(args: Array<String>) {
    val callback = {
        log("D")
    }

    val task = {
        log("C")
        callback()
    }

    log("A")
    thread(block = task)
    log("B")
}