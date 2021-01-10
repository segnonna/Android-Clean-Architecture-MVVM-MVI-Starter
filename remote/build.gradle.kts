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
    /* implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
       implementation 'androidx.core:core-ktx:1.2.0'
       implementation 'androidx.appcompat:appcompat:1.2.0'
       implementation 'com.google.android.material:material:1.1.0'
       testImplementation 'junit:junit:4.+'
       androidTestImplementation 'androidx.test.ext:junit:1.1.1'
       androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'*/
}