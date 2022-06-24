FROM openjdk:11
COPY out/artifacts/LibrarySpring_jar/*.jar LibrarySpring.jar
ENTRYPOINT ["java", "-jar", "/LibrarySpring.jar"]