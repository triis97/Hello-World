#!/bin/sh

if [ -d /application.jar ];
then
    if [ -f /application.jar/*.jar ];
    then
        echo "Running /application.jar/*.jar..."
        sh /application.jar/*.jar
    else
        echo "Application Jar not Found...Exiting..."
        exit 1
     fi
else
    echo "Running /application.jar..."
    sh /application.jar
fi
