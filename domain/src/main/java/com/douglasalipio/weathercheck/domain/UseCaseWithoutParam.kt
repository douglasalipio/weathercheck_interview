package com.douglasalipio.weathercheck.domain

interface UseCaseWithoutParam<out T> {

    suspend fun execute(): T
}