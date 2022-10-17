package academy.mindswap.Modulo1.ChatService.Server.Commands;

import academy.mindswap.Modulo1.ChatService.Server.Server;

public class ShoutHandler implements CommandHandler {
    public void command(Server server, Server.ClientConnectionHandler client) {
        String message = client.getMessage().split(" ", 2)[1].toUpperCase();
        server.broadcast(client.getNAME(), message);
        client.send(client.getNAME() + ": " + message);
    }
}
