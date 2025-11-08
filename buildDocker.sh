#!/bin/sh

./mvnw package

docker build -t private-dining-reservation .
