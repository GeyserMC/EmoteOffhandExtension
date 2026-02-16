plugins {
    id("java")
}

repositories {
    mavenCentral()
    maven("https://repo.opencollab.dev/main")
}

dependencies {
    compileOnly("org.geysermc.geyser:api:2.9.3-SNAPSHOT")
}

tasks {
    named<Jar>("jar") {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        archiveFileName.set("${project.name}.jar")

        from({
            configurations.runtimeClasspath.get().map { file ->
                if (file.isDirectory) file else zipTree(file)
            }
        }, project.rootProject.file("LICENSE"))
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
