package com.smart.webapp.core

import com.lmkj.dsp.core.R
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * @Author luoxh
 * @Email luoxh8@qq.com
 */
@Slf4j
@RestControllerAdvice
class Defender {

    @ExceptionHandler(Exception::class)
    @ResponseBody
    fun handleException(e: Exception): R {
        e.printStackTrace()
        return R.error(Notebook.UNKNOWN_ERROR.status, e.message.orEmpty())
    }
}
