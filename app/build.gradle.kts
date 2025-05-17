plugins {
    // Order matters: android before multiplatform
    alias(libs.plugins.local.kotlin.android)
    alias(libs.plugins.local.kotlin.multiplatform)
    alias(libs.plugins.local.build.config)
}