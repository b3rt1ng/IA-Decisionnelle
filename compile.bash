#!/bin/bash

cd src
javac -cp ".:../lib/tests.jar:../bin/" -d ../bin representation/Variable.java
javac -cp ".:../lib/tests.jar:../bin/representation/Variable" -d ../bin representation/BooleanVariable.java
javac -cp ".:../lib/tests.jar:../bin/" -d ../bin unit/representation/*.java
javac -cp ".:../lib/tests.jar:../bin/" -d ../bin MainUnit.java

#cd bin
#java -cp ".:../lib/tests.jar" Main

if [ $# -eq 1 ]; then
    cd ..
    cd bin
    java -cp ".:../lib/tests.jar" MainUnit
fi