plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.nikitacherenkov.shoppinglist"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.nikitacherenkov.shoppinglist"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.recyclerview)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Room and Architectural Components
    implementation (libs.androidx.room.runtime)
    implementation (libs.androidx.legacy.support.v4)
    implementation (libs.androidx.lifecycle.extensions)
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.androidx.room.ktx)
    ksp (libs.androidx.room.compiler)

    // Coroutines
    implementation (libs.kotlinx.coroutines.core)
    implementation (libs.kotlinx.coroutines.android)

    // New Material Design
    implementation (libs.material)

    // ViewModel
    implementation (libs.androidx.lifecycle.extensions)
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    ksp (libs.androidx.lifecycle.compiler)

    // Kodein
    implementation (libs.kodein.di.generic.jvm)
    implementation (libs.kodein.di.framework.android.x)
}