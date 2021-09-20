package com.douglasalipio.weathercheck.domain

interface UseCaseWithParam<out T, in P> {

    suspend fun execute(param: P): T
}