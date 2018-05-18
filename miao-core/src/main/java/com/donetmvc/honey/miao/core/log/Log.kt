package com.donetmvc.honey.miao.core.log

import android.os.Handler
import android.os.Looper
import android.os.Message
import okio.BufferedSink
import okio.Okio
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

object Log {

    private var file: File? = null

    init {
        file = createFile()
    }

    fun log(message: String) {

    }

    class LogHandler constructor(looper: Looper): Handler(looper) {
        override fun handleMessage(msg: Message?) {
            val content = msg?.obj as String
            writeLog(content)
        }
    }

    @Synchronized
    private fun createFile(): File? {
        if(file == null) {
            val folder = File("")
            if (!folder.exists()) {
                folder.mkdirs()
            }

            file = File(folder, String.format("%s_%s.csv", "", null))
            if(!file!!.exists()) {
                file?.createNewFile()
            }
        }

        return file
    }

    private fun writeLog(msg: String) {
        var wSink: BufferedSink? = null

        try {
            val sink = Okio.appendingSink(file)
            wSink = Okio.buffer(sink)
            wSink?.writeUtf8("$msg\n")
            wSink?.flush()
        }
        catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        catch (e: IOException) {
            e.printStackTrace()
        }
        finally {
            try {
                wSink?.close()
            }
            catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}