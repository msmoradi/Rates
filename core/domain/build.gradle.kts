plugins {
    id("rates.android.library")
    kotlin("kapt")
}

android {
    namespace = "com.saeed.rates.core.domain"
}

dependencies {

    implementation(project(":core:data"))
    implementation(project(":core:model"))
    testImplementation(project(":core:testing"))

    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}