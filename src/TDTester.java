import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.net.URI;
import java.util.UUID;

public class TDTester {

	public static void main(String[] args) {
		System.out.println("Hello World!");

		try {
			String url = "/tdservices/download";
			String host = "localhost:8080";

			String key = "YnN5BFb1EZ6hD22+ZKRLEQ==";

			String fakeParam = ""
                    + "utk=" + RandomStringUtils.randomAlphabetic(10) + "&"
                    + "eml=" + RandomStringUtils.randomAlphabetic(16) + "&"
                    + "wop=" + RandomStringUtils.randomAlphabetic(16) + "&"
                    + "iblChannel=" + "WEB" + "&"
                    + "filemd5=2be6faf9c9dcf390a281c879a72bb154a306c37c&"
                    + "portal=WEB&"
                    + "token=" + RandomStringUtils.randomAlphabetic(16) + "&"
                    + "watermark=true&"
                    + "firstname=" + RandomStringUtils.randomAlphabetic(10) + "&"
                    + "lastname=" + RandomStringUtils.randomAlphabetic(10) + "&"
                    + "company=" + RandomStringUtils.randomAlphabetic(10) + "&"
                    + "healthcheck=" + "true" + "&"
                    + "checksum=REZREZREZREZREZREZREZREZ";
			String out = CipherTools.get().encrypt(fakeParam, key);
            Object ori = CipherTools.get().decrypt(out, key);
            String hmacSha1 = new String(HmacSha1.hash(key,out));

            System.out.println(out);
            System.out.println(hmacSha1);

            //first request
			HttpClient httpClient = HttpClientBuilder.create().build();

			URIBuilder builder = new URIBuilder();
			builder.setScheme("http").setHost(host).setPath(url)
					.setParameter("q", hmacSha1 + out)
					.setParameter("file", "0987654321.pdf");
			URI uri = builder.build();
            System.out.println(uri.toString());

		/*	HttpGet httpGet = new HttpGet(uri);
			//parse auth challenge
			HttpResponse firstResponse = httpClient.execute(httpGet);

			for (Header temp : firstResponse.getAllHeaders())
				System.out.println(temp.toString());
			firstResponse.getEntity().getContent().toString();
*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
