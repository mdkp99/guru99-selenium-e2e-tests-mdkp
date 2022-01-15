# Selenium Tests 

## About

Automated tests e-commerce platform (http://live.techpanda.org) with Java, Selenium WebDriver and Selenium Grid using Page Object Pattern.

## Installation

1. Clone the repository:
```
gh repo clone mdkp99/guru99-selenium-e2e-tests-mdkp
```

## Requirements
1. Apache Maven (https://maven.apache.org/)
2. Java SE Development Kit 15 (https://www.oracle.com/java/technologies/javase-jdk15-downloads.html)

## Configuration
1. Start the Selenium Grid hub, located in: `selenium_server / starthub.bat`
2. Edit the `src / main / resources / config.properties` file and enter your hub address. (The address will be seen after running the file `startHub.bat` with the message` INFO [Hub.start] - Clients should connect to http: //192.168.56.1: 4444 / wd / hub`
3. Specify if you want to run tests on Chrome or Firefox in `src / main / resources / config.properties` Please, use parameter `CHROME` for Google Chrome and `FIREFOX` for Mozilla Firefox
4. Start Selenium Grid node. Please, use `selenium_server / startChromeNode.bat` for `CHROME` or `selenium_server / startFirefoxNode.bat` for `FIREFOX`.


## Running
``` mvn test```
