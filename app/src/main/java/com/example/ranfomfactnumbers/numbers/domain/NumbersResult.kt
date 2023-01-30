package com.example.ranfomfactnumbers.numbers.domain

sealed class NumbersResult {

    interface Mapper<T> {

        fun map(list: List<NumberFact>): T

        fun map(errorMessage: String): T

    }

    abstract fun <T> map(mapper: Mapper<T>): T

    data class Success(private val list: List<NumberFact> = emptyList()) : NumbersResult() {

        override fun <T> map(mapper: Mapper<T>) = mapper.map(list)

    }

    data class Failure(private val message: String) : NumbersResult() {

        override fun <T> map(mapper: Mapper<T>) = mapper.map(message)

    }

}