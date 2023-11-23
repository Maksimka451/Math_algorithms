package com.example.tchmk_2.Functions

import java.util.Collections

fun vichetKb(p: Int) : ArrayList<Int> {
    var p1 = p
    var vich: ArrayList<Int> = ArrayList()
    for (i in 1..(p1-1)){
        var a: Int = (i*i*i) % p1
        if ((Evk(a, p1) ==1) && !(vich.contains(a))){
            vich.add(a)
        }
    }
    Collections.sort(vich)
    return vich
}