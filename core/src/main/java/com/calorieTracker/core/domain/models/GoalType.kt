package com.calorieTracker.core.domain.models

import com.calorieTracker.core.util.Constants

sealed class GoalType(val name: String) {
    object LoseWeight : GoalType(Constants.Lose_Weight)
    object KeepWeight : GoalType(Constants.Keep_Weight)
    object GainWeight : GoalType(Constants.Gain_Weight)

    companion object {
        fun fromString(name: String): GoalType {
            return when (name) {
                Constants.Lose_Weight -> LoseWeight
                Constants.Keep_Weight -> KeepWeight
                else -> GainWeight
            }
        }
    }
}
