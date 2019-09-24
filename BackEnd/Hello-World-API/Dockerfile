# FROM openjdk:11 as builder

# RUN apt-get update -q \
#         && apt-get upgrade -qy \
#         && apt-get install -qy dos2unix

# WORKDIR /usr/app/
# COPY gradlew /usr/app/
# COPY gradle /usr/app/gradle

# RUN dos2unix ./gradlew && chmod +x ./gradlew
# # download gradle
# RUN ./gradlew --continue

# COPY build.gradle.kts settings.gradle.kts /usr/app/
# # download deps
# RUN ./gradlew build -i || true

# # build
# COPY . .
# RUN dos2unix ./gradlew && chmod +x ./gradlew
# RUN ./gradlew bootJar -i

# FROM openjdk:11-jre
# COPY --from=builder /usr/app/build/libs/*.jar application.jar

# ENTRYPOINT java -jar application.jar
FROM openjdk:11 as builder

RUN apt-get update -q \
        && apt-get upgrade -qy \
        && apt-get install -qy dos2unix

WORKDIR /usr/app/
COPY gradlew /usr/app/
COPY gradle /usr/app/gradle

RUN dos2unix ./gradlew
# download gradle
RUN ./gradlew --continue

COPY build.gradle.kts settings.gradle.kts /usr/app/
# download deps
RUN ./gradlew build -i || true

# build
COPY . .
RUN dos2unix ./gradlew
RUN ./gradlew bootJar -i

FROM openjdk:11-jre
COPY --from=builder /usr/app/build/libs/*.jar application.jar

ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.2.1/wait /wait
RUN chmod +x /wait

ENTRYPOINT WAIT_HOSTS=$DB_HOST /wait && java -jar application.jar
