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

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Client {
    private static final String EXCHANGE_NAME = "logs";
    
    public static void main(String[] argv) throws Exception {
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
                        channel.queueDeclare(com[1], true, false, false, null);
                        nick = com[1];
                        System.out.println(com[1]);

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
                        break;
                    case "/JOIN": 
                        channel.exchangeDeclare(com[1], "fanout");
                        channel.queueBind(nick, com[1], "");
                        break;
                    case "/LEAVE": 
      //                  System.out.println(client.greet(client.token, command));
      //                  delElement(client.list, com[1]);
                        break;
                    case "/EXIT":
                        System.exit(0);
                    default:
                        //send message to a channel
      //                  System.out.println(client.greet(client.token, command));
                        channel.basicPublish(com[0].substring(1), "", null, com[1].getBytes("UTF-8"));
                        break;
                }
            } catch (Exception e) {
                if (command.compareTo("/NICK") == 0) {
                    //random nick
                    String random = randomNick();
                    channel.queueDeclare(random, true, false, false, null);
                    System.out.println("Your nickname is " + random);
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
  
//  private String regNick(String token, String nick) {
//          if (token.equals("") && nick != null) {
//              if (isNickExist(nick)) {
//                  //nick exists
//                  return "Nick exists. Please try another NICK!";
//              }
//              else {
//                  //if nick doesn't exist
//                  nick = saveNick(nick);
//                  return nick;
//              }
//          }
//          else if (token.equals("") && nick == null) {
//              String newNick = "";
//              do {
//                  newNick = randomNick();
//              } while (isNickExist(newNick));
//              //save nick
//              saveNick(nick);
//              return newNick;
//          }
//          else {
//              //already registered
//              return "Nick already registered. Your nick is " + nick;
//          }
//      }
//}
