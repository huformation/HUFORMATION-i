
# HUFORMATION-i  ![](https://img.shields.io/static/v1?label=version&message=v0.1&color=orange) ![](https://img.shields.io/static/v1?label=Framework&message=spring-boot&color=blue) ![](https://img.shields.io/static/v1?label=author&message=Aron-Roh&color=yellow) ![](https://github.com/roharon/huformation-i/workflows/build-test/badge.svg)

Cafeteria & Library information delivery chatbot for Hankuk University Of Foreign Studies

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
Give examples
```

### Installing

You  need to install openjdk version 11

```
$ sudo add-apt-repository ppa:openjdk-r/ppa
$ sudo apt install openjdk-11-jdk
```

## How to Build

```
$ ./gradlew clean build
```

## Deployment

You should run the ***jar*** file on the server

Simple example (running on background)
```
$ java -jar ./build/libs/huformation-i*.jar
```

And, you must connect server with chat bot on [Kakao-i Open Builder](https://i.kakao.com/openbuilder)


## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/roharon/huformation-i/tags). 

## Authors

* **Aron Roh** - *Huformation Developer* - [roharon](https://github.com/roharon)

See also the list of [contributors](https://github.com/roharon/huformation-i/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details