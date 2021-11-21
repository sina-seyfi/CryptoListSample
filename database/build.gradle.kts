plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = 30

    defaultConfig {
        minSdk = 21
        targetSdk = 30

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildTypes {
        getByName(BuildTypes.Debug.name) {
            BuildTypes.Debug.configs.forEach { config ->
                this.buildConfigField(config.first, config.second, config.third)
            }
        }
    }
    compileOptions {
        sourceCompatibility = Configuration.JavaVersionSupport
        targetCompatibility = Configuration.JavaVersionSupport
    }
    kotlinOptions {
        jvmTarget = Configuration.jvmTarget
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":log"))
    implementation(project(":data"))
    implementation(project(":domain"))

    DatabaseDependencies.dependencyNotation.forEach {
        this.add(it.first, it.second)
    }
}