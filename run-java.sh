#!/bin/sh
# usage: sh run-java.sh <path/to/File.java>
FILE="$1"
PKG=$(sed -n 's/^package \(.*\);/\1/p' "$FILE" | head -1)
NAME=$(basename "$FILE" .java)
CLASS=${PKG:+$PKG.}$NAME

mkdir -p out
javac -d out -sourcepath . "$FILE" && java -cp out "$CLASS"