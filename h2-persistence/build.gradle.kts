plugins {
    id("org.springframework.boot") version "2.7.4"
    id("io.spring.dependency-management") version "1.0.14.RELEASE"
    kotlin("jvm") version "1.7.20"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.7.20"
}

java.sourceCompatibility = JavaVersion.VERSION_1_8

dependencies {
    // domain
    implementation(project(":domain-task"))
    implementation(project(":usecase"))

    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // persistence
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2")
    implementation("javax.persistence:javax.persistence-api:2.2")

    // tests
    testCompileOnly("org.junit.jupiter:junit-jupiter-api:5.9.1")
    testImplementation("io.projectreactor:reactor-test")
}

tasks.test {
    useJUnitPlatform()
}
