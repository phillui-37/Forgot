
plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
}

group = "com.fgostudio"
version = "1.0-SNAPSHOT"
object Versions {
    val arrow = "1.2.0-RC"
    val coroutine = "1.7.1"
    object AndroidXKTX {
        val lifecycle = "2.6.1"
    }
}

kotlin {
    android()
    jvm("desktop") {
        jvmToolchain(17)
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)

                implementation(platform("io.arrow-kt:arrow-stack:${Versions.arrow}"))
                implementation("io.arrow-kt:arrow-core")
                implementation("io.arrow-kt:arrow-fx-coroutines")

                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                api("androidx.appcompat:appcompat:1.6.1")
                api("androidx.core:core-ktx:1.10.1")

                implementation("androidx.activity:activity-ktx:1.7.2")
                implementation("androidx.collection:collection-ktx:1.2.0")
                implementation("androidx.lifecycle:lifecycle-livedata-core-ktx:${Versions.AndroidXKTX.lifecycle}")
                implementation("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.AndroidXKTX.lifecycle}")
                implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.AndroidXKTX.lifecycle}")
                implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Versions.AndroidXKTX.lifecycle}")
                implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidXKTX.lifecycle}")

                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}")
            }
        }
        val androidUnitTest by getting {
            dependencies {
                implementation("junit:junit:4.13.2")
            }
        }
        val desktopMain by getting {
            dependencies {
                api(compose.preview)
            }
        }
        val desktopTest by getting
    }
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    packagingOptions {
        resources.excludes += "DebugProbesKt.bin"
    }
}
