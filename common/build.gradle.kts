
plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
    id("com.google.devtools.ksp")
}

group = "com.fgostudio"
version = "1.0-SNAPSHOT"
object Versions {
    val arrow = "1.2.0-RC"
    val coroutine = "1.7.1"
    object AndroidXKTX {
        val lifecycle = "2.6.1"
    }

    val coil = "2.4.0"
    val room = "2.5.0"
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

                // fp support
                implementation(platform("io.arrow-kt:arrow-stack:${Versions.arrow}"))
                implementation("io.arrow-kt:arrow-core")
                implementation("io.arrow-kt:arrow-fx-coroutines")
                implementation("io.arrow-kt:arrow-optics")

                // coroutine
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            kotlin.srcDir("build/generated/ksp/android/androidDebug/kotlin")
            kotlin.srcDir("build/generated/ksp/android/androidRelease/kotlin")
            dependencies {
                api("androidx.appcompat:appcompat:1.6.1")
                api("androidx.core:core-ktx:1.10.1")

                // sqlite
                implementation("androidx.room:room-runtime:${Versions.room}")

                // android ktx
                implementation("androidx.activity:activity-ktx:1.7.2")
                implementation("androidx.collection:collection-ktx:1.2.0")
                implementation("androidx.lifecycle:lifecycle-livedata-core-ktx:${Versions.AndroidXKTX.lifecycle}")
                implementation("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.AndroidXKTX.lifecycle}")
                implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.AndroidXKTX.lifecycle}")
                implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Versions.AndroidXKTX.lifecycle}")
                implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidXKTX.lifecycle}")

                // coroutine
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}")

                // svg support
                implementation("io.coil-kt:coil-compose:${Versions.coil}")
                implementation("io.coil-kt:coil-svg:${Versions.coil}")
            }
        }
        val androidUnitTest by getting {
            dependencies {
                implementation("junit:junit:4.13.2")
            }
        }
        val desktopMain by getting {
            kotlin.srcDir("build/generated/ksp/desktop/desktopMain/kotlin")
            dependencies {
                api(compose.preview)

                // logging
                implementation("org.slf4j:slf4j-api:2.0.7")
                implementation("ch.qos.logback:logback-classic:1.4.8")
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

dependencies {
    arrayOf(
        "io.arrow-kt:arrow-optics-ksp-plugin:${Versions.arrow}"
    ).forEach {
        add("kspAndroid", it)
        add("kspCommonMainMetadata", it)
        add("kspDesktop", it)
    }
    add("kspAndroid","androidx.room:room-compiler:${Versions.room}")
}
