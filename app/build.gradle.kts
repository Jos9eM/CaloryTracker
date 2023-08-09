import Dependencies.initAndroidTestImplementations
import Dependencies.initAndroidXDependencies
import Dependencies.initCoilDependencies
import Dependencies.initComposeDependencies
import Dependencies.initGoogleDependencies
import Dependencies.initHiltDependencies
import Dependencies.initRetrofitDependencies
import Dependencies.initRoomDependencies
import Dependencies.initTestImplementations

plugins {
    id("com.android.application")
    kotlin("android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.plcoding.calorytracker"
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = ProjectConfig.appId
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    packaging {
        val excludes = listOf(
            "META-INF/AL2.0",
            "META-INF/LGPL2.1",
            "**/attach_hotspot_windows.dll",
            "META-INF/licenses/ASM"
        )
        resources.excludes.addAll(excludes)
    }
}

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.core_ui))
    implementation(project(Modules.onboardingPresentation))
    implementation(project(Modules.onboardingDomain))
    implementation(project(Modules.trackerPresentation))
    implementation(project(Modules.trackerDomain))
    implementation(project(Modules.trackerData))

    initComposeDependencies()
    initHiltDependencies()
    initAndroidXDependencies()
    initCoilDependencies()
    initGoogleDependencies()
    initRetrofitDependencies()
    initRoomDependencies()
    initTestImplementations()
    initAndroidTestImplementations()
}