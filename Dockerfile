FROM openjdk:25-jdk
ADD target/student-app.jar student-app.jar
ENTRYPOINT ["java","-jar","/student-app.jar"]