package com.bennyhuo.kotlin.coroutine.ch01

import com.bennyhuo.kotlin.coroutine.ch01.delay
import kotlinx.coroutines.*


suspend fun getUserSuspend(userId: String): String {
    delay(1000)
    log("Filip")
    return "Filip"
}

fun main(args: Array<String>) {
    val sequence = generatorFib().take(8)
// 2
    sequence.forEach {
        println("$it")
    } }
// 3
fun generatorFib() = sequence {
    // 4
    print("Suspending...")
// 5
    yield(0)
    var cur = 0
    var next = 1
    while (true) {
// 6
        print("Suspending...")
        // 7
        yield(next)
        val tmp = cur + next
        cur = next
        next = tmp }
}


fun log(msg: Any?) = println("[${Thread.currentThread().name}] $msg")