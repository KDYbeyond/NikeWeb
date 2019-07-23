package com.nike;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Login {
  private static final String url = "https://unite.nike.com/login?appVersion=620&experienceVersion=518&uxid=com.nike.commerce.nikedotcom.web&locale=zh_CN&backendEnvironment=identity&browser=&os=Windows%20NT%2010.0%3B%20Win64%3B%20x64&mobile=true&native=false&visit=1&visitor=8cd9d905-4fc7-49fc-8c39-787c776c3f3f";
  
  private static String postMeathd() throws ClientProtocolException, IOException{
	  CloseableHttpClient httpClient = HttpClients.createDefault();
	  HttpPost httpPost = new HttpPost(url);
	  httpPost.addHeader("Host", "analytics.nike.com");
	  httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:68.0) Gecko/20100101 Firefox/68.0");
	  httpPost.addHeader("Accept", "*/*");
	  httpPost.addHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
	  httpPost.addHeader("Accept-Encoding", "gzip, deflate, br");
	  httpPost.addHeader("Content-Type", "application/json");
	  httpPost.addHeader("Authorization", "Basic MjY3Ymo3M085Wm15WlEyTFVNVmdBY0xrMHE1QmllSnU6");
	  httpPost.addHeader("Origin", "https://store.nike.com");
	  httpPost.addHeader("Connection", "keep-alive");
	  httpPost.addHeader("Referer", "https://store.nike.com/cn/zh_cn/?cp=cnns_sz_071516_a_ALNUL_bz01&utm_source=Bd&utm_medium=Pcbz&utm_content=title");
	  List<NameValuePair> content = new ArrayList<>();
	  content.add(new BasicNameValuePair("username", "haolei@borteem.com"));
	  content.add(new BasicNameValuePair("password", "Aa09B16ZufV"));
	  content.add(new BasicNameValuePair("grant_type", "password"));
	  UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(content,"UTF-8");
	  httpPost.setEntity(encodedFormEntity);
	  CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
	  System.out.println(httpResponse.toString());
	  HttpEntity httpEntity = httpResponse.getEntity();
	  String result = EntityUtils.toString(httpEntity);
	  return result;
  }
  public static void main(String[] args) throws ClientProtocolException, IOException {
	 System.out.println(postMeathd());
}
}

