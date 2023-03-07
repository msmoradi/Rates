plugins {
    id("rates.android.feature")
    id("rates.android.library.compose")
}

android {
    namespace = "com.saeed.rates.feature.home"
}

dependencies {
    implementation(libs.androidx.compose.material3.windowSizeClass)
}