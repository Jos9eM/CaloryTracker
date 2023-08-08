import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {

    fun DependencyHandler.initComposeDependencies(){
        implementation(Compose.compiler)
        implementation(Compose.ui)
        implementation(Compose.uiToolingPreview)
        implementation(Compose.hiltNavigationCompose)
        implementation(Compose.material)
        implementation(Compose.runtime)
        implementation(Compose.navigation)
        implementation(Compose.viewModelCompose)
        implementation(Compose.activityCompose)
    }

    fun DependencyHandler.initAndroidXDependencies(){
        implementation(AndroidX.coreKtx)
        implementation(AndroidX.appCompat)
    }

    fun DependencyHandler.initHiltDependencies(){
        kapt(DaggerHilt.hiltCompiler)
        implementation(DaggerHilt.hiltAndroid)
    }

    fun DependencyHandler.initRoomDependencies(){
        kapt(Room.roomCompiler)
        implementation(Room.roomKtx)
        implementation(Room.roomRuntime)
    }

    fun DependencyHandler.initRetrofitDependencies(){
        implementation(Retrofit.okHttp)
        implementation(Retrofit.retrofit)
        implementation(Retrofit.okHttpLoggingInterceptor)
        implementation(Retrofit.moshiConverter)
    }

    fun DependencyHandler.initCoilDependencies(){
        implementation(Coil.coilCompose)
    }

    fun DependencyHandler.initGoogleDependencies(){
        implementation(Google.material)
    }

    fun DependencyHandler.initTestImplementations(){
        testImplementation(Testing.junit4)
        testImplementation(Testing.junitAndroidExt)
        testImplementation(Testing.truth)
        testImplementation(Testing.coroutines)
        testImplementation(Testing.turbine)
        testImplementation(Testing.composeUiTest)
        testImplementation(Testing.mockk)
        testImplementation(Testing.mockWebServer)
    }

    fun DependencyHandler.initAndroidTestImplementations(){
        androidTestImplementation(Testing.junit4)
        androidTestImplementation(Testing.junitAndroidExt)
        androidTestImplementation(Testing.truth)
        androidTestImplementation(Testing.coroutines)
        androidTestImplementation(Testing.turbine)
        androidTestImplementation(Testing.composeUiTest)
        androidTestImplementation(Testing.mockkAndroid)
        androidTestImplementation(Testing.mockWebServer)
        androidTestImplementation(Testing.hiltTesting)
        kaptAndroidTest(DaggerHilt.hiltCompiler)
        androidTestImplementation(Testing.testRunner)
    }

    fun DependencyHandler.`implementation`(dependencyNotation: Any): Dependency? =
        add("implementation", dependencyNotation)

    fun DependencyHandler.`kapt`(dependencyNotation: Any): Dependency? =
        add("kapt", dependencyNotation)

    fun DependencyHandler.`testImplementation`(dependencyNotation: Any): Dependency? =
        add("testImplementation", dependencyNotation)

    fun DependencyHandler.`androidTestImplementation`(dependencyNotation: Any): Dependency? =
        add("androidTestImplementation", dependencyNotation)

    fun DependencyHandler.`kaptAndroidTest`(dependencyNotation: Any): Dependency? =
        add("kaptAndroidTest", dependencyNotation)
}