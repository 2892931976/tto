#!/usr/bin/env bash

rm -rf output
go install tto.go

CGO_ENABLED=0 GOOS=linux ARCH=amd64 go build -o tto tto.go
CGO_ENABLED=0 GOOS=darwin ARCH=amd64 go build -o mac-tto tto.go
CGO_ENABLED=0 GOOS=windows ARCH=amd64 go build -o tto.exe tto.go

tar cvzf tto-build-bin.tar.gz tto.sh mac-tto tto\
 tto.exe tto.conf templates README.md

rm -rf tto mac-tto tto.exe
