package ir.amirroid.jetnews.convention

import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.artifacts.VersionCatalog
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

internal fun VersionCatalog.findPluginId(alias: String) = findPlugin(alias).get().get().pluginId


internal val NamedDomainObjectContainer<KotlinSourceSet>.androidMain: KotlinSourceSet
    get() = maybeCreate("androidMain")
internal val NamedDomainObjectContainer<KotlinSourceSet>.commonMain: KotlinSourceSet
    get() = maybeCreate("commonMain")

fun KotlinDependencyHandler.implementIfNotSelf(projectPath: String) {
    if (project.path != projectPath) {
        implementation(project(projectPath))
    }
}