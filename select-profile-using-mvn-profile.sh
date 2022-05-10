#! /bin/bash
echo
echo "We will set the mvn profile to dev which reads the pom.xml for that profile and sets the spring.profiles.active=development"
echo
echo
mvn clean package -Pdev
java -jar ./target/weather-*.jar
