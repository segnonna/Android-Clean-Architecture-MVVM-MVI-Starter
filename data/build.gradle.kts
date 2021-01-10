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

    api(project(mapOf("path" to ":domain")))
    testImplementation(CommonsDependencies.mockkLib)
    testImplementation(CommonsDependencies.junitEngineLib)
    testImplementation(CommonsDependencies.junitAPiLib)
    testImplementation(CommonsDependencies.junitParamsLib)
    testRuntimeOnly(CommonsDependencies.junitJupiterEngineLib)
    testImplementation(CommonsDependencies.kluentLib)
    testImplementation(CommonsDependencies.junitLib)
    testRuntimeOnly(CommonsDependencies.junitVintageEngineLib)
    testRuntimeOnly(CommonsDependencies.kotlinReflect)
}