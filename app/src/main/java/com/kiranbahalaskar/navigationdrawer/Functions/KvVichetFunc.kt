package com.example.tchmk_2.Functions

import java.util.*

fun vichetKv(p: Int): Array<Int> {
    var p1 = p
    var vich: Array<Int> = Array((p1-1)/2, {0})
    var j: Int = 0
    for (i in 1..(p1-1)){
        var a: Int = (i*i) % p1
        if ((Evk(a, p1) == 1) && (prov(vich, a))){
            vich[j] = a
            if(j + 1 < ((p1-1)/2)) j++
        }
    }
    Arrays.sort(vich)
    return vich
}



fun prov(mas: Array<Int>, a: Int) : Boolean {
    var buf: Boolean = false
    var a1 = a
    for (i in 0..(mas.size -1) ){
        if (mas[i] == a1){
            buf = false
            break
        } else buf = true
    }
    return buf
}




fun Evk(a: Int, b: Int): Int {
    var a1 = a
    var b1 = b
    while (b1 != 0){
        var tmp: Int = a1%b1
        a1 = b1
        b1 = tmp
    }
    return a1
}


