import AndroidDependencies.initComposeBaseAppDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.onboarding.onboarding_presentation"
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
    @Suppress("UnstableApiUsage") buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = ProjectConfig.javaVersionCode
        targetCompatibility = ProjectConfig.javaVersionCode
    }
    kotlinOptions {
        jvmTarget = ProjectConfig.javaVersionNumber
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeCompilerVersion
    }
}

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.core_ui))
    implementation(project(Modules.onboardingDomain))

    initComposeBaseAppDependencies()
}