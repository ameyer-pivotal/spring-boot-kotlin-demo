package com.demo

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

data class Martian(val humanName: String, val nativeName: String)

@RestController
class MartianController {
    @RequestMapping("/martian")
    fun getMartian(@RequestParam name: String): Martian {
        val martianName = name.map {
            when (it.toLowerCase()) {
                in 'a'..'d' -> 'z'
                in 'e'..'h' -> 'y'
                in 'i'..'l' -> 'x'
                in 'm'..'p' -> 'w'
                in 'q'..'t' -> 'v'
                in 'u'..'z' -> 'u'
                else -> '-'
            }
        }

        return Martian(name.capitalize(), String(martianName.toCharArray()).capitalize())
    }
}