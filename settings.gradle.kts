rootProject.name = "JetNews"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
    versionCatalogs.create("androidLibs") {
        from(files("gradle/androidLibs.versions.toml"))
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.10.0"
}

include(":app")
include(":core:common:base")
include(":core:common:compose")
include(":core:data")
include(":core:domain")
include(":core:di")
include(":core:image")
include(":core:resources")
include(":core:network")
include(":core:date")
include(":core:compose:markdown")
include(":core:paging")
include(":core:design-system")

// Features
include(":features:home")
include(":features:article")

includeBuild("build-logic")