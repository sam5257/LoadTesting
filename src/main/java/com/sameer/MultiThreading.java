package com.sameer;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class MultiThreading implements Runnable {


    public void run() {
        try {


            String threadName = Thread.currentThread().getId()+"";

            String timeMillis= System.currentTimeMillis() + "";
            String result = "";
            HttpPost post = new HttpPost("http://localhost:8080/Cart/servlet/rest");

            StringBuilder json = new StringBuilder();
            json.append("{");
            json.append("\"firstName\":\"sameer\",");
            json.append("\"lastName\":\"" + timeMillis+ "\",");
            json.append("\"email\":\"sameer" + timeMillis + "@gmail.com\",");
            json.append("\"date\":\"1994-04-15\"");
            json.append("}");

            // send a JSON data
            post.setEntity(new StringEntity(json.toString()));

            try (CloseableHttpClient httpClient = HttpClients.createDefault();
                 CloseableHttpResponse response = httpClient.execute(post)) {

                result = EntityUtils.toString(response.getEntity());
            }

            System.out.println(result);


        } catch (Exception exception) {
            System.out.println(exception);
        }
    }


}
