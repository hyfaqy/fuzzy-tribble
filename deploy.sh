#!/bin/sh

mkdir -p $CATALINA_HOME/webapps/fuzzy-tribble

cp -r src/main/webapp/* $CATALINA_HOME/webapps/fuzzy-tribble
cp -r target/classes/ $CATALINA_HOME/webapps/fuzzy-tribble/WEB-INF/
cp -r lib $CATALINA_HOME/webapps/fuzzy-tribble/WEB-INF/