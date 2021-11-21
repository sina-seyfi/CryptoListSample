object CoreVersions {
    const val multiDexVersion = "2.0.1"
    const val logInterceptorVersion = "4.9.1"
    const val timberVersion = "4.7.1"
}


object CoreDependencies {
    private const val multiDex = "androidx.multidex:multidex:${CoreVersions.multiDexVersion}"
    private const val logInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${CoreVersions.logInterceptorVersion}"
    private const val timber = "com.jakewharton.timber:timber:${CoreVersions.timberVersion}"

    val dependencyNotation = arrayOf(
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.core),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.activity),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.navigationUi),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.time4A),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.room),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.appCompat),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.fragment),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.material),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.lifecycleViewModel),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.okHttp),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.retrofitConverter),
        Pair(DependencyConfiguration.IMPLEMENTATION, multiDex),
        Pair(DependencyConfiguration.IMPLEMENTATION, timber),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.glide),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.glideOkHttpIntegration),
        Pair(DependencyConfigurationBuilder(BuildTypes.Debug, Flavors.Develop).IMPLEMENTATION, logInterceptor),
        Pair(DependencyConfiguration.ANNOTATION_PROCESSING, GlobalDependencies.glideCompiler),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.hiltAndroid),
        Pair(DependencyConfiguration.ANNOTATION_PROCESSING, GlobalDependencies.hiltCompiler)
    )


}