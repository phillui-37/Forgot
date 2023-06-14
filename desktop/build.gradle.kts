import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "com.fgostudio"
version = "1.0-SNAPSHOT"


kotlin {
    jvm {
        jvmToolchain(17)
        withJava()
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(project(":common"))
                implementation(compose.desktop.currentOs)
            }
        }
        val jvmTest by getting
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            linux {
                targetFormats(TargetFormat.Deb)
            }
            windows {
                targetFormats(TargetFormat.Msi)
            }
            macOS {
                targetFormats(TargetFormat.Dmg)
            }
            packageName = "Forgot"
            packageVersion = "1.0.0"
        }
    }
}
