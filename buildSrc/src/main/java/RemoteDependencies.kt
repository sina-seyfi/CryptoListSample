object RemoteVersions {}

object RemoteDependencies {
    val dependencyNotation = arrayOf(
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.retrofit),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.coroutines),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.okHttp),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.kotlinConfig),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.javaxInject),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.gson),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.pagingCommon)
    )
}