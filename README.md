#EpochClockModel

[![Build Status](https://travis-ci.org/rbouckaert/asc.svg?branch=master)](https://travis-ci.org/rbouckaert/EpochClockModel)

A [BEAST2](http://beast2.org) package for epoch clock models

## Installation

Install by hand as follows:

* Create the `EpochClockModel` directory inside the BEAST package directory

```
for Windows in Users\<YourName>\BEAST\2.7\EpochClockModel
for Mac in /Users/<YourName>\/Library/Application Support/BEAST/2.7/EpochClockModel
for Linux /home/<YourName>/.beast/2.7/EpochClockModel
```

* Download the latest release [here](https://github.com/rbouckaert/EpochClockModel/releases/download/v0.0.2/EpochClockModel.v0.0.2.zip)
* Unzip EpochClockModel.v0.0.2.zip in the directory `EpochClockModel` just created
* It should be available to BEAST2 and BEAUti now, but in case of problems, remove the `beauti.properties` file from the `BEAST/2.7` directory and start BEAST again (it should recreated that file).


## Using the package

To set up an XML, start BEAUti and choose EpochClockModel from the drop down box and change the epoch boundaries to what you need.

