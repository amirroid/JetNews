import buildSrc.ProjectPaths

plugins {
    // Order matters: android before multiplatform
    alias(libs.plugins.local.android.application)
    alias(libs.plugins.local.compose.multiplatform)
    alias(libs.plugins.local.koin)
}