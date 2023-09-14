package com.example.affirmations.model

sealed class Data(val imageResourceId: String) {

    data class FirstType(
        val string: String,
        val image: String
    ) : Data(image)

    data class SecondType(
        val image: String
    ) : Data(image)
}

enum class A {
    one,
    two,
    three
}