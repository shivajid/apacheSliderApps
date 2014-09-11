Adding Apache Slider on CentOS with HDP 2.1
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
* git clone https://git-wip-us.apache.org/repos/asf/incubator-s
* cd incubator-status
* git status
* mvn clean site:site stage:stage package -DskipTests

'At this point the slider application is built.'.

The tar file is generated. It is located under
incubator-slider/slider-assembly/target



