// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("org.jetbrains.kotlin.android") version PluginVersion.kotlinVersion apply false
    id("com.android.application") version PluginVersion.agpVersion apply false
    id("com.android.library") version PluginVersion.agpVersion apply false
    kotlin("kapt") version PluginVersion.kotlinVersion apply false
    id("com.google.dagger.hilt.android") version PluginVersion.kaptVersion apply false
    kotlin("plugin.serialization") version PluginVersion.serialization apply false
}