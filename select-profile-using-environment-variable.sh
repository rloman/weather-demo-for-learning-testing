#! /bin/bash
echo "First creating a build in silence mode :-) wait some seconds ... "
mvn clean package 2>&1 | grep -v WARNING > /dev/null
export spring_profiles_active=development,francien,poedel
java -jar ./target/weather-*.jar
