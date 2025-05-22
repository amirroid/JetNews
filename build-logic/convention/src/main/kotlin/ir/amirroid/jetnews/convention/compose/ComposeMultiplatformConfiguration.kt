package ir.amirroid.jetnews.convention.compose

import ir.amirroid.jetnews.convention.androidMain
import ir.amirroid.jetnews.convention.commonMain
import ir.amirroid.jetnews.convention.core.composeDependencies
import ir.amirroid.jetnews.convention.core.libs
import ir.amirroid.jetnews.convention.implementIfNotSelf
import org.gradle.api.GradleException
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

internal fun Project.configureComposeMultiplatformPlugins(
    extensions: KotlinMultiplatformExtension
) {
    extensions.apply {
        configureCommonMain(sourceSets)
        configureAndroidMain(sourceSets)
    }
}


private fun Project.configureCommonMain(sourceSets: NamedDomainObjectContainer<KotlinSourceSet>) {
    val commonMain = sourceSets.commonMain
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
        implementation(libs.findLibrary("compose-navigation").get())
        implementation(libs.findLibrary("coil-compose").get())

        val designSystemPath = ":core:design-system"
        val composeCommon = ":core:common:compose"
        val resources = ":core:resources"

        implementIfNotSelf(resources)
        if (project.path != resources) {
            implementIfNotSelf(designSystemPath)
            if (project.path != designSystemPath) {
                implementIfNotSelf(composeCommon)
            }
        }
    }
}

private fun Project.configureAndroidMain(sourceSets: NamedDomainObjectContainer<KotlinSourceSet>) {
    val androidMain = sourceSets.androidMain
    androidMain.dependencies {
        implementation(composeDependencies.preview)
        implementation(libs.findLibrary("androidx-activity.compose").get())
    }
}