
Installing and Building Slider on CentOS 6.5 with HDP 2.1
=================================================

In this tutorial we are going to show how to build Apache Slider project from a git repository. This is the latest version that is under works. This seems to be working well with HDP 2.1.


Prerequiste
===========
* HDP 2.1 Installated
* Oracle JDK 1.6 (64-bit)
* Python 2.6 (By deafult it is installed with CentOS)
* Maven 3.0 (3.1 is not supported)


Install Git
============
* yum install git

Building Apache Slider
=====================
* git clone https://github.com/apache/incubator-slider.git
* It should create a folder called 'incubator-slider
* Using Maven 3.2 build the slider project
* mvn clean site:site stage:stage package -DskipTests
* You should see the application built
* The built project is under 'incubator-slider/slider-assembly/target/slider-0.50.2-incubating-all.zip
* unzip slider-0.50.2-incubating-all.zip
* Now you have the code ready to run




