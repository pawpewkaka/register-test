package com.example.register.register.controller

import org.springframework.http.HttpEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/register-service")
class RegisterController {
    @GetMapping("/v1/employees")
    fun getMyWalletId(@RequestParam("employee_id", defaultValue = "") employeeId: Int): HttpEntity<ApiResponse<GetMyWalletIdResponse>> {
        val accessToken = UserContextHolder.getContext().accessToken
        return ResponseFactory.ok(socialService.getMyWalletId(accessToken.truemoneyID))
    }
}