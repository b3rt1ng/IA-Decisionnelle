#!/bin/bash

cd src
#javac -cp ".:./lib/*.jar" -d bin src/*/*/*
javac -cp ".:../lib/*.jar" -d ../bin representation/*.java

#cd bin
#java -cp ".:../lib/tests.jar" Main

if [ $# -eq 1 ]; then
    cd bin
    java unit.representation.TestVariable -cp representation.Variable
fi