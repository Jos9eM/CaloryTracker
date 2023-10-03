package com.calorieTracker.core.domain.preferences

import com.calorieTracker.core.domain.models.ActivityLevel
import com.calorieTracker.core.domain.models.Gender
import com.calorieTracker.core.domain.models.GoalType
import com.calorieTracker.core.domain.models.UserInfo

interface Preferences {
    fun saveGender(gender: Gender)
    fun saveAge(age: Int)
    fun saveWeight(weight: Float)
    fun saveHeight(height: Float)
    fun saveActivityLevel(level: ActivityLevel)
    fun saveGoalType(type: GoalType)
    fun saveCarbRatio(ratio: Float)
    fun saveProteinRatio(ratio: Float)
    fun saveFatRatio(ratio: Float)

    fun loadUserInfo(): UserInfo

    fun saveShouldShowOnboarding(shouldShow: Boolean)

    fun loadShouldShowOnboarding(): Boolean

    companion object{
    }
}