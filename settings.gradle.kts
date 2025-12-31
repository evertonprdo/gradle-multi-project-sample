rootProject.name = "TaskMngr"

pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

include(":app")
include(":core")
include(":domain")
include(":data")

include(":features:task")
include(":features:report")
