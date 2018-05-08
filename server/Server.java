package server;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.List;
import java.util.ArrayList;

final class Server {
	
	public static void main(String[] args) throws Exception {
		
		final int PORT = 9999;
		final List<Client> clients = new ArrayList<>();
		

		Client client_1 = new Client("songoku", "1234");
		Client client_2 = new Client("vegeta", "4321");
		clients.add(client_1);
		clients.add(client_2);
		
		

		ServerSocket socket = new ServerSocket(PORT);
		Socket client = null;

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("Server now closed.");
				try { socket.close(); }
				catch (Exception e) { }
			}
		});
		
		
		System.out.println("Server is accepting connections at " + PORT);
		
		while (true) {
			JSONObject request, serverAnswer;
			try {
				
			client = socket.accept();
			
			// Receive Request from Client
			DataInputStream ois = new DataInputStream(client.getInputStream());
			int lengh = ois.readInt();
			byte[] message = new byte[lengh];
			ois.readFully(message, 0, lengh);
						
			request = new JSONObject(new String(message));
			System.out.println("Received: " + request);
		
			serverAnswer = new JSONObject();
			int requestTypeString;
			try {
				requestTypeString = request.getInt(NetworkKey.REQUEST_TYPE.toString());
				UserRequest userRequest = UserRequest.values()[requestTypeString];
				
				switch (userRequest) {
					case LOGIN:
						 serverAnswer = Client_login(request, clients);
						break;
					default:
						System.out.println("Não funcionou");
						break;
				}
			
			
			 //Send Reply to Client
			 byte[] reply = serverAnswer.toString().getBytes();
	         DataOutputStream oos = new DataOutputStream(client.getOutputStream());
	         oos.writeInt(reply.length);
	         oos.write(reply);
					
			
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (client != null) {
					try { client.close(); }
					catch (Exception e) {}
				}
			}
		}
	}


	private static JSONObject Client_login(JSONObject request , List<Client> clients) throws JSONException {
		JSONObject serverAnswer = new JSONObject();
		String username = request.getString( NetworkKey.USERNAME.toString());
		String password = request.getString( NetworkKey.PASSWORD.toString());
		
		for(Client client : clients) {
			if ( client.compareusername(username)) {
					if (client.comparepassword(password)) {
						// Login Efectuado
						ServerReply serverReply = ServerReply.SUCESS;
						serverAnswer.put(NetworkKey.REPLY_TYPE.toString(), serverReply.ordinal());
						System.out.println("Login Conseguido por " + username + " e a sua pass e" + password );
						return serverAnswer;
						}
					
					// Password Incorrecta
					ServerReply serverReply = ServerReply.WRONG_PASS;
					serverAnswer.put(NetworkKey.REPLY_TYPE.toString(), serverReply.ordinal());
					System.out.println("Login tentado por " + username + " mas a sua pass está incorrecta : " + password );
					return serverAnswer;
			}
		}
		// Username nao existe
		ServerReply serverReply = ServerReply.WRONG_USER;
		serverAnswer.put(NetworkKey.REPLY_TYPE.toString(), serverReply.ordinal());
		System.out.println(" Login tentado mas o username nao existe " );
		return serverAnswer;
		
	}	
}
