plugins {
	java
	jacoco
	id("org.springframework.boot") version "4.1.2"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.pipeline"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}

jacoco {
	toolVersion = "0.8.16"
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
	finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
	dependsOn(tasks.test)

	classDirectories.setFrom(
		files(classDirectories.files.map {
			fileTree(it) {
				exclude("**/ApiActionsApplication.class")
			}
		})
	)

	reports {
		xml.required.set(true)
		csv.required.set(false)
		html.required.set(true)
	}
}
