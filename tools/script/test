#!/bin/bash
ant junit:compile
if [ "$1" = "" ]; then
        ant junit:run
else
    if [ "$2" = "gui" ]; then
        java -cp target/classes/production/:target/classes/test/:tools/lib/junit.jar junit.swingui.TestRunner $1
    else 
        java -cp target/classes/production/:target/classes/test/:tools/lib/junit.jar junit.textui.TestRunner $1
    fi
fi
