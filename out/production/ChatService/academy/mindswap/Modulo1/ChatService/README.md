# Chat Service

Chat service that allows conversation of multiple people.

The Server must be started then the Clients instances can connect to the server (enable multiple
instances running at the same time to use this program on a single machine).

The Server port is by default **8080**. You can change the port on the ServerLauncher class:

```Java
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
```

The Client is connecting to the host **Localhost** and to the port **8080** by default. You can
change both the parameters on the class Client:

```Java
public class Client {
public static void main(String[] args) {
        Client client = new Client();
        try {
            client.start("localhost", 8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  //...
}
```
**Note**: For all the examples I'm using 3 clients connected to the server (CLIENT 1, CLIENT 2 and CLIENT 3).

### Chat
When someone connects to the chat the server it's name will be **CLIENT + ordinal number**, and
it's showened on both server and client side the clients who connected:

#### Server side:
```
CLIENT 1: joined the chat
CLIENT 2: joined the chat
CLIENT 3: joined the chat
```

#### Client side:
#### CLIENT 1:
```
CLIENT 2: joined the chat
CLIENT 3: joined the chat
```

When a client sends a message it will be delievered to everyone in the chat:

#### CLIENT 1:
```
CLIENT 2: joined the chat
CLIENT 3: joined the chat
Hello World!
```

#### CLIENT 2:
```
CLIENT 3: joined the chat
CLIENT 1: Hello World!
```

#### CLIENT 3:
```
CLIENT 1: Hello World!
```

### Commands:
There are some allowed commands that every client can use by typing **/ + command name**.

Command list:
* **List** (/list) - Shows a list of all clients online (only the client who typed this command can see the list);

#### CLIENT 1:
```
/list
Clients list:
CLIENT 1
CLIENT 2
CLIENT 3
```

* **Help** (/help) - Shows a list of the available commands (only the client who typed this command can see the list); 

#### CLIENT 1:
```
Command list:
/list
/help
/whisper
/quit
/shout
```

* **Whisper** (/whisper) - Allows a client to send a message to a single client;

#### CLIENT 1:
```
/whisper CLIENT 2 Hello friend!
```

#### CLIENT 2:
```
CLIENT 1 (whisper): Hello friend!
```

* **Quit** (/quit) - Quits the chat;

#### CLIENT 1:
```
/quit
You disconnected from chat
```

#### CLIENT 2:
```
/list
Clients list:
CLIENT 2
CLIENT 3
```

* **Shout** (/shout) - Converts a client's messasge to uppercase.

#### CLIENT 2:
```
/shout Hello friends
```

#### CLIENT 3:
```
CLIENT 2: HELLO FRIENDS
```

### Structure:

The chat contains a Server class that orchestrates receives the people's messages and sends
them to everyone online, a Client class that allows each person to connect to the chat and a 
Commands package that contains the commands that each person can use.