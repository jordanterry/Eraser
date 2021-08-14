object Versions {
    const val BUILD_TOOLS: String = "4.2.2"
    const val KOTLIN_GRADLE_PLUGIN: String = "1.5.21"
    const val COMPILE_SDK_VERSION: Int = 30
    const val MIN_SDK_VERSION: Int = 19
    const val TARGET_SDK_VERSION: Int = 30

    const val LIFECYCLE = "2.3.1"
    const val ACTIVIY_KTX = "1.3.1"
    const val APP_COMPAT = "1.3.1"
    const val FRAGMENT_KTX = "1.3.6"
}

object Libs {
    val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
    val LIFECYCLE_JAVA8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.LIFECYCLE}"
    val ACTIVITY_KTX = "androidx.activity:activity-ktx:${Versions.ACTIVIY_KTX}"
    val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"
}