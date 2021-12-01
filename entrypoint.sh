#! /bin/sh

sudo mvn clean test
sudo cp -r /app/target/surefire-reports/* /report