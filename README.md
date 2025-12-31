# Gradle Multi-Project Builds Sample

A minimal sample implementation of **Gradle Multi-Project Builds** with a **composite build-logic** pattern.

Check the official documentation for more: https://docs.gradle.org/current/userguide/multi_project_builds.html

## Overview

This project demonstrates how to structure a Gradle multi-project build with shared build conventions using a composite build. The `build-logic` directory contains reusable Gradle convention plugins that are applied across all subprojects, eliminating build script duplication and ensuring consistent configuration.

## Project Structure

```
TaskMngr/
├── app/                          # Main application module
├── core/                         # Core utilities and shared code
├── domain/                       # Domain/business logic layer
├── data/                         # Data access layer
├── features/                     # Feature modules
│   ├── task/                     # Task feature
│   └── report/                   # Report feature
└── build-logic/                  # Composite build for convention plugins
    ├── settings.gradle.kts       # Build-logic settings
    ├── build.gradle.kts          # Configures kotlin-dsl plugin
    └── src/main/kotlin/          # Convention plugins
        └── kotlin-jvm-convention.gradle.kts
```

## Key Concepts

### Composite Build (`build-logic`)

The `build-logic` directory is a **composite build** that contains reusable Gradle convention plugins. It's included in the main build via `pluginManagement` in `settings.gradle.kts`:

```kotlin
pluginManagement {
    includeBuild("build-logic")
    // ...
}
```

This approach allows you to:
- Define build logic once and reuse it across all subprojects
- Version control your build conventions alongside your code
- Avoid `buildSrc` limitations (composite builds are cached and more performant)

### Convention Plugin

The `kotlin-jvm-convention.gradle.kts` plugin encapsulates common configuration for Kotlin JVM projects:

```kotlin
plugins {
    kotlin("jvm")
}

kotlin {
    jvmToolchain(21)
}
```

All subprojects simply apply this convention:

```kotlin
plugins {
    id("kotlin-jvm-convention")
}
```

## Module Dependencies

```
app
├── domain
├── data
├── features:task
│   ├── core
│   └── domain
└── features:report
```

## Building and Running

### Build the project
```bash
./gradlew build
```

### Run the application
```bash
./gradlew :app:run
```

### Clean build
```bash
./gradlew clean
```

## Benefits of This Structure

1. **DRY (Don't Repeat Yourself)**: Build configuration is defined once in `build-logic`
2. **Consistency**: All modules use the same Kotlin toolchain and plugin versions
3. **Maintainability**: Changes to build logic only need to be made in one place
4. **Performance**: Composite builds are cached separately from the main build
5. **Scalability**: Easy to add new modules that inherit standard conventions

## Adding a New Module

1. Create a new directory under the root or `features/`
2. Add a `build.gradle.kts` that applies the convention plugin:
   ```kotlin
   plugins {
       id("kotlin-jvm-convention")
   }
   ```
3. Include it in `settings.gradle.kts`:
   ```kotlin
   include(":new-module")
   ```

## Requirements

- JDK 21 or higher
- Gradle 8.14 (wrapper included)
- Kotlin 2.2.21
