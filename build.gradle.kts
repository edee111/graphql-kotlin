import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.0"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.4.10"
	kotlin("plugin.spring") version "1.4.10"
}

group = "com.grapthql.kotlin"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
	jcenter()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	developmentOnly("org.springframework.boot:spring-boot-devtools")

	implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:8.0.0")

	runtimeOnly("com.graphql-java-kickstart:altair-spring-boot-starter:8.0.0")
	runtimeOnly("com.graphql-java-kickstart:graphiql-spring-boot-starter:8.0.0")
	runtimeOnly("com.graphql-java-kickstart:voyager-spring-boot-starter:8.0.0")
	runtimeOnly("com.graphql-java-kickstart:playground-spring-boot-starter:8.0.0")

	// testing facilities
	testImplementation("com.graphql-java-kickstart:graphql-spring-boot-starter-test:8.0.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}
