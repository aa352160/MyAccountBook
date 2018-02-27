package com.rongke.myaccountbook.util

import java.util.concurrent.Executors

/**
 * Created by jh352160 on 2018/2/27.
 */

/**
 * Utility method to run blocks on a dedicated background thread, used for io/database work.
 */
private val IO_EXECUTOR = Executors.newSingleThreadExecutor()
fun ioThread(f : () -> Unit) {
    IO_EXECUTOR.execute(f)
}
