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

    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}