package com.mydomain.mymultipleproject.common.example05

import io.kotlintest.properties.Gen
import java.util.*


class StringGenerator(private val maxList: Int,
                      private val maxString: Int) : Gen<List<Pair<String, Map<Char, Int>>>> {

    override fun constants(): Iterable<List<Pair<String, Map<Char, Int>>>> = listOf(listOf(Pair("", mapOf())))

    override fun random(): Sequence<List<Pair<String, Map<Char, Int>>>> =
        Random().let { random ->
            generateSequence {
                (0 until random.nextInt(maxList)).map {
                    (0 until random.nextInt(maxString)).fold(Pair("", mapOf<Char, Int>())) { pair, _ ->
                        (random.nextInt(122 - 96) + 96).toChar().let { char ->
                            Pair("${pair.first}$char", updateMap(pair.second, char))
                        }
                    }
                }
            }
        }
}
