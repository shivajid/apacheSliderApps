package com.hortonworks.ambari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;
import java.util.Iterator;


public class ServerSocketListener implements Runnable {

	int portnum = 0;
	String host = null;
	private SocketChannel accept;

	public ServerSocketListener(int port, String host) {

		System.out.println("Initialized ..");
		setHostPort(host, port);
	}

	public void setHostPort(String Host, int Port) {

		this.host = host;
		this.portnum = Port;
	}

	@Override
	public void run() {
		
		ServerSocket soc = null;
		try {
			System.out.println("Hello port:  " + this.portnum);
			
			
			InetAddress addr = InetAddress.getByName(this.host);
			
			soc = new ServerSocket(this.portnum, 100, addr);
			System.out.println("Waiting..." );
			
			while(true){
			Socket clientSocket = soc.accept();
			
			System.out.println("Contacted..  " + (new java.util.Date()));
			
			PrintWriter out =
		        new PrintWriter(clientSocket.getOutputStream(), true);
			out.println("Hello Client");
			
		    String inputLine = null;
		    System.out.println("Step3:  " + this.portnum);
		    BufferedReader in = new BufferedReader(
			        new InputStreamReader(clientSocket.getInputStream()));

		    while ((inputLine = in.readLine()) != null) {
		    		System.out.println(inputLine);
		    		out.println(inputLine);
		    		if(inputLine.equalsIgnoreCase("Server: Bye"))
		    			break;
		    }
		    
		    clientSocket.close();
			}    
		}catch(Exception e){
			e.printStackTrace();
	}finally{
		try {
			soc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}	

}
