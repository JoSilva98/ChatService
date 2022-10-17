# Chat Service
___
Chat service that allows conversation of multiple clients.

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
<br/><br/>

## Chat
___
When a client connects to the chat the server it's name will be **CLIENT + ordinal number**, and
it's showened on both server and client side the clients who connected:

#### Server side:
```
CLIENT 1: joined the chat
CLIENT 2: joined the chat
CLIENT 3: joined the chat
```

#### Client Side (CLIENT 1):
```
CLIENT 2: joined the chat
CLIENT 3: joined the chat
```
<br/>
When a client sends a message it will be delivered to everyone in the chat:

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
<br/>

## Commands
___
There are some allowed commands that every client can use by typing **/ + command name**.

Command list:
* **List** (/list) - Shows a list of all clients online (only the client who typed this command can see the list);
___
#### CLIENT 1:
```
/list
Clients list:
CLIENT 1
CLIENT 2
CLIENT 3
```
<br/>

* **Help** (/help) - Shows a list of the available commands (only the client who typed this command can see the list); 
___
#### CLIENT 1:
```
Command list:
/list
/help
/whisper
/quit
/shout
```
<br/>

* **Whisper** (/whisper) - Allows a client to send a message to a single client;
___
#### CLIENT 1:
```
/whisper CLIENT 2 Hello friend!
```

#### CLIENT 2:
```
CLIENT 1 (whisper): Hello friend!
```
<br/>

* **Quit** (/quit) - Quits the chat;
___
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
<br/>

* **Shout** (/shout) - Converts a client's messasge to uppercase.
___
#### CLIENT 2:
```
/shout Hello friends
```

#### CLIENT 3:
```
CLIENT 2: HELLO FRIENDS
```
<br/>

### Structure:
___
The chat contains:
* **Server** class - receives the clients' messages and sends them back all the online 
clients;
* **Client** class - allows each client to connect and send messages;
* **Commands** package - contains the **Command** classes that each client can use 
(**List**, **Help**, **Whisper**, **Quit** and **Shout**).