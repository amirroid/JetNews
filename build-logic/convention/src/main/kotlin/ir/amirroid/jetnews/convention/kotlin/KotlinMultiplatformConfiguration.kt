package ir.amirroid.jetnews.convention.kotlin

import ir.amirroid.jetnews.convention.androidMain
import ir.amirroid.jetnews.convention.commonMain
import ir.amirroid.jetnews.convention.core.libs
import ir.amirroid.jetnews.convention.implementIfNotSelf
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

internal fun Project.configureKotlinMultiplatformPlugins(
    extensions: KotlinMultiplatformExtension
) {
    extensions.apply {
        applyDefaultHierarchyTemplate()
        androidTarget()
        configureIosTargets()
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
    sourceSets.commonMain.dependencies {
        implementation(libs.findLibrary("kotlinx-serialization").get())
        implementation(libs.findLibrary("kermit").get())

        val commonBase = ":core:common:base"
        val network = ":core:network"
        val date = ":core:date"

        implementIfNotSelf(date)
        if (project.path != date) {
            if (project.path != commonBase) {
                implementIfNotSelf(network)
            }
            implementIfNotSelf(commonBase)
        }
    }
}

private fun Project.configureAndroidMain(sourceSets: NamedDomainObjectContainer<KotlinSourceSet>) {
    sourceSets.androidMain.dependencies {
        implementation(libs.findLibrary("androidx-core-ktx").get())
    }
}