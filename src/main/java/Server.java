

import java.io.Serializable;
import java.net.ServerSocket;
import java.util.function.Consumer;

public class Server {
    int count = 1;
    private static ServerSocket socket;
    private static int port;
    private Consumer<Serializable> callback;

    Server(int port, Consumer<Serializable> callback) {
        this.callback = callback;
        this.port = port;
    }


    protected String getIP() {
        return null;
    }

    protected int getPort() {
        return port;
    }
    static void setport(int value){
        port = value;
    }
        public void run() {
            try(ServerSocket mysocket = new ServerSocket(5555);){
                socket = mysocket;
                System.out.println("Server is waiting for a client!");
                while(true) {

                    //ClientThread c = new ClientThread(mysocket.accept(), count);
                    callback.accept("client has connected to server: " + "client #" + count);
                    //socketList.add(c);
                    //c.start();

                    count++;

                }
            }
            catch(Exception e) {
                callback.accept("Server socket did not launch");
            }
        }








}
