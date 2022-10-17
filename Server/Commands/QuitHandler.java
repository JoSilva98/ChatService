package academy.mindswap.Modulo1.ChatService.Server.Commands;

import academy.mindswap.Modulo1.ChatService.Server.Server;

public class QuitHandler implements CommandHandler {
    public void command(Server server, Server.ClientConnectionHandler client) {
        server.removeClient(client);
        client.close();
    }
}
