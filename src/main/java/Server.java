

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Server {
    int count = 1;
    private int port;
     ArrayList<ClientThread> socketList = new ArrayList<>();
    private ConnThread connthread;
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

//    public int getPlayerNum(){
//        return this.connthread.socketList.size();
//    }


    public class ConnThread extends Thread{




        public void run() {
            try(ServerSocket mysocket = new ServerSocket(5555);){
                System.out.println("Server is waiting for a client!");
                while(true) {

                    ClientThread c = new ClientThread(mysocket.accept(), count);
                    callback.accept("client has connected to server: " + "client #" + count);
                    socketList.add(c);
                    c.start();

                    count++;

                }
            }
            catch(Exception e) {
                callback.accept("Server socket did not launch");
            }
        }
    }

    public class ClientThread extends Thread {
        Socket connection;
        int count;
        ObjectInputStream in;
        ObjectOutputStream out;

        ClientThread(Socket s, int count){
            this.connection = s;
            this.count = count;
        }

        public void updateClients(String message) {
            for(int i = 0; i < socketList.size(); i++) {
                ClientThread t = socketList.get(i);
                try {
                    t.out.writeObject(message);
                }
                catch(Exception e) {}
            }
        }

        public void run(){

            try {
                in = new ObjectInputStream(connection.getInputStream());
                out = new ObjectOutputStream(connection.getOutputStream());
                connection.setTcpNoDelay(true);
            }
            catch(Exception e) {
                System.out.println("Streams not open");
            }

            updateClients("new client on server: client #"+count);

            while(true) {
                try {
                    String data = in.readObject().toString();
                    callback.accept("client: " + count + " sent: " + data);
                    updateClients("client #"+count+" said: "+data);

                }
                catch(Exception e) {
                    callback.accept("OOOOPPs...Something wrong with the socket from client: " + count + "....closing down!");
                    updateClients("Client #"+count+" has left the server!");
                    socketList.remove(this);
                    break;
                }
            }
        }//end of run
    }

}
