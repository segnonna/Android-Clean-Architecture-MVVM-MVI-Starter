plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(29)
    buildToolsVersion("30.0.2")

    defaultConfig {
        minSdkVersion(16)
        targetSdkVersion(29)
        consumerProguardFiles("consumer-rules.pro")
    }

}

dependencies {

    implementation(project(mapOf("path" to ":data")))
    implementation(CommonsDependencies.jetBrainKotlinStdLib)
    implementation(CommonsDependencies.koinCoreLib)
    implementation(CommonsDependencies.okhttpLib)
    implementation(CommonsDependencies.retrofitLib)
    api(CommonsDependencies.gsonLib)
    implementation(CommonsDependencies.gsonConverterLib)
    implementation(CommonsDependencies.okhttLoggingInterceptorLib)
    testImplementation(CommonsDependencies.mockkLib)
    testImplementation(CommonsDependencies.junitEngineLib)
    testImplementation(CommonsDependencies.junitAPiLib)
    testImplementation(CommonsDependencies.junitParamsLib)
    testImplementation(CommonsDependencies.kluentLib)
    testImplementation(CommonsDependencies.junitLib)
    runtimeOnly(CommonsDependencies.junitVintageEngineLib)
    runtimeOnly(CommonsDependencies.junitJupiterEngineLib)
}