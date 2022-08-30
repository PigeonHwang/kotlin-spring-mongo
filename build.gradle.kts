import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.3"
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
    id("com.netflix.dgs.codegen") version "5.1.17"

    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    //kotlin("plugin.jpa") version "1.6.21"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter-web")
    //implementation("org.springframework.data.mongodb.core.MongoOperations")

    // GraphQL dependencies
    implementation(platform("com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:latest.release"))
    implementation("com.netflix.graphql.dgs:graphql-dgs-extended-scalars")
    implementation("com.netflix.graphql.dgs:graphql-dgs-spring-boot-starter")

    //implementation("com.graphql-java-kickstart:playground-spring-boot-starter:11.1.0")
    //implementation("com.graphql-java-kickstart:playground-spring-boot-autoconfigure:11.1.0")

    // jpa
    //implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

allOpen {
    annotation("org.springframework.data.mongodb.core.mapping.Document")
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

tasks.withType<com.netflix.graphql.dgs.codegen.gradle.GenerateJavaTask> {
    packageName = "com.example.demo.generated"
    generateClient = true
    typeMapping = mutableMapOf(
        "User" to "com.example.demo.model.User",
        "UserRole" to "com.example.demo.model.UserRole"
        //"UserRole" to "com.example.demo.model.user.UserRole"
    )
}