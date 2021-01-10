import CommonsDependencies.jetBrainKotlinStdLib

plugins {
    id("java-library")
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(jetBrainKotlinStdLib)
    api(CommonsDependencies.jetBrainKotlinStdLib)
    api(CommonsDependencies.kotlinxCoroutinesCoreLib)
    api(CommonsDependencies.koinCoreLib)
    implementation(CommonsDependencies.kotlinReflect)
    testImplementation(CommonsDependencies.mockkLib)
    testImplementation(CommonsDependencies.junitEngineLib)
    testImplementation(CommonsDependencies.junitAPiLib)
    testImplementation(CommonsDependencies.junitParamsLib)
    testImplementation(CommonsDependencies.kluentLib)
    testImplementation(CommonsDependencies.junitLib)
    runtimeOnly(CommonsDependencies.junitVintageEngineLib)
    runtimeOnly(CommonsDependencies.junitJupiterEngineLib)
}