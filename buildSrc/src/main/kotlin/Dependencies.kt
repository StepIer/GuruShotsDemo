object Dependencies {

    object Compose {
        private const val version = "1.5.3"
        const val compilerVersion = version

        const val activity = "androidx.activity:activity-compose:1.8.0"
        const val ui = "androidx.compose.ui:ui:$version"
        const val graphics = "androidx.compose.ui:ui-graphics:$version"
        const val preview = "androidx.compose.ui:ui-tooling-preview:$version"
        const val material3 = "androidx.compose.material3:material3:1.1.2"
        const val navigation = "androidx.navigation:navigation-compose:2.7.4"

        const val debugUiTooling = "androidx.compose.ui:ui-tooling:$version"
        const val debugUiTestManifest = "androidx.compose.ui:ui-test-manifest:$version"
    }

    object Hilt {
        private const val version = "2.48.1"

        const val android = "com.google.dagger:hilt-android:$version"
        const val androidCompiler = "com.google.dagger:hilt-android-compiler:$version"
        const val test = "com.google.dagger:hilt-android-testing:$version"
        const val compiler = "androidx.hilt:hilt-compiler:1.0.0"
        const val composeNavigation = "androidx.hilt:hilt-navigation-compose:1.0.0"
    }

    object Android {
        const val coreKtx = "androidx.core:core-ktx:1.12.0"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:2.6.2"
        const val material = "com.google.android.material:material:1.10.0"
    }

    object Test {
        const val junit = "junit:junit:4.13.2"
        const val mockito = "org.mockito:mockito-core:5.6.0"
        const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1"
    }

    object AndroidTest {
        const val ext = "androidx.test.ext:junit:1.1.5"
        const val espresso = "androidx.test.espresso:espresso-core:3.5.1"
        const val ui = "androidx.compose.ui:ui-test-junit4:1.5.3"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val serialization = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
        const val okhttp3 = "com.squareup.okhttp3:okhttp:4.9.3"
    }

    const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2"
}