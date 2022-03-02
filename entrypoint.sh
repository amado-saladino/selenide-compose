#! /bin/sh

sudo mvn clean test
status=$?
sudo cp -r /app/target/surefire-reports/* /report
exit $status
