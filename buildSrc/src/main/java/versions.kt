object Versions {
    const val BUILD_TOOLS: String = "4.2.2"
    const val KOTLIN_GRADLE_PLUGIN: String = "4.2.2"
    const val COMPILE_SDK_VERSION: Int = 30
    const val MIN_SDK_VERSION: Int = 19
    const val TARGET_SDK_VERSION: Int = 30

    const val LIFECYCLE = "2.3.1"
}


object Deps {
    val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
    val LIFECYCLE_JAVA8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.LIFECYCLE}"
    val ACTIVITY_KTX = "androidx.activity:activity-ktx:1.3.1"
    val APPCCOMPAT = "androidx.appcompat:appcompat:1.3.1"
    val FRAGMEN_KTX = "androidx.fragment:fragment-ktx:1.3.6"
}