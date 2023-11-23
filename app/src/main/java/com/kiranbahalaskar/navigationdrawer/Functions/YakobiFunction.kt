package com.example.tchmk_2.Functions

fun Yakobi (a: Int, n: Int) : Int {
    var aCopy = a
    var nCopy = n
    if (nCopy <= 0 || nCopy % 2 == 0) return 0
    var ans: Int = 1
    if(aCopy < 0) {
        aCopy = - aCopy
        if(nCopy % 4 == 3) ans = -ans
    }
    if (aCopy == 1) return ans
    while (aCopy != 0){
        if(aCopy < 0){
            aCopy = -aCopy
            if(n % 4 == 3) ans = -ans
        }
        while (aCopy % 2 == 0){
            aCopy /= 2
            if(nCopy % 8 == 3 || nCopy % 8 == 5) ans = -ans
        }
        var temp: Int = aCopy
        aCopy = nCopy
        nCopy = temp
        if (aCopy % 4 == 3 && nCopy % 4 == 3) ans = -ans
        aCopy %= nCopy
        if(aCopy > nCopy/2) aCopy = aCopy - nCopy
    }
    if (nCopy == 1) return ans
    return 0
}