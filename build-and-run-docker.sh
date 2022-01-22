#!/bin/zsh
mvn package
docker build -t asetad/account-example:1.0 .
docker run --name=account-example -d -p 8080:8080 --restart=unless-stopped asetad/account-example:1.0