package academy.mindswap.Modulo1.ChatService.Server;

import java.io.IOException;

public class ServerLauncher {
    public static void main(String[] args) {
        Server server = new Server();

        try {
            server.start(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
