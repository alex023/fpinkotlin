package com.fpinkotlin.introduction.listing01_02

class CreditCard {

    // total has a public getter (by default) and a private setter
    var total: Int = 0
        private set

    fun charge(price: Int) {
        this.total += price
    }
}
