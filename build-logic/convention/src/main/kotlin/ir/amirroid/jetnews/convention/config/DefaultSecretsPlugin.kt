package ir.amirroid.jetnews.convention.config

import com.codingfeline.buildkonfig.compiler.FieldSpec
import com.codingfeline.buildkonfig.gradle.BuildKonfigExtension
import ir.amirroid.jetnews.convention.core.libs
import ir.amirroid.jetnews.convention.findPluginId
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.util.Properties

class DefaultSecretsPlugin : Plugin<Project> {
    private lateinit var pluginId: String

    override fun apply(target: Project) {
        initializePluginId(target)
        applyBuildConfigPlugin(target)

        target.plugins.withId(pluginId) {
            configureBuildKonfig(target)
        }
    }

    private fun initializePluginId(project: Project) {
        pluginId = project.libs.findPluginId(BUILD_KONFIG_PLUGIN_CATALOG_ID)
    }

    private fun applyBuildConfigPlugin(project: Project) {
        project.plugins.apply(pluginId)
    }

    private fun configureBuildKonfig(project: Project) {
        val buildKonfig = project.buildKonfig
        buildKonfig.packageName = BUILD_KONFIG_PACKAGE_NAME
        buildKonfig.objectName = BUILD_KONFIG_OBJECT_NAME

        val secretsFile = project.rootProject.file(SECRETS_FILE)
        check(secretsFile.exists()) { "$SECRETS_FILE not found in root project." }

        val properties = Properties().apply {
            secretsFile.inputStream().use(::load)
        }

        buildKonfig.defaultConfigs {
            properties.forEach { (key, value) ->
                buildConfigField(FieldSpec.Type.STRING, key.toString(), value.toString())
            }
        }
    }

    private val Project.buildKonfig: BuildKonfigExtension
        get() = extensions.getByName(BUILD_KONFIG_EXTENSION) as BuildKonfigExtension

    companion object {
        private const val SECRETS_FILE = "secrets.default.properties"
        private const val BUILD_KONFIG_PLUGIN_CATALOG_ID = "buildkonfig"
        private const val BUILD_KONFIG_EXTENSION = "buildkonfig"
        private const val BUILD_KONFIG_OBJECT_NAME = "BuildConfig"
        private const val BUILD_KONFIG_PACKAGE_NAME = "ir.amirroid.jetnews.config"
    }
}