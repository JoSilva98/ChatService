package academy.mindswap.Modulo1.ChatService.Server.Commands;

import academy.mindswap.Modulo1.ChatService.Server.Server;

public interface CommandHandler {
    void command(Server server, Server.ClientConnectionHandler client);
}
