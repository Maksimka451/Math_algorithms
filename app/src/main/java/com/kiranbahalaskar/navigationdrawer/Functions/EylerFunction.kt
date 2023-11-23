package com.example.tchmk_2


fun Eyler(count: Int): Int {
    var n: Int = count
    var result: Int = n
    for (i in 2..n){
        if(i*i > n) break
        if(n % i == 0){
            while( n % i == 0) n /= i
            result -= result/i
        }
    }
    if(n > 1)
        result -= result/n
    return result
}