package com.calorieTracker.core.domain.models

import com.calorieTracker.core.util.Constants

sealed class ActivityLevel(val name: String) {
    object Low : ActivityLevel(Constants.Low_Exercise)
    object Medium : ActivityLevel(Constants.Medium_Exercise)
    object High : ActivityLevel(Constants.High_Exercise)

    companion object {
        fun fromString(name: String): ActivityLevel {
            return when (name) {
                Constants.Lose_Weight -> Low
                Constants.Keep_Weight -> Medium
                else -> High
            }
        }
    }
}
