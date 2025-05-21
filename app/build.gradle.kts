import buildSrc.ProjectPaths

plugins {
    // Order matters: android before multiplatform
    alias(libs.plugins.local.android.application)
    alias(libs.plugins.local.compose.multiplatform)
    alias(libs.plugins.local.koin)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(ProjectPaths.di))

                // Features
                implementation(project(ProjectPaths.home))
            }
        }
    }
}