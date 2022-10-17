package academy.mindswap.Modulo1.ChatService.Server.Commands;

import academy.mindswap.Modulo1.ChatService.Server.Server;

public class ListHandler implements CommandHandler {
    public void command(Server server, Server.ClientConnectionHandler client) {
        client.send("Clients list:" + server.listClients());
    }
}
