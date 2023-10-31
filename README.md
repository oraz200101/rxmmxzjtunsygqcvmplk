# rxmmxzjtunsygqcvmplk

# 1 DESCRIPTION 
  1.1 Application has basic crud operations for same 2 models, but models use different databases (MongoDb, Postgres)
  1.2 Used Swagger for documentation of project, flyway to migrate postgres database and used annotations @PostConstruct and @PreDestroy to input data to MongoDb
  1.3 Used TestNG for test application


# 2 INSTALLATION
  
  2.1 VERSION 1
   Install JDK 17, MongoDb 7.0.0, PostgreSql 15 and last version of gradle
   Clone project with command: git clone https://github.com/oraz200101/rxmmxzjtunsygqcvmplk.git
   Set datasource properties to databases in 'src/main/resources/application.yaml'
   Open terminal with folder of project and use command ./gradlew bootRun or (If you have IntelliJ Idea you can run with main class)
  
  2.2 VERSION 2
   Install JDK 17, gradle 
   Open terminal with folder of project and use command ./gradlew build
   Use command docker-compose build after that use docker-compose up

# 3 USE
  3.1 Open Postman and import collection form 'src/main/resources/requests/PhoneCollection.postman_collection.json'
  3.2 Send requests and get responses
  
  
