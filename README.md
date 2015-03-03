**Introduction**

This is quick install and launch guide of a Socket Server via apache Slider.

**Socket Server**


This is a simple Java program that spawns 3 threads that listens on ports 63999, 63997 and 63998. The code is in the SocketServer port.

**Slider Package for Socket Server**

      |--Socket Server package
            |--files
                  |- SocketServer.tar
            |--scripts
                  |- params.py
                  |- socketserver.py
            |--templates
                  |-- 
            --appConfig.json
            --resources.json
   
**Package Socket Server**

From the root of the folder zip up the package
``
zip -r socketserver.zip *
``

**Install the package**

      su yarn
      /usr/hdp/current/slider-client/bin/./slider install-package --name SocketServer --package /tmp/socketserver.zip
      
In the above example I have kept my zip file in the `/tmp` folder

**Create the package**
      
``/usr/hdp/current/slider-client/bin/./slider create c3 --template appConfig.json --resources resources.json``

Above I am creating a new Instance with name *c3*. You can create an instance with any name.

**Check Status**

      /usr/hdp/current/slider-client/bin/./slider status c3
      
*You are done deloying a simple slider app!*

**You can use the Slider View to manage the lifecylce of this application**

Thanks :- Please give feedback to sdutta@hortonworks.com
