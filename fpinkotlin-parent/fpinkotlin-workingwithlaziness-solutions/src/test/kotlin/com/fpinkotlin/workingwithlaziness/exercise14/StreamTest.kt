package com.fpinkotlin.workingwithlaziness.exercise14

import com.fpinkotlin.generators.IntGenerator
import com.fpinkotlin.generators.forAll
import io.kotlintest.specs.StringSpec
import java.util.*

class LazyTest: StringSpec() {

    private val random = Random()

    init {

        "dropAtMost&takeAtMost" {
            forAll(IntGenerator(0, 100_000), { a ->
                val offset = random.nextInt(500)
                val stream = Stream.from(a).dropAtMost(offset).takeAtMost(offset)
                stream.head().map { it == a + offset }.getOrElse(false)
            })
        }
    }
}
