/*
 * Copyright 2018 Kaidan Gustave
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:Suppress("Unused")
package xyz.laxus.util

import kotlin.concurrent.thread

val lineSeparator get() = System.lineSeparator() ?: "\n"
val currentTime get() = System.currentTimeMillis()

val runtime: Runtime get() = Runtime.getRuntime()

val Runtime.totalMemory get() = totalMemory()
val Runtime.freeMemory get() = freeMemory()
val Runtime.maxMemory get() = maxMemory()

fun propertyOf(key: String): String? = System.getProperty(key)

inline fun onJvmShutdown(name: String, crossinline event: () -> Unit) {
    val thread = thread(name = name, start = false, isDaemon = true) { event() }
    runtime.addShutdownHook(thread)
}