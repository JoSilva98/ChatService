package academy.mindswap.Modulo1.ChatService.Server.Commands;

import academy.mindswap.Modulo1.ChatService.Server.Server;

import java.util.Arrays;

public class HelpHandler implements CommandHandler {
    public void command(Server server, Server.ClientConnectionHandler client) {
        client.send(Arrays.stream(Command.values())
                .map(Command::getDESCRIPTION)
                .reduce("Command list: ", (a, b) -> a + "\n" + b));
    }
}
