plugins {
    id("kotlin-jvm-convention")
    application
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(project(":features:task"))
    implementation(project(":features:report"))
}

application {
    mainClass.set("dev.evertonprdo.MainKt")
}