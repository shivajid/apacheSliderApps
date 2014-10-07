package com.hortonworks.ambari;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * This file reads the ports.properties file and starts the daemon for Ports
 * 
 * @author sdutta
 */

public class PortController {

	public static void main(String[] args) throws UnknownHostException,
			IOException {

        ArrayList<String> portList = new ArrayList<String>();
        try {
            Path p = FileSystems.getDefault().getPath("ports.properties");
            PortReader prt = new PortReader(p);
            System.out.println("Count :" + prt.getCount());
            portList = prt.getPortList();
        } catch (Exception e) {

            e.printStackTrace();
        }

        if (portList.size() == 0){
            portList.add("63999");
            portList.add("63997");
            portList.add("63998");
        }


		//int port = Integer.parseInt(args[0]);
		String hostname = "localhost";
		if(args.length > 0 && args[0] != null)
			  hostname= args[0];

		ServerSocketListener ssl = null;
		Iterator<String> itr = portList.iterator();
		int port = 0;
		while (itr.hasNext()) {
			port = Integer.parseInt(itr.next());
			
			System.out.println("Creating Server Port" + port);
			
			ssl = new ServerSocketListener(port, hostname);

			Thread t = new Thread(ssl);
			t.start();
			
		}

	}

}
