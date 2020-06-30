package vn.yinx.autodeploy.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class HttpUtils {
//	public static void sendPost(String url, String api_key, File image) {
//		URL obj = new URL(requestInfo.getUrl());
//		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//		con.setRequestMethod(requestInfo.getMethod());
//		con.setDoOutput(true);
//		OutputStream os = con.getOutputStream();
//		os.write(result.toJSONString().getBytes("UTF-8"));
//		os.flush();
//		os.close();
//		int responseCode = con.getResponseCode();
//		System.out.println("POST Response Code : " + responseCode);
//		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
//		String inputLine;
//		StringBuilder sb = new StringBuilder();
//		while ((inputLine = in.readLine()) != null) {
//			sb.append(inputLine);
//		}
//		in.close();
//		System.out.println(sb.toString());
//	}
	public static JSONObject sendFile(String url, String apiKey, File uploadFile) throws Exception {
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("api_key", apiKey);
		FileBody uploadFilePart = new FileBody(uploadFile);
		MultipartEntity reqEntity = new MultipartEntity();
		reqEntity.addPart("image", uploadFilePart);
		httpPost.setEntity(reqEntity);
		HttpResponse response = httpclient.execute(httpPost);
		InputStream is = response.getEntity().getContent();
		BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String inputLine;
		StringBuilder sb = new StringBuilder();
		while ((inputLine = in.readLine()) != null) {
		sb.append(inputLine);
		}
		in.close();
		JSONParser parser = new JSONParser();
		return (JSONObject) parser.parse(sb.toString());
	}
}
