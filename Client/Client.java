package academy.mindswap.Modulo1.ChatService.Client;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.start("localhost", 8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(String host, int port) throws IOException {
        Socket socket = new Socket(host, port);
        new Thread(new KeyboardHandler(socket)).start();
    }

    private static class KeyboardHandler implements Runnable {
        private final Socket SOCKET;
        BufferedReader consoleReader;
        BufferedReader br;
        BufferedWriter bw;

        KeyboardHandler(Socket socket) {
            this.SOCKET = socket;
            this.consoleReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            Thread readChat = new Thread(() -> {
                while (!this.SOCKET.isClosed()) {
                    try {
                        System.out.println(this.br.readLine());
                    } catch (IOException e) {
                        try {
                            System.out.println("You disconnected from chat");
                            this.SOCKET.close();
                            Thread.currentThread().interrupt();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });
            readChat.start();

            while (!this.SOCKET.isClosed()) {
                try {
                    String message = this.consoleReader.readLine();
                    this.bw.write(message);
                    this.bw.newLine();
                    this.bw.flush();

                    if (message.split(" ")[0].equals("/quit")) {
                        this.SOCKET.close();
                    }
                } catch (IOException e) {
                    System.out.println("You disconnected from chat");
                }
            }
        }
    }
}
