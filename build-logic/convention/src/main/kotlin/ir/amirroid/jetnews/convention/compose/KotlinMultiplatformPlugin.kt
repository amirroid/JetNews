package ir.amirroid.jetnews.convention.compose

import com.android.build.api.dsl.ApplicationExtension
import ir.amirroid.jetnews.convention.android.configureAndroidPlugins
import ir.amirroid.jetnews.convention.core.libs
import ir.amirroid.jetnews.convention.findPluginId
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KotlinMultiplatformPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.applyRequiredPlugins()
        target.configureExtensions()
    }

    private fun Project.applyRequiredPlugins() {
        pluginManager.apply {
            apply(libs.findPluginId("kotlinMultiplatform"))
            apply(libs.findPluginId("composeMultiplatform"))
            apply(libs.findPluginId("composeCompiler"))
        }
    }

    private fun Project.configureExtensions() {
        extensions.configure<KotlinMultiplatformExtension>(::configureKotlinMultiplatformPlugins)
    }
}