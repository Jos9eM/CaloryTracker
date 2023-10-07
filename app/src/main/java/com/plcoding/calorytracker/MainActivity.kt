package com.plcoding.calorytracker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.calorieTracker.core.domain.preferences.Preferences
import com.plcoding.calorytracker.navigation.Route
import com.example.tracker_presentation.search.SearchScreen
import com.example.tracker_presentation.tracker_overview.TrackerOverviewScreen
import com.onboarding.onboarding_presentation.activity_level.ActivityLevelScreen
import com.onboarding.onboarding_presentation.age.AgeScreen
import com.onboarding.onboarding_presentation.fat_goal.FatGoalScreen
import com.onboarding.onboarding_presentation.gender.GenderScreen
import com.onboarding.onboarding_presentation.height.HeightScreen
import com.onboarding.onboarding_presentation.nutrient_goal.NutrientGoalScreen
import com.onboarding.onboarding_presentation.weight.WeightScreen
import com.onboarding.onboarding_presentation.welcome.WelcomeScreen
import com.plcoding.calorytracker.ui.theme.CaloryTrackerTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: Preferences

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val shouldShowOnboarding = preferences.loadShouldShowOnboarding()
        setContent {
            CaloryTrackerTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = if (shouldShowOnboarding) {
                            Route.Welcome_Route
                        } else Route.Tracker_Overview_Route
                    ) {
                        composable(Route.Welcome_Route) {
                            WelcomeScreen(onNextClick = { navController.navigate(Route.Gender_Route) })
                        }
                        composable(Route.Age_Route) {
                            AgeScreen(
                                onNextClick = { navController.navigate(Route.Height_Route) },
                                scaffoldState = scaffoldState
                            )
                        }
                        composable(Route.Gender_Route) {
                            GenderScreen(onNextClick = { navController.navigate(Route.Age_Route) })
                        }
                        composable(Route.Height_Route) {
                            HeightScreen(
                                onNextClick = { navController.navigate(Route.Weight_Route) },
                                scaffoldState = scaffoldState
                            )
                        }
                        composable(Route.Weight_Route) {
                            WeightScreen(
                                onNextClick = { navController.navigate(Route.Activity_Route) },
                                scaffoldState = scaffoldState
                            )
                        }
                        composable(Route.Nutrient_Goal_Route) {
                            NutrientGoalScreen(
                                onNextClick = { navController.navigate(Route.Tracker_Overview_Route) },
                                scaffoldState = scaffoldState
                            )
                        }
                        composable(Route.Activity_Route) {
                            ActivityLevelScreen(onNextClick = { navController.navigate(Route.Goal_Route) })
                        }
                        composable(Route.Goal_Route) {
                            FatGoalScreen(onNextClick = { navController.navigate(Route.Nutrient_Goal_Route) })
                        }
                        composable(Route.Tracker_Overview_Route) {
                            TrackerOverviewScreen(onNavigateToSearch = { mealName, day, month, year ->
                                navController.navigate(
                                    Route.Search_Route + "/$mealName" + "/$day" + "/$month" + "/$year"
                                )
                            })
                        }
                        composable(
                            Route.Search_Route + "/{mealName}/{dayOfMonth}/{month}/{year}",
                            arguments = listOf(navArgument("mealName") {
                                type = NavType.StringType
                            }, navArgument("dayOfMonth") {
                                type = NavType.IntType
                            }, navArgument("month") {
                                type = NavType.IntType
                            }, navArgument("year") {
                                type = NavType.IntType
                            })
                        ) {
                            val mealName = it.arguments?.getString("mealName")!!
                            val dayOfMonth = it.arguments?.getInt("dayOfMonth")!!
                            val month = it.arguments?.getInt("month")!!
                            val year = it.arguments?.getInt("year")!!
                            SearchScreen(scaffoldState = scaffoldState,
                                mealName = mealName,
                                dayOfMonth = dayOfMonth,
                                month = month,
                                year = year,
                                onNavigateUp = { navController.navigateUp() })
                        }
                    }
                }
            }
        }
    }
}