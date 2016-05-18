/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.concurrent.TimeoutException;
import org.json.simple.JSONObject;
import sun.misc.BASE64Encoder;

/**
 *
 * @author akhfa
 */
public class Sender {
    PrivateKey privKey;
    String host, username, password, vhost, exchange;
    public Sender(PrivateKey privKey, String host, String username, String password, String vhost, String exchange)
    {
        this.privKey = privKey;
        this.host = host;
        this.username = username;
        this.password = password;
        this.vhost = vhost;
        this.exchange = exchange;
    }
    public void sendMessage(String message, String signature) throws IOException, TimeoutException, NoSuchAlgorithmException, InvalidKeyException, SignatureException
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(this.host);
        factory.setUsername(this.username);
        factory.setPassword(this.password);
        factory.setVirtualHost(this.vhost);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(this.exchange, "fanout");

        JSONObject jobject = new JSONObject();
        jobject.put("message", message);
        jobject.put("signature", signature);
        
        System.out.println(jobject.toJSONString());
        channel.basicPublish(this.exchange, "", null, jobject.toJSONString().getBytes("UTF-8"));

        channel.close();
        connection.close();
    }
    
}
