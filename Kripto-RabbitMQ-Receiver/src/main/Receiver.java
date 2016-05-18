/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import java.io.IOException;
import java.security.PublicKey;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author akhfa
 */
public class Receiver {
    String host, username, password, vhost, exchange;
    PublicKey pubKey;
    public Receiver(PublicKey pubKey, String host, String username, String password, String vhost, String exchange)
    {
        this.pubKey = pubKey;
        this.host = host;
        this.username = username;
        this.password = password;
        this.vhost = vhost;
        this.exchange = exchange;
    }
    public void receive() throws IOException, TimeoutException
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(this.host);
        factory.setUsername(this.username);
        factory.setPassword(this.password);
        factory.setVirtualHost(this.vhost);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(this.exchange, "fanout");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, this.exchange, "");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
          @Override
          public void handleDelivery(String consumerTag, Envelope envelope,
                                     AMQP.BasicProperties properties, byte[] body) throws IOException {
              try {
                  String message = new String(body, "UTF-8");
                  JSONParser jparser = new JSONParser();
                  JSONObject jobj = (JSONObject) jparser.parse(message);
                  System.err.println(jobj.get("message"));
                  System.err.println(jobj.get("signature"));
//            System.out.println(" [x] Received '" + message + "'");
              } catch (ParseException ex) {
                  Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}
