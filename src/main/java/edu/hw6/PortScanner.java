package edu.hw6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"hideutilityclassconstructor", "uncommentedmain", "magicnumber", "multiplestringliterals"})
public class PortScanner {
    private static final int MIN_PORT = 0;
    private static final int MAX_PORT = 49151;
    private static final String FORMAT = "%-10s%-10s%-50s%n";

    public static void main(String[] args) {
        var tsPorts = getKnownTSPorts();
        var udPorts = getKnownUDPorts();
        System.out.format(FORMAT, "Протокол", "Порт", "Сервис");
        for (int port = MIN_PORT; port <= MAX_PORT; port++) {
            if (!isTSPAvailable(port)) {
                System.out.format(
                    FORMAT,
                    "TSP",
                    port,
                    (tsPorts.get(port) == null ? "" : tsPorts.get(port))
                );
            }
            if (!isUDPAvailable(port)) {
                System.out.format(
                    FORMAT,
                    "UDP",
                    port,
                    (udPorts.get(port) == null ? "" : udPorts.get(port))
                );
            }
        }
    }

    private static boolean isTSPAvailable(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static boolean isUDPAvailable(int port) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(port);
            datagramSocket.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static Map<Integer, String> getKnownUDPorts() {
        Map<Integer, String> knownPorts = new HashMap<>();
        knownPorts.put(137, "Служба имен NetBIOS");
        knownPorts.put(138, "Служба датаграмм NetBIOS");
        knownPorts.put(1900, "Simple Service Discovery Protocol (SSDP)");
        knownPorts.put(3702, "Динамическое обнаружение веб-служб");
        knownPorts.put(5050, "");
        knownPorts.put(5353, "Многоадресный DNS");
        knownPorts.put(5355, "Link-Local Multicast Name Resolution (LLMNR)");
        knownPorts.put(17500, "Dropbox");
        knownPorts.put(42420, "");
        return knownPorts;
    }

    private static Map<Integer, String> getKnownTSPorts() {
        Map<Integer, String> knownPorts = new HashMap<>();
        knownPorts.put(135, "EPMAP");
        knownPorts.put(139, "Служба сеансов NetBIOS");
        knownPorts.put(445, "Microsoft-DS Active Directory");
        knownPorts.put(843, "Adobe Flash");
        knownPorts.put(5040, "");
        knownPorts.put(5939, "");
        knownPorts.put(6463, "");
        knownPorts.put(6942, "");
        knownPorts.put(17500, "Dropbox");
        knownPorts.put(17600, "");
        knownPorts.put(27017, "MongoDB");
        return knownPorts;
    }
}
