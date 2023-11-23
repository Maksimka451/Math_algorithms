package com.example.tchmk_2.Functions

import java.util.concurrent.atomic.AtomicInteger

data class ClEd(var x: Int, var y: Int)

fun CoolEuclid (a: Int, b: Int, x: AtomicInteger, y: AtomicInteger) : ClEd{
    var num1 = a
    var num2 = b
    var koef1 = x
    var koef2 = y
    if(num1 == 0) {
        koef1.set(0)
        koef2.set(1)
        return ClEd(0, 1)
    }
    var x1: AtomicInteger = AtomicInteger()
    var y1: AtomicInteger = AtomicInteger()
    var gcd = CoolEuclid(num2%num1, num1, x1, y1)
    koef1.set(y1.get() - (num2/num1)*x1.get())
    koef2.set(x1.get())
    return ClEd(koef1.get(), koef2.get())
}