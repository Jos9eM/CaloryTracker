package com.plcoding.calorytracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.calorieTracker.core.navigation.Route
import com.onboarding.onboarding_presentation.welcome.WelcomeScreen
import com.plcoding.calorytracker.navigation.navigate
import com.plcoding.calorytracker.ui.theme.CaloryTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloryTrackerTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Route.Welcome_Route) {
                    composable(Route.Welcome_Route) {
                        WelcomeScreen(onNavigate = navController::navigate)
                    }
                    composable(Route.Age_Route) {

                    }
                    composable(Route.Gender_Route) {

                    }
                    composable(Route.Height_Route) {

                    }
                    composable(Route.Weight_Route) {

                    }
                    composable(Route.Nutrient_Goal_Route) {

                    }
                    composable(Route.Activity_Route) {

                    }
                    composable(Route.Goal_Route) {

                    }
                    composable(Route.Tracker_Overview_Route) {

                    }
                    composable(Route.Search_Route) {

                    }
                }
            }
        }
    }
}