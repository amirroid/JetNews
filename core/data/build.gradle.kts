import buildSrc.ProjectPaths

plugins {
    alias(libs.plugins.local.android.library)
    alias(libs.plugins.local.kotlin)
}

kotlin.sourceSets {
    commonMain {
        dependencies {
            implementation(libs.ktor.client.core)
            implementation(libs.paging.runtime)
            implementation(libs.room.runtime)

            implementation(project(ProjectPaths.domain))
        }
    }
}