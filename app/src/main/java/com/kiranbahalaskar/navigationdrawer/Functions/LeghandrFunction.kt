package com.example.tchmk_2.Functions

fun Leghandr(a: Int, m: Int) : Int {
    var aCopy = a
    var mCopy = m
    var ans: Int = 0
    if(aCopy == 1) ans = 1
    if(aCopy % 2 == 0 && aCopy != 0){
        ans = Leghandr(aCopy/2, mCopy) * Math.pow((-1.0), ((Math.pow(mCopy.toDouble(), 2.0)-1)/8)).toInt()
    }
    if (aCopy % 2 == 1 && aCopy != 1){
        ans = Leghandr(mCopy % aCopy, aCopy) * Math.pow((-1.0), ((aCopy.toDouble() - 1.0)*(mCopy - 1)/4)).toInt()
    }
    return ans
}