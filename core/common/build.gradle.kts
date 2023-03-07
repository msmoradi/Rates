plugins {
    id("rates.android.library")
    id("rates.android.hilt")
}

android {
    namespace = "com.saeed.rates.core.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
}