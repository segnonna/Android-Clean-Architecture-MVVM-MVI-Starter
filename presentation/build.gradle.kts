import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-kapt")
    id("com.jakewharton.butterknife")
}

kapt {
    correctErrorTypes = true
}
android {

    compileSdkVersion(29)
    buildToolsVersion("30.0.2")

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(29)
        consumerProguardFiles("consumer-rules.pro")
    }

    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).configureEach {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xallow-jvm-ir-dependencies")
        }
    }

    buildFeatures.viewBinding = true
    buildFeatures.dataBinding = true
    // buildFeatures.compose =true

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

    implementation(CommonsDependencies.materialLib)
    implementation(CommonsDependencies.constraintLayoutLib)

    implementation(CommonsDependencies.epoxy)
    annotationProcessor(CommonsDependencies.epoxyProcessor)
    /*implementation(CommonsDependencies.composeUILib)
    implementation(CommonsDependencies.composeMaterialLib)
    //implementation(CommonsDependencies.composeUiToolLib)
    implementation(CommonsDependencies.composeMaterialIconLib)
    //implementation(CommonsDependencies.composeNavigationLib)*/

    implementation("androidx.activity:activity-ktx:1.2.0-rc01")

}