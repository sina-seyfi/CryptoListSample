object PresentationVersions {
    const val coreVersion = "1.7.0"
    const val constraintLayoutVersion = "2.0.4"
    const val lottieVersion = "3.5.0"
    const val composeVersion = "1.0.4"
    const val imageWorkerVersion = "1.2.0"
    const val leakCanaryVersion = "2.7"
    const val navigationComposeVersion = "2.4.0-beta02"
    const val hiltNavigationFragment = "1.0.0"
    const val pagingComposeVersion = "1.0.0-alpha13"
    const val coilVersion = "1.4.0"
}

object PresentationDependencies {
    private const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${PresentationVersions.constraintLayoutVersion}"
    private const val material =
        "com.google.android.material:material:${GlobalDependencies.material}"
    private const val lifecycleViewModelCompose =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${GlobalVersions.lifecycleVersion}"
    private const val lifecycleLiveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${GlobalVersions.lifecycleVersion}"
    private const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${GlobalVersions.lifecycleVersion}"
    private const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${GlobalVersions.navigationVersion}"
    private const val navigationComposeVersion =
        "androidx.navigation:navigation-compose:${PresentationVersions.navigationComposeVersion}"
    private const val hiltNavigationFragment =
        "androidx.hilt:hilt-navigation-fragment:${PresentationVersions.hiltNavigationFragment}"

    private const val fragment =
        "androidx.fragment:fragment-ktx:${GlobalVersions.fragmentVersion}"

    private const val activityCompose =
        "androidx.activity:activity-compose:${GlobalVersions.activityVersion}"

    private const val lottie =
        "com.airbnb.android:lottie:${PresentationVersions.lottieVersion}"

    private const val composeUi =
        "androidx.compose.ui:ui:${PresentationVersions.composeVersion}"

    private const val composeUiTooling =
        "androidx.compose.ui:ui-tooling:${PresentationVersions.composeVersion}"

    private const val composeUiToolingPreview =
        "androidx.compose.ui:ui-tooling-preview:${PresentationVersions.composeVersion}"

    private const val composeRuntime =
        "androidx.compose.runtime:runtime:${PresentationVersions.composeVersion}"

    private const val composeMaterial =
        "androidx.compose.material:material:${PresentationVersions.composeVersion}"

    private const val composeFoundation =
        "androidx.compose.foundation:foundation:${PresentationVersions.composeVersion}"

    private const val composeCompiler =
        "androidx.compose.compiler:compiler:${PresentationVersions.composeVersion}"

    private const val composeAnimation =
        "androidx.compose.animation:animation:${PresentationVersions.composeVersion}"

    private const val leakCanary =
        "com.squareup.leakcanary:leakcanary-android:${PresentationVersions.leakCanaryVersion}"

    private const val pagingCompose =
        "androidx.paging:paging-compose:${PresentationVersions.pagingComposeVersion}"

    private const val coil =
        "io.coil-kt:coil:${PresentationVersions.coilVersion}"

    private const val coilCompose =
        "io.coil-kt:coil-compose:${PresentationVersions.coilVersion}"

    val dependencyNotation = arrayOf(
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.core),
        Pair(DependencyConfiguration.IMPLEMENTATION, lottie),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.activity),
        Pair(DependencyConfiguration.IMPLEMENTATION, activityCompose),
        Pair(DependencyConfiguration.IMPLEMENTATION, fragment),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.appCompat),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.time4A),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.coroutines),
        Pair(DependencyConfiguration.IMPLEMENTATION, constraintLayout),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.lifecycleViewModel),
        Pair(DependencyConfiguration.IMPLEMENTATION, lifecycleViewModelCompose),
        Pair(DependencyConfiguration.IMPLEMENTATION, lifecycleLiveData),
        Pair(DependencyConfiguration.IMPLEMENTATION, lifecycleRuntime),
        Pair(DependencyConfiguration.IMPLEMENTATION, navigationFragment),
        Pair(DependencyConfiguration.IMPLEMENTATION, navigationComposeVersion),
        Pair(DependencyConfiguration.IMPLEMENTATION, hiltNavigationFragment),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.navigationUi),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.glide),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.glideOkHttpIntegration),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.material),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.javaxInject),
        Pair(DependencyConfiguration.IMPLEMENTATION, composeUi),
        Pair(DependencyConfiguration.DEBUG_IMPLEMENTATION, composeUiTooling),
        Pair(DependencyConfiguration.IMPLEMENTATION, composeUiToolingPreview),
        Pair(DependencyConfiguration.IMPLEMENTATION, composeRuntime),
        Pair(DependencyConfiguration.IMPLEMENTATION, composeMaterial),
        Pair(DependencyConfiguration.IMPLEMENTATION, composeFoundation),
        Pair(DependencyConfiguration.IMPLEMENTATION, composeCompiler),
        Pair(DependencyConfiguration.IMPLEMENTATION, composeAnimation),
        Pair(DependencyConfiguration.IMPLEMENTATION, coil),
        Pair(DependencyConfiguration.IMPLEMENTATION, coilCompose),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.pagingCommon),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.pagingRuntime),
        Pair(DependencyConfiguration.IMPLEMENTATION, pagingCompose),
        Pair(DependencyConfiguration.DEBUG_IMPLEMENTATION, leakCanary),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.hiltAndroid),
        Pair(DependencyConfiguration.ANNOTATION_PROCESSING, GlobalDependencies.hiltCompiler)
    )
}