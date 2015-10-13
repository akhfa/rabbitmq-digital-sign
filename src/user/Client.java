/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author akhfa
 */

import com.rabbitmq.client.*;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Client {
    
    private static String username = "akhfa";
    private static String password = "akhfa";
    
    public static void main(String[] argv) throws Exception 
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("62.210.78.203");
        factory.setUsername("akhfa");
        factory.setPassword("akhfa");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        String nick = "";

        while (true) {
            Scanner in = new Scanner(System.in);

            System.out.print("Please enter your command: ");
            String command = in.nextLine();

            String[] com = command.split(" ", 2);
            try {
                switch (com[0]) {
                    case "/NICK":
                        if(!nick.equals(""))
                        {
                            System.out.println("You have registered with nickname: " + nick);
                        }
                        else
                        {
                            ArrayList<String> daftarNick = getAllQueues();
                            
                            if (!daftarNick.contains(com[1])) {
                                channel.queueDeclare(com[1], false, false, true, null);
                                nick = com[1];
                                System.out.println("Your nickname is " + nick);

                                System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

                                Consumer consumer = new DefaultConsumer(channel) {
                                    @Override
                                    public void handleDelivery(String consumerTag, Envelope envelope,
                                                               AMQP.BasicProperties properties, byte[] body) throws IOException {
                                      String message = new String(body, "UTF-8");
                                      System.out.println("");
                                      System.out.println(" [x] Received '" + message + "'");
                                    }
                                  };
                                  channel.basicConsume(nick, true, consumer);
                            }
                            else {
                                System.out.println("Nickname exists.");
                            }
                        }
                        break;
                    case "/JOIN": 
                        channel.exchangeDeclare(com[1], "fanout", false, false, false, null);
                        channel.queueBind(nick, com[1], "");
                        break;
                    case "/LEAVE": 
                        channel.queueUnbind(nick, com[1], "");
                        break;
                    case "/EXIT":
                        System.exit(0);
                    default:
                        channel.basicPublish(com[0].substring(1), "", null, com[1].getBytes("UTF-8"));
                        break;
                }
            } catch (Exception e) {
                if (command.compareTo("/NICK") == 0) {
                    //random nick
                    String random;
                    
                    if(!nick.equals(""))
                    {
                        System.out.println("You have registered with nickname: " + nick);
                    }
                    else
                    {
                        ArrayList<String> daftarNick = getAllQueues();
                        
                        do{
                            random = randomNick();
                        }while(daftarNick.contains(random));

                        channel.queueDeclare(com[1], false, false, true, null);
                        System.out.println("Your nickname is " + random);

                        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

                        Consumer consumer = new DefaultConsumer(channel) {
                            @Override
                            public void handleDelivery(String consumerTag, Envelope envelope,
                                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                              String message = new String(body, "UTF-8");
                              System.out.println(" [x] Received '" + message + "'");
                            }
                          };
                          channel.basicConsume(nick, true, consumer);
                    }
                    
                }
                else if ((command.compareTo("/JOIN") == 0) || (command.compareTo("/LEAVE") == 0)) {
                    //error
                    System.out.println("Please enter channel name!");
                }
                else if (command.charAt(0) == '@') {
                    System.out.println("Please enter your command for the channel.");
                }
                else {
                    System.out.println("Invalid command.");
                }
            }
        }
    }
    
    private static boolean isExistQueue(String queueName) throws ParseException
    {
        String command = "curl " + username + ":" + password + "@62.210.78.203:15672/api/queues";
        String channelJSON = executeCommand(command);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(channelJSON);
        JSONArray array = (JSONArray) obj;
        
        boolean ketemu = false;
        int i = 0;
        while(!ketemu && i < array.size())
        {
            JSONObject json = (JSONObject) array.get(i);
            String name = (String) json.get("name");
            if(name.equals(queueName))
                ketemu = true;
            i++;
        }
        return ketemu;
    }
    
    private static ArrayList getAllQueues() throws ParseException
    {
        String command = "curl " + username + ":" + password + "@62.210.78.203:15672/api/queues";
        String channelJSON = executeCommand(command);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(channelJSON);
        JSONArray array = (JSONArray) obj;
        
        ArrayList<String> daftarArray = new ArrayList<>();
        
        for(int i = 0; i < array.size(); i++)
        {
            JSONObject json = (JSONObject) array.get(i);
            String name = (String) json.get("name");
            daftarArray.add(name);
        }
        return daftarArray;
    }
    
    private static String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = 
                            new BufferedReader(new InputStreamReader(p.getInputStream()));

                        String line = "";			
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}

    public static String randomNick() {
        String nick = "";
        String[] pool = {"Zacky", "Raddy", "Will", "Ohm", "Ary", "Ardee", "Ilma", "Khidr", "Galang", "Theo", "Tereta", "Rossi", 
            "Ivina", "Nicy", "Kiito"};
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100);
        int randomNick = randomGenerator.nextInt(15);

        nick = pool[randomNick].concat(Integer.toString(randomInt));
        return nick;
    }
}
