package com.smart.webapp.core

import com.smart.booster.core.R
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.RequestBody
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.text.SimpleDateFormat
import java.util.*
import javax.validation.Valid

/**
 * @Author luoxh
 * @Email luoxh8@qq.com
 */
@Slf4j
open class Engine {
    var beforeMethods = mutableListOf<Method>()
    var afterMethods = mutableListOf<Method>()
    private val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    private fun delay(s1: String, s2: String) = sdf.parse(s1).time - sdf.parse(s2).time
    private fun currentTimeString(): String = sdf.format(Date())

    open fun dispatch(@RequestBody @Valid model: NoFeatures): Any? {
        val childClassName = this::class.simpleName
        val start = currentTimeString()
        println("")
        println("===============================start at ${start}===============================")
        println("$childClassName: The parameters requested by the client -> $model")

        val data: Any?
        try {
            val method = this::class.java.getDeclaredMethod(model.router, NoFeatures::class.java)
            for (before in beforeMethods) method.invoke(this, model)
            data = method.invoke(this, model)
            for (before in afterMethods) method.invoke(this, model)
            return data
        } catch (e: NoSuchMethodException) {
            return R.error(Notebook.API_NOT_FOUND.status, Notebook.API_NOT_FOUND.message)
                    .put("module", childClassName)
                    .put("model", model)
        } catch (e: IllegalAccessException) {
            return R.error(Notebook.PERMISSION_ERROR.status, Notebook.PERMISSION_ERROR.message)
                    .put("module", childClassName)
                    .put("model", model)
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
            return R.error(Notebook.UNKNOWN_ERROR.status, e.targetException.message!!) // .put("debug", e.getTargetException())
                    .put("module", childClassName)
                    .put("model", model)
        } finally {
            val end = currentTimeString()
            println("==========================end at $end（Time consuming：${delay(start, end)} ms）===============")
            println("")
        }
    }

}
