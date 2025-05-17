package ir.amirroid.jetnews.convention

import org.gradle.api.artifacts.VersionCatalog

internal fun VersionCatalog.findPluginId(alias: String) = findPlugin(alias).get().get().pluginId