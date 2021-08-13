buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
    }
}
plugins {
    id("org.jetbrains.kotlinx.binary-compatibility-validator") version "0.6.0"
}

apiValidation {
    ignoredProjects.addAll(listOf("eraser-samples"))
}