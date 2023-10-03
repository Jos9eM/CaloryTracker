package com.calorieTracker.core.data.preferences

import android.content.SharedPreferences
import com.calorieTracker.core.domain.models.ActivityLevel
import com.calorieTracker.core.domain.models.Gender
import com.calorieTracker.core.domain.models.GoalType
import com.calorieTracker.core.domain.models.UserInfo
import com.calorieTracker.core.domain.preferences.Preferences
import com.calorieTracker.core.util.Constants

class DefaultPreferences(private val sharedPref: SharedPreferences) : Preferences {

    override fun saveGender(gender: Gender) {
        sharedPref.edit().putString(Constants.KEY_GENDER, gender.name).apply()
    }

    override fun saveAge(age: Int) {
        sharedPref.edit().putInt(Constants.KEY_AGE, age).apply()
    }

    override fun saveWeight(weight: Float) {
        sharedPref.edit().putFloat(Constants.KEY_WEIGHT, weight).apply()
    }

    override fun saveHeight(height: Float) {
        sharedPref.edit().putFloat(Constants.KEY_HEIGHT, height).apply()
    }

    override fun saveActivityLevel(level: ActivityLevel) {
        sharedPref.edit().putString(Constants.KEY_ACTIVITY_LEVEL, level.name).apply()
    }

    override fun saveGoalType(type: GoalType) {
        sharedPref.edit().putString(Constants.KEY_GOAL_TYPE, type.name).apply()
    }

    override fun saveCarbRatio(ratio: Float) {
        sharedPref.edit().putFloat(Constants.KEY_CARB_RATIO, ratio).apply()
    }

    override fun saveProteinRatio(ratio: Float) {
        sharedPref.edit().putFloat(Constants.KEY_PROTEIN_RATIO, ratio).apply()
    }

    override fun saveFatRatio(ratio: Float) {
        sharedPref.edit().putFloat(Constants.KEY_FAT_RATIO, ratio).apply()
    }

    override fun loadUserInfo(): UserInfo {
        val gender = sharedPref.getString(Constants.KEY_GENDER, null)
        val age = sharedPref.getInt(Constants.KEY_AGE, -1)
        val weight = sharedPref.getFloat(Constants.KEY_WEIGHT, -1f)
        val height = sharedPref.getFloat(Constants.KEY_HEIGHT, -1f)
        val activityLevel = sharedPref.getString(Constants.KEY_ACTIVITY_LEVEL, null)
        val goalType = sharedPref.getString(Constants.KEY_GOAL_TYPE, null)
        val carbRatio = sharedPref.getFloat(Constants.KEY_CARB_RATIO, -1f)
        val proteinRatio = sharedPref.getFloat(Constants.KEY_PROTEIN_RATIO, -1f)
        val fatRatio = sharedPref.getFloat(Constants.KEY_FAT_RATIO, -1f)
        return UserInfo(
            gender = Gender.fromString(gender ?: Constants.Female),
            age = age,
            weight = weight,
            height = height,
            activityLevel = ActivityLevel.fromString(activityLevel ?: Constants.Medium_Exercise),
            goalType = GoalType.fromString(goalType ?: Constants.Keep_Weight),
            carbRatio = carbRatio,
            proteinRatio = proteinRatio,
            fatRatio = fatRatio
        )
    }

    override fun saveShouldShowOnboarding(shouldShow: Boolean) {
        sharedPref.edit().putBoolean(Constants.KEY_SHOULD_SHOW_ONBOARDING, shouldShow).apply()
    }

    override fun loadShouldShowOnboarding(): Boolean {
        return sharedPref.getBoolean(Constants.KEY_SHOULD_SHOW_ONBOARDING, true)
    }
}