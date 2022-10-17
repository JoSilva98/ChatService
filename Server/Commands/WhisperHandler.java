package academy.mindswap.Modulo1.ChatService.Server.Commands;

import academy.mindswap.Modulo1.ChatService.Helpers;
import academy.mindswap.Modulo1.ChatService.Server.Server;

import java.util.Optional;

public class WhisperHandler implements CommandHandler {
    public void command(Server server, Server.ClientConnectionHandler client) {
        String[] splitMessage = client.getMessage().split(" ");
        String message = "";
        String receiverName = "";

        if (splitMessage.length > 2) {
            if (splitMessage[1].equalsIgnoreCase("client") && splitMessage.length > 3) {
                splitMessage = client.getMessage().split(" ", 4);
                receiverName = splitMessage[1] + splitMessage[2];
                message = splitMessage[3];
            } else {
                splitMessage = client.getMessage().split(" ", 3);
                message = splitMessage[2];
                receiverName = splitMessage[1];
            }
        }

        Optional<Server.ClientConnectionHandler> receiver = server.getClientByName(receiverName);

        if (receiver.isPresent() && !Helpers.compareIfNamesMatch(client.getNAME(), receiverName)) {
            receiver.get().send(client.getNAME() + " (whisper): " + message);
        } else {
            client.send("Message couldn't be send");
        }
    }
}
