object DatabaseVersions {

}

object DatabaseDependencies {

    private const val roomKotlin = "androidx.room:room-ktx:${GlobalVersions.roomVersion}"
    private const val roomAnnotation = "androidx.room:room-compiler:${GlobalVersions.roomVersion}"


    val dependencyNotation = arrayOf(
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.room),
        Pair(DependencyConfiguration.IMPLEMENTATION, roomKotlin),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.javaxInject),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.kotlinConfig),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.gson),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.coroutines),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.time4A),
        Pair(DependencyConfiguration.ANNOTATION_PROCESSING, roomAnnotation),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.pagingCommon),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.pagingRuntime),
        Pair(DependencyConfiguration.IMPLEMENTATION, GlobalDependencies.hiltAndroid),
        Pair(DependencyConfiguration.ANNOTATION_PROCESSING, GlobalDependencies.hiltCompiler)
    )
}