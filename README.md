![alt text](https://github.com/TasosTilsi/VESM/blob/master/resources/logo.png?raw=true)

# Testing my Thesis with Selenium WebDriver and TestNG Framework

**[Visit The Website that we will test](https://tasostilsi.github.io/VESM)**

## Download Prerequisites

To start run this tests, you must have the following
* [Fork, Clone, or Download this project](https://github.com/TasosTilsi/testing-vesm)
* [Download the selenium webdriver jar](https://www.seleniumhq.org/download/)
* [Download the maven project](https://www.seleniumhq.org/download/)

If you want to run the test with the latest drivers download them from the below links provided and move the files in the propriate directories inside the `/main/resources/drivers` directory.
* [Download the mozilla geckodriver](https://github.com/mozilla/geckodriver/)
* [Download the google chrome driver](https://sites.google.com/a/chromium.org/chromedriver/)

If you want to run the test in a portable browser instance download them from the below links provided and move the files in the propriate directories inside the `/main/resources/binaries` directory.
* [Download the google chrome portable browser](https://portableapps.com/apps/internet/google_chrome_portable)
* [Download the mozilla firefox portable browser](https://portableapps.com/apps/internet/firefox_portable)

## Usage

### Basic Usage

You have to be careful about the versions of webdriver you download and the portable or your installed browser to match. Otherwise you will some errors and the tests will not run. 

After downloading all the Prerequisites, simply move in the project directory and run this line of code in a terminal.
```
mvn clean install
```

## Copyright and License 
[![GitHub license](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/TasosTilsi/tasostilsi.github.io/blob/master/LICENSE)

Copyright (c) 2019 Anastasios Tilsizoglou. 
Code released under the [MIT](https://github.com/TasosTilsi/VESM/blob/master/LICENSE.txt) license.
 