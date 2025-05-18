package ir.amirroid.jetnews.convention.android.application

import com.android.build.api.dsl.ApplicationExtension
import ir.amirroid.jetnews.convention.core.libs
import ir.amirroid.jetnews.convention.findPluginId
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.applyRequiredPlugins()
        target.configureExtensions()
    }

    private fun Project.applyRequiredPlugins() {
        pluginManager.apply(libs.findPluginId("androidApplication"))
    }

    private fun Project.configureExtensions() {
        extensions.configure<ApplicationExtension>(::configureAndroidApplicationPlugins)
    }
}