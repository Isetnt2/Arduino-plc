/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package plc;

import com.fazecast.jSerialComm.SerialPort;
import java.io.IOException;

/**
 *
 * @author isak.ahlberg
 */
public class PLC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
	// TODO code application logic here
	SerialPort comPort = SerialPort.getCommPorts()[4];
	comPort.setComPortParameters(9600, 8, 1, 0);
	comPort.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
	if (comPort.openPort()) {
	    System.out.println("Port is open :)");
	} else {
	    System.out.println("Failed to open port :(");
	    return;
	}
	for (int i = 0; i < 5; ++i) {
	    comPort.getOutputStream().write(i);
	    comPort.getOutputStream().flush();
	    System.out.println("Sent number: " + i);
	    Thread.sleep(1000);
	}
	if (comPort.closePort()) {
	    System.out.println("Port is closed :)");
	} else {
	    System.out.println("Failed to close port :(");
	    return;
	}
    }

}
