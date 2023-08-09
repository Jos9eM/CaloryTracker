import AndroidDependencies.initBaseAppDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.tracker.tracker_domain"
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        minSdk = ProjectConfig.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        //consumerProguardFiles = "consumer-rules.pro"
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
    implementation(project(Modules.core))

    initBaseAppDependencies()
}