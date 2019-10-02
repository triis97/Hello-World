#!/bin/sh

if [ -d /application.jar ];
then
    if [ -f /application.jar/*.jar ];
    then
        echo "Running /application.jar/*.jar..."
        java -jar /application.jar/*.jar
    else
        echo "Application Jar not Found...Exiting..."
        exit 1
     fi
else
    echo "Running /application.jar..."
    java -jar /application.jar
fi
