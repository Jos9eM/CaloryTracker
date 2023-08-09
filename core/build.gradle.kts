import Dependencies.initBaseAppDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.calorieTracker.core"
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        minSdk = ProjectConfig.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        //consumerProguardFiles "consumer-rules.pro"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = ProjectConfig.javaVersionCode
        targetCompatibility = ProjectConfig.javaVersionCode
    }
    kotlinOptions {
        jvmTarget = ProjectConfig.javaVersionNumber
    }
}

dependencies {
    initBaseAppDependencies()
}