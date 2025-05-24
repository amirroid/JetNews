plugins {
    alias(libs.plugins.local.android.library)
    alias(libs.plugins.local.kotlin)
    alias(libs.plugins.local.koin)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
}

kotlin.sourceSets {
    androidMain {
        dependencies {
            implementation(libs.room.ktx)
        }
    }
    commonMain {
        dependencies {
            implementation(libs.room.runtime)
            implementation(libs.room.paging)
            implementation(libs.paging.runtime)
            implementation(libs.sqlite.bundled)
        }
    }
}

dependencies {
    add("kspAndroid", libs.room.compiler)
    add("kspIosSimulatorArm64", libs.room.compiler)
    add("kspIosX64", libs.room.compiler)
    add("kspIosArm64", libs.room.compiler)
}

room {
    schemaDirectory("$projectDir/schemas")
}