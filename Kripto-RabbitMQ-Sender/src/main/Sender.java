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
    public void sendMessage(String message) throws IOException, TimeoutException, NoSuchAlgorithmException, InvalidKeyException, SignatureException
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("rabbitmq.akhfa.me");
        factory.setUsername("kripto");
        factory.setPassword("BuatKripto");
        factory.setVirtualHost("kripto");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(this.exchange, "fanout");

        // generate signed
        Signature sig = Signature.getInstance("MD5WithRSA");
        sig.initSign(this.privKey);
        sig.update(message.getBytes());
        
        byte[] signatureBytes = sig.sign();
        
        JSONObject jobject = new JSONObject();
        jobject.put("message", message);
        jobject.put("signature", new BASE64Encoder().encode(signatureBytes));
        
        System.out.println(jobject.toJSONString());
        channel.basicPublish(this.exchange, "", null, jobject.toJSONString().getBytes("UTF-8"));

        channel.close();
        connection.close();
    }
    
}