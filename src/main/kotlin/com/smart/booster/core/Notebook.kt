package com.smart.webapp.core

/**
 * @Author luoxh
 * @Email luoxh8@qq.com
 */
enum class Notebook(val status: Int, val message: String) {
    // 常见错误
    PARAMETER_ERROR(400, "Parameter error."),
    ORIGINAL_PASSWORD(400, "The original password is wrong."),
    TWO_PASSWORDS_DIFFERENT(400, "The two passwords are different."),
    CORRESPONDING_ITEM_ALREADY_EXISTS(400, "The corresponding item already exists."),
    NOT_AN_ADMINISTRATOR(401, "You are not an administrator."),
    PERMISSION_ERROR(401, "You do not have permission to access the router."),
    USER_SIGN_AGAIN(402, "User information is abnormal, please log in again."),
    API_NOT_FOUND(404, "Api not found."),
    PASSWORD_VERIFICATION_FAILED(404, "The entered password verification failed."),
    NOT_FIND_CORRESPONDING_SHOP(404, "Cannot find the corresponding shop."),
    CORRESPONDING_ITEM_NOT_FOUND(404, "The corresponding item cannot be found."),

    CURRENT_USER_IS_BLOCK(400, "Current user is blocked."),

    CURRENT_USER_IS_NULL(400, "Current user is null."),
    CURRENT_ORG_IS_NULL(400, "Current org is null."),
    Target_ORG_IS_NULL(404, "Target org is null."),

    // 未知错误
    UNKNOWN_ERROR(9999, "Unknown error, please contact the administrator.")
}
