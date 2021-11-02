package com.github.posko.core.helpers.exceptions

/**
 * Created by edwin on 10/03/2018.
 */
class PoskoServiceFailureException(
    message : String,
    throwable: Throwable
) : PoskoException(message)