plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.parcelize)

    // САМОЕ ВАЖНОЕ — используем новую версию Hilt, которая поддерживает Kotlin 2.2.0
    id("com.google.dagger.hilt.android") version "2.53" apply false
}

android {
    namespace = "md.restaurant.app"
    compileSdk = 36

    defaultConfig {
        applicationId = "md.restaurant.app"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        resourceConfigurations += listOf("en", "ru", "ro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // Network
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.okhttp.logging)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.gson)

    // UI
    implementation(libs.glide)
    implementation(libs.androidx.viewpager2)

    // HILT — ВЕРСИЯ 2.53 (единственная, которая поддерживает Kotlin 2.2.0+)
    implementation("com.google.dagger:hilt-android:2.53")
    kapt("com.google.dagger:hilt-android-compiler:2.53")


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

// Добавляем Hilt плагин
apply(plugin = "dagger.hilt.android.plugin")
apply(plugin = "kotlin-kapt")

kapt {
    correctErrorTypes = true
}