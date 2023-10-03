package com.plcoding.calorytracker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.calorieTracker.core.navigation.Route
import com.example.tracker_presentation.tracker_overview.TrackerOverviewScreen
import com.onboarding.onboarding_presentation.activity_level.ActivityLevelScreen
import com.onboarding.onboarding_presentation.age.AgeScreen
import com.onboarding.onboarding_presentation.fat_goal.FatGoalScreen
import com.onboarding.onboarding_presentation.gender.GenderScreen
import com.onboarding.onboarding_presentation.height.HeightScreen
import com.onboarding.onboarding_presentation.nutrient_goal.NutrientGoalScreen
import com.onboarding.onboarding_presentation.weight.WeightScreen
import com.onboarding.onboarding_presentation.welcome.WelcomeScreen
import com.plcoding.calorytracker.navigation.navigate
import com.plcoding.calorytracker.ui.theme.CaloryTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloryTrackerTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState
                ) {
                    NavHost(
                        navController = navController, startDestination = Route.Welcome_Route
                    ) {
                        composable(Route.Welcome_Route) {
                            WelcomeScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.Age_Route) {
                            AgeScreen(
                                onNavigate = navController::navigate, scaffoldState = scaffoldState
                            )
                        }
                        composable(Route.Gender_Route) {
                            GenderScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.Height_Route) {
                            HeightScreen(
                                onNavigate = navController::navigate, scaffoldState = scaffoldState
                            )
                        }
                        composable(Route.Weight_Route) {
                            WeightScreen(
                                onNavigate = navController::navigate, scaffoldState = scaffoldState
                            )
                        }
                        composable(Route.Nutrient_Goal_Route) {
                            NutrientGoalScreen(
                                onNavigate = navController::navigate, scaffoldState = scaffoldState
                            )
                        }
                        composable(Route.Activity_Route) {
                            ActivityLevelScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.Goal_Route) {
                            FatGoalScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.Tracker_Overview_Route) {
                            TrackerOverviewScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.Search_Route) {

                        }
                    }
                }
            }
        }
    }
}