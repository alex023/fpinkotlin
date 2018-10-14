package com.fpinkotlin.workingwithlaziness.exercise25

import com.fpinkotlin.common.range
import com.fpinkotlin.generators.IntGenerator
import com.fpinkotlin.generators.forAll
import io.kotlintest.specs.StringSpec
import java.util.*

class LazyTest: StringSpec() {

    private val random = Random()

    init {

        "append" {
            forAll(IntGenerator(0, 100), { a ->
                fun inc(i: Int): Int = i + 1
                val limit = random.nextInt(500)
                val stream = Stream
                        .iterate(Lazy{ inc(0) }, ::inc)
                        .takeAtMost(a)
                        .append(Lazy { Stream.iterate(Lazy{ inc(a) }, ::inc) })
                        .filter { it % 2 != 0 }
                        .takeWhileViaFoldRight { it < limit * 2 }
                val result = stream.toList()
                val list = range(0, limit * 2).filter { it % 2 != 0 }
                result.toString() == list.toString()
            }, 10)
        }
    }

}
