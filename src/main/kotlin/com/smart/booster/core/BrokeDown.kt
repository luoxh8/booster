package com.smart.booster.core

/**
 * @Author luoxh
 * @Email luoxh8@qq.com
 */

data class BrokeDown(val status: Int? = null, override val message: String? = null) : Exception()
