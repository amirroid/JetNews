package ir.amirroid.jetnews.convention.compose

import ir.amirroid.jetnews.convention.core.composeDependencies
import ir.amirroid.jetnews.convention.core.libs
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

fun Project.configureKotlinMultiplatformPlugins(
    extensions: KotlinMultiplatformExtension
) {
    extensions.apply {
        androidTarget()
        configureIosTargets()
        applyDefaultHierarchyTemplate()

        configureCommonMain(sourceSets)
        configureAndroidMain(sourceSets)
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

private fun Project.configureCommonMain(sourceSets: NamedDomainObjectContainer<KotlinSourceSet>) {
    val commonMain = sourceSets.maybeCreate("commonMain")
    val dependencies = composeDependencies
    commonMain.dependencies {
        implementation(dependencies.runtime)
        implementation(dependencies.foundation)
        implementation(dependencies.material3)
        implementation(dependencies.ui)
        implementation(dependencies.components.resources)
        implementation(dependencies.components.uiToolingPreview)

        implementation(libs.findLibrary("androidx-lifecycle-viewmodel").get())
        implementation(libs.findLibrary("androidx-lifecycle-runtimeCompose").get())
    }
}

private fun Project.configureAndroidMain(sourceSets: NamedDomainObjectContainer<KotlinSourceSet>) {
    val androidMain = sourceSets.maybeCreate("androidMain")
    androidMain.dependencies {
        implementation(composeDependencies.preview)
        implementation(libs.findLibrary("androidx-activity.compose").get())
    }
}