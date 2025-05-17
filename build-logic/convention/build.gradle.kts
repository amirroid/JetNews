plugins {
    `kotlin-dsl`
}

dependencies {
    // BuildKonig plugins
    implementation(libs.buildkonfig.compiler)
    implementation(libs.buildkonfig.gradle.plguin)

    // Android & Compose plugins
    implementation(libs.pluginAndroidCompiler)
    implementation(libs.pluginKotlinCompiler)
    implementation(libs.pluginComposeCompiler)
}

val namespace = "ir.amirroid.jetnews.convention"

fun NamedDomainObjectContainer<PluginDeclaration>.createPlugin(
    name: String,
    implementationClass: String,
    subNamespace: String = ""
) = create(name) {
    val cleanedSubNamespace = subNamespace.trim('.')
    val fullNamespace = listOfNotNull(namespace, cleanedSubNamespace.takeIf { it.isNotEmpty() })
        .joinToString(".")

    this.implementationClass = "$fullNamespace.$implementationClass"
    this.id = "$namespace.$name"
}

gradlePlugin {
    plugins {
        createPlugin(
            name = "build-config",
            implementationClass = "DefaultSecretsPlugin",
            subNamespace = "config"
        )
        createPlugin(
            name = "multiplatform-plugin",
            implementationClass = "KotlinMultiplatformPlugin",
            subNamespace = "compose"
        )
        createPlugin(
            name = "android-plugin",
            implementationClass = "AndroidApplicationPlugin",
            subNamespace = "android"
        )
    }
}