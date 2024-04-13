package com.bennyhuo.kotlin.coroutine.ch03

import kotlin.coroutines.Continuation
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.createCoroutine
import kotlin.coroutines.resume
fun log(msg: String) {
    println("[${Thread.currentThread().name}] $msg")
}
fun main() {
    val continuation = suspend {
        log("In Coroutine.")
        5
    }.createCoroutine(object : Continuation<Int> {
        override fun resumeWith(result: Result<Int>) {
            log("Coroutine End: $result")
        }

        override val context = EmptyCoroutineContext
    })

    continuation.resume(Unit);

    val race = 100
    val faction = when (race) {
        in 10..20 -> "Keepers of the Mines"
        in 21..50 -> "Keepers of the Mines"
        in 51..70 -> "Free People of the Rolling Hills"
        in 71..100 -> "Free People of the Rolling Hills22222"
        else -> "hello world"
    }
    println(faction)
}