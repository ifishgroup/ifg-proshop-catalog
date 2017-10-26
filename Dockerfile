FROM openjdk:8u141-jdk AS build

COPY . /usr/src/
WORKDIR /usr/src/
RUN ./gradlew clean build


FROM openjdk:8-jre-alpine

CMD ["java", "-jar", "/ifg-proshop-catalog.jar"]
EXPOSE 8080
COPY --from=build /usr/src/build/libs/ifg-proshop-catalog-0.1.0.jar /ifg-proshop-catalog.jar
COPY wait-for.sh ./
RUN chmod +x ./wait-for.sh
