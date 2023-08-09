package com.calorieTracker.core.domain.models

import com.calorieTracker.core.util.Constants

sealed class Gender(val name: String) {
    object Male : Gender(Constants.Male)
    object Female : Gender(Constants.Female)

    companion object {
        fun fromString(name: String): Gender {
            return when (name) {
                Constants.Male -> Male
                else -> Female
            }
        }
    }
}
