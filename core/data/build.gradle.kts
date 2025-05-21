import buildSrc.ProjectPaths

plugins {
    alias(libs.plugins.local.android.library)
    alias(libs.plugins.local.kotlin)
}

kotlin.sourceSets {
    commonMain {
        dependencies {
            implementation(libs.ktor.client.core)

            implementation(project(ProjectPaths.domain))
        }
    }
}