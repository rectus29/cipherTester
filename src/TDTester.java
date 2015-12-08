import com.edeal.trackingserver.tools.AESCipherTools;
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
			String url = "/tdservices/mail";
			String host = "localhost:8080";

			String key = "uejhe064gnex8o0l4Gp2Lg==";

			String fakeParam = ""
                    + "rtk=" + RandomStringUtils.randomAlphabetic(10) + "&"
                    + "rm=" + RandomStringUtils.randomAlphabetic(16) + "&"
                    + "rc=" + RandomStringUtils.randomAlphabetic(16) + "&"
                    + "did=" + RandomStringUtils.randomAlphabetic(16) + "&"
                    + "ls=" + RandomStringUtils.randomAlphabetic(16) + "&"

                    ;
			String out = AESCipherTools.get().encrypt(fakeParam, key);
            Object ori = AESCipherTools.get().decrypt(out, key);
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
