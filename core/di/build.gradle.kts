import buildSrc.ProjectPaths

plugins {
    alias(libs.plugins.local.android.library)
    alias(libs.plugins.local.kotlin)
    alias(libs.plugins.local.koin)
}

kotlin.sourceSets.commonMain {
    dependencies {
        implementation(libs.ktor.client.core)

        implementation(project(ProjectPaths.network))
        implementation(project(ProjectPaths.data))
        implementation(project(ProjectPaths.domain))
        implementation(project(ProjectPaths.image))

        // Features
        implementation(project(ProjectPaths.home))
    }
}