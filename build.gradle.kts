buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.BUILD_TOOLS}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN_GRADLE_PLUGIN}")
    }
}
plugins {
    id("org.jetbrains.kotlinx.binary-compatibility-validator") version "0.6.0"
}

apiValidation {
    ignoredProjects.addAll(listOf("eraser-samples"))
}
