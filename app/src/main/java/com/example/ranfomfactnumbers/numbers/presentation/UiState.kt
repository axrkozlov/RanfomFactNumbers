package com.example.ranfomfactnumbers.numbers.presentation

sealed class UiState {

    interface Mapper<T> {
        fun map(list: List<NumberUi>, message: String): T
    }

    abstract fun <T> map(mapper: Mapper<T>): T

    class Success(private val list: List<NumberUi> = emptyList()) : UiState() {

        override fun <T> map(mapper: Mapper<T>): T {
            return mapper.map(list, "")
        }

    }

    class Error(private val message: String) : UiState() {

        override fun <T> map(mapper: Mapper<T>): T {
            return mapper.map(emptyList(), message)
        }

    }

}