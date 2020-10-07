package com.smart.webapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@SpringBootApplication
class Application {
    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource? {
        val configuration = CorsConfiguration()
        configuration.allowedOrigins = listOf("*")
        configuration.allowedMethods = listOf("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH")
        configuration.allowCredentials = true
        configuration.allowedHeaders = listOf("Authorization", "Cache-Control", "Content-Type")
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
