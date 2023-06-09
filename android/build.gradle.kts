plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    kotlin("android")
}

group = "com.fgostudio"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(project(":common"))
    implementation("androidx.activity:activity-compose:1.7.2")
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.fgostudio.android"
        minSdk = 24
        versionCode = 1
        versionName = "1.0-SNAPSHOT"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
        }
    }
    packagingOptions {
        resources.excludes += "DebugProbesKt.bin"
    }
}