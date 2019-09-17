# README

In this archive, the iObserve project and the Software Engineering Group of Kiel
University provide a distributed version of the JPetStore. The application is
divided in one frontend service and three backend services which handle
account management, the catalog and the order operations.

Before we discuss any details, we want to thank the MyBatis team for providing
the JPetStore.

## Requirements

- Java 7 or higher
- git
- Maven 
- docker (optional)

## Preparation

After cloning our repository, select the `master` or `distributed-with-presentation-layer`
branch to get the distributed version without Kieker instrumentation. 
`git checkout distributed-with-presentation-layer`

Compile JPetStore with
`mvn clean compile package`

While `clean` is not necessary, it is helpful when you compiled it before and
want to ensure to start from a clean environment.

## Execution

After compilation and packaging you can deploy all packages in you own tomcat or other
servlet environment. 

Additionally, we provide a `Dockerfile`. You can run either run `docker build` yourself
or use the `create-docker-images.sh` script to generate a docker image. In case you used
the `create-docker-images.sh` script, the image is named `single-jpetstore`.

Before deploying the JPetStore or starting the docker image, you need to have a log
collector to receive all monitoring data. Such collector can be found in the iObserve
project. You also need to know the IP address of the host where the collector is running
on. We store that IP address in the LOGGER environment variable.

Futher detail can be found in 
https://github.com/research-iobserve/single-jpetstore-clustering-experiment

### Docker

Starting the docker container can then be performed with:
`docker run -e LOGGER=$LOGGER single-jpetstore`

