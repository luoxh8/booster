package com.smart.booster.core

import java.util.*
import javax.validation.constraints.NotNull


/**
 * @Author luoxh
 * @Email luoxh8@qq.com
 */

data class NoFeatures(
        @NotNull(message = "`router` 不能为空")
        val router: String,
        var query: Map<String, Objects>
)
