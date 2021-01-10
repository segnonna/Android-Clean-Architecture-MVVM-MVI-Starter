plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-android")
}

android {
    compileSdkVersion(29)
    buildToolsVersion("30.0.2")

    defaultConfig {
        minSdkVersion(16)
        targetSdkVersion(29)
        consumerProguardFiles("consumer-rules.pro")
    }

    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).configureEach {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    buildFeatures.viewBinding = true
}

dependencies {
    implementation(CommonsDependencies.lifecycleViewmodelLib)
    implementation(CommonsDependencies.lifecycleRuntimeKtsLib)
    implementation(CommonsDependencies.lifecycleLivedataKtsLib)
    implementation(CommonsDependencies.koinCoreLib)
    implementation(CommonsDependencies.koinAndroidViewModelLib)

    implementation(CommonsDependencies.jetBrainKotlinStdLib)
    implementation(CommonsDependencies.kotlinxCoroutinesCoreLib)
    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":remote")))
    implementation(CommonsDependencies.lifecycleViewmodelLib)
    implementation(CommonsDependencies.lifecycleRuntimeKtsLib)
    implementation(CommonsDependencies.lifecycleCommonsJava8Lib)
    implementation(CommonsDependencies.lifecycleExtensionLib)
    implementation(CommonsDependencies.lifecycleReactivestreamsLib)

    implementation("androidx.activity:activity-ktx:1.2.0-rc01")

}