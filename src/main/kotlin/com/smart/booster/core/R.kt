/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 *
 * https://www.renren.io
 *
 *
 * 版权所有，侵权必究！
 */
package com.lmkj.dsp.core

import org.apache.http.HttpStatus
import java.util.*

class R : HashMap<String, Any?>() {
    override fun put(key: String, value: Any?): R {
        super.put(key, value)
        return this
    }

    companion object {
        private const val serialVersionUID = 1L
        fun error(message: String): R {
            return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, message)
        }

        fun error(status: Int = HttpStatus.SC_INTERNAL_SERVER_ERROR, message: String = "Unknown exception, please contact the administrator."): R {
            val r = R()
            r["status"] = status
            r["success"] = false
            r["message"] = message
            return r
        }

        fun ok(message: String): R {
            val r = R()
            r["message"] = message
            return r
        }

        fun ok(map: Map<out String, Any?>): R {
            val r = R()
            r.putAll(map)
            return r
        }

        fun ok(): R {
            return R()
        }
    }

    init {
        put("success", true)
        put("status", 0)
        put("message", "Ok")
    }
}
