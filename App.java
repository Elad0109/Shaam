package com.Shaam.pages.my_first_system;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;


public class App 
{
    public static void main( String[] args ) throws ClientProtocolException, IOException
    {
    	CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(AuthScope.ANY,
                new NTCredentials("username", "passwd", "hostname", "domain"));


HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(credsProvider).build();

HttpPost post = new HttpPost("http://www.example.com");

StringEntity input = new StringEntity("bodyAsString", "HTTP.UTF_8");
input.setContentType("application/json");
input.setContentEncoding("UTF-8");
post.setEntity(input);

post.setHeader("Accept", "application/json");
post.setHeader("Content-type", "application/json");


HttpResponse response = client.execute(post);
    }
}
