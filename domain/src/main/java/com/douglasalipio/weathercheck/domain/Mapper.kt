package com.douglasalipio.weathercheck.domain

interface Mapper<in FROM, out TO> {

    fun map(from: FROM): TO

    fun mapToList(from: FROM): List<TO>
}
