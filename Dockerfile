FROM amazoncorretto:17
VOLUME /tmp
CMD mkdirs /app/files
COPY ./build/libs/rxmmxzjtunsygqcvmplk-0.0.1-SNAPSHOT.jar /rxmmxzjtunsygqcvmplk-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "rxmmxzjtunsygqcvmplk-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080