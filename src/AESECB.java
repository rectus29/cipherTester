import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.net.URI;

public class AESECB {

	public static void main(String[] args) {
		System.out.println("Hello World!");

		try {
			String url = "/tdservices/download";
			String host = "localhost:8080";

			String key = "YnN5BFb1EZ6hD22+ZKRLEQ==";

			String fakeParam = ""
					+ "utk=&"
					+ "eml=(contact identifier)&"
					+ "wop=(1st random string)&"
					+ "iblChannel=(contact e-mail address)&"
					+ "filemd5=(2nd random string)&"
					+ "portal=WEB&"
					+ "token=WEB&"
					+ "watermark=WEB&"
					+ "firstname=WEB&"
					+ "lastname=WEB&"
					+ "company=WEB&"
					+ "checksum=WEB";
			String out = CipherTools.get().encrypt(fakeParam, key);

			//first request
			HttpClient httpClient = HttpClientBuilder.create().build();

			URIBuilder builder = new URIBuilder();
			builder.setScheme("http").setHost(host).setPath(url)
					.setParameter("q", out)
					.setParameter("file", "opop.po");
			URI uri = builder.build();

			HttpGet httpGet = new HttpGet(uri);
			//parse auth challenge
			HttpResponse firstResponse = httpClient.execute(httpGet);

			for (Header temp : firstResponse.getAllHeaders())
				System.out.println(temp.toString());
			firstResponse.getEntity().getContent().toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
