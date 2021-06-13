<h1 align="center"> Fake Printer </h1> <br>

<p align="center">
  Try AWT library and designing a printer.
</p>

![Commands](https://i.imgur.com/roukFQa.jpeg "Logo Title Text 1")
![Printer](https://i.imgur.com/J7l0Jyy.jpeg "Logo Title Text 1")


## Table of Contents

- [Introduction](#introduction)
- [Requirements](#requirements)
- [Quick Start](#quick-start)
- [Acknowledgements](#acknowledgements)




## Introduction

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

TODO: This practice was made in 2016

## Requirements
The application can be run locally or in a docker container, the requirements for each setup are listed below.

### Local
* [Java 8 SDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven](https://maven.apache.org/download.cgi)


### Docker
* [Docker](https://www.docker.com/get-docker)


## Quick Start

### Run Local
Just move to source code repository and execute commands below

```
$ cd /src/code/

$ javac Printer.java

$ java Printer
```

Application will run by default on port `1234`

Configure the port by changing `server.port` in __application.yml__


### Run Docker (You should share your X11 server to the docker container)

Firt pull java docker image from docker registry

```bash
$ docker pull openjdk:11
```

Run an instance of the image and bind the local location repository's folder into the docker container

When ready, run it:
```bash
$ docker run --rm --it \
	--runtime=nvidia \
	-v "/tmp/.X11-unix/:/tmp/.X11-unix/" \
	-v "$HOME/.Xauthority:/root/.Xauthority:rw" \
	-e DISPLAY=unix$DISPLAY \
	--privileged \
	-v "$PWD/PROYECTO U123":/src/code \
	--name try-printer openjdk:11 /bin/bash
```

Next, move to source code repository and execute commands below

```
$ cd /src/code/

$ javac Printer.java

$ java Printer
```

Application will launch in a new window.

It's all. taste it! XD
