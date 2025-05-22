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
                implementation(project(ProjectPaths.image))

                // Features
                implementation(project(ProjectPaths.home))
                implementation(project(ProjectPaths.article))
            }
        }
    }
}