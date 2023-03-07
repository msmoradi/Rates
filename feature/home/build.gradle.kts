plugins {
    id("rates.android.feature")
    id("rates.android.library.compose")
}

android {
    namespace = "com.saeed.rates.feature.home"
}

dependencies {
    implementation(project(":core:designsystem"))
    implementation(project(":core:model"))
    implementation(libs.androidx.compose.material3.windowSizeClass)
}