#! /bin/bash
echo "First creating a build in silence mode :-) wait some seconds ... "
mvn clean package 2>&1 | grep -v WARNING > /dev/null
java -Dspring.profiles.active=development -jar ./target/weather-*.jar
