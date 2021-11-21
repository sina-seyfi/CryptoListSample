object DomainVersions {

}

object DomainDependencies {
    val dependencyNotation = arrayOf(
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.kotlinConfig),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.javaxInject),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.coroutines),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.pagingCommon)
    )
}