#!/bin/bash

cd src
javac -cp ".:../lib/tests.jar" -d ../bin representation/Variable.java
#javac -cp ".:../lib/*.jar" -d ../bin representation/BooleanVariable.java
javac -cp ".:../lib/tests.jar" -d ../bin unit/representation/*.java
javac -cp ".:../lib/tests.jar" -d ../bin MainUnit.java

#cd bin
#java -cp ".:../lib/tests.jar" Main

if [ $# -eq 1 ]; then
    cd ..
    cd bin
    java -cp ".:../lib/tests.jar" MainUnit
fi