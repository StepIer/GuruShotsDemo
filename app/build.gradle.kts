@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    kotlin("plugin.serialization")
    id("androidx.navigation.safeargs")
}

android {
    namespace = AppSetup.applicationId
    compileSdk = AppSetup.compileSdk

    defaultConfig {
        applicationId = AppSetup.applicationId
        minSdk = AppSetup.minSdk
        targetSdk = AppSetup.targetSdk
        versionCode = AppSetup.versionCode
        versionName = AppSetup.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Android.lifecycleRuntime)
    implementation(Dependencies.Android.material)
    implementation(Dependencies.Android.navigationFragment)
    implementation(Dependencies.Android.navigationUi)
    implementation(Dependencies.Android.legacySupport)
    implementation(Dependencies.Android.lifecycleViewModel)

    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.graphics)
    implementation(Dependencies.Compose.preview)
    implementation(Dependencies.Compose.material3)
    implementation(Dependencies.Compose.navigation)

    implementation(Dependencies.Hilt.android)

    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.serialization)
    implementation(Dependencies.Retrofit.okhttp3)

    implementation(Dependencies.Glide.core)
    implementation(Dependencies.Glide.compose)
    annotationProcessor(Dependencies.Glide.compiler)

    implementation(Dependencies.serialization)
    implementation(Dependencies.swipeRefresh)

    kapt(Dependencies.Hilt.compiler)
    kapt(Dependencies.Hilt.androidCompiler)

    debugImplementation(Dependencies.Compose.debugUiTooling)
    debugImplementation(Dependencies.Compose.debugUiTestManifest)
}