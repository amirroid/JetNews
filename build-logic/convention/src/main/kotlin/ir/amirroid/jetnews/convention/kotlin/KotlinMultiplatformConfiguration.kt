package ir.amirroid.jetnews.convention.kotlin

import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun configureKotlinMultiplatformPlugins(
    extensions: KotlinMultiplatformExtension
) {
    extensions.apply {
        applyDefaultHierarchyTemplate()
        androidTarget()
        configureIosTargets()
    }
}

private fun KotlinMultiplatformExtension.configureIosTargets() {
    listOf(iosX64(), iosArm64(), iosSimulatorArm64()).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
}