FROM maven:3.8.7-openjdk-18
WORKDIR /app
COPY . /app
RUN mvn pakage
CMD ["mvn", "test"]