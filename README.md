#EpochClockModel

[![Build Status](https://travis-ci.org/rbouckaert/asc.svg?branch=master)](https://travis-ci.org/rbouckaert/EpochClockModel)

A [BEAST2](http://beast2.org) package for epoch clock models

## Installation

You can install through the package manager or by hand.

To install through the package manager:

> * Start BEAUti
> * Click to the `File => Manage packages` menu item.
> * Select `EpochClockModel` in the list of packages and the click `Install` button.
If `EpochClockModel` is not in the list of packages, you must add a package repository first like so: in the package manager, click `Package repositories` button, then click `Add URL` in the window that pops up, where you can put `https://raw.githubusercontent.com/CompEvol/CBAN/master/packages-extra-2.7.xml` in the text field. 
Then return to the package manager window where the `EpochClockModel` package should appear.
> * Close BEAUti -- it needs to restart to pick up the new packages.

To install by hand as follows:

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

