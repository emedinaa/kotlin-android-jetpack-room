package com.emedinaa.room.sample.mesage

/**
 * @author Eduardo Medina
 */
sealed class DataResult<out T> {
    data class Success<T>(val value: T) : DataResult<T>()
    data class Failure(val exception: Exception) : DataResult<Nothing>()
}

