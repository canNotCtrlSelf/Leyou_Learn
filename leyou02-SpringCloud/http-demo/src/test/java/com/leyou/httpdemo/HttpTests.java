package com.leyou.httpdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leyou.httpdemo.pojo.User;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class HttpTests {

    CloseableHttpClient httpClient;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Before
    public void init() {
        httpClient = HttpClients.createDefault();
    }

    @Test
    public void testGet() throws IOException {
        //HttpGet request = new HttpGet("http://www.baidu.com");
        HttpGet request = new HttpGet("http://www.baidu.com/s?ie=UTF-8&wd=java");
        String response = this.httpClient.execute(request, new BasicResponseHandler());
        System.out.println(response);
    }

    @Test
    public void testPost() throws IOException {
        HttpPost request = new HttpPost("https://www.oschina.net/search?scope=project&q=jdbc");
        request.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        String response = this.httpClient.execute(request, new BasicResponseHandler());
        System.out.println(response);
    }

    @Test
    public void testGetPojo() throws IOException {
        HttpGet request = new HttpGet("http://localhost:9090/user/hello/45");
        String response = this.httpClient.execute(request, new BasicResponseHandler());
        System.out.println(response);
        User user = MAPPER.readValue(response, User.class);//使用ObjectMapper对字符串进行反序列化
        System.out.println(user);
        String string = MAPPER.writeValueAsString(user); //序列化
        System.out.println(string);
    }
}
