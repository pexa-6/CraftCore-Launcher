plugins {
    kotlin("jvm") version "1.9.10"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val javafxVersion = "21"
val os = "win"

dependencies {
    implementation(kotlin("stdlib"))

    implementation("org.openjfx:javafx-base:$javafxVersion:$os")
    implementation("org.openjfx:javafx-controls:$javafxVersion:$os")
    implementation("org.openjfx:javafx-graphics:$javafxVersion:$os")
    implementation("org.openjfx:javafx-fxml:$javafxVersion:$os")
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("org.example.MainApp")
}

tasks.withType<JavaExec> {
    jvmArgs = listOf(
        "--module-path", configurations.runtimeClasspath.get().asPath,
        "--add-modules", "javafx.controls,javafx.fxml"
    )
}