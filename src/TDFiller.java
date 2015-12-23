import com.edeal.trackingserver.tools.AESCipherTools;
import com.edeal.trackingserver.tools.HmacSha1;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.net.URI;
import java.net.URLEncoder;

public class TDFiller {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        for (int i = 0; i < 20; i++) {
            try {
                String url = "tdservices/download";
                String host = "http://127.0.0.1:8080/";

                String key = "YnN5BFb1EZ6hD22+ZKRLEQ==";

                String str10 = RandomStringUtils.randomAlphabetic(10);
                String str16 = RandomStringUtils.randomAlphabetic(16);

                String fakeParam = ""
                        + "utk=" + str10 + "&"
                        + "eml=" + "test.pdf" + "&"
                        + "wop=" + str16 + "&"
                        + "iblChannel=" + "WEB" + "&"
                        + "portal=WEB&"
                        + "token=" + str16 + "&"
                        + "watermark=true&"
                        + "firstname=" + str10 + "&"
                        + "lastname=" + str10 + "&"
                        + "company=" + str10;
                String out = AESCipherTools.encrypt(fakeParam, key);
                String hmacSha1 = new String(HmacSha1.hash(key, out));

                System.out.println(out);
                System.out.println(hmacSha1);

                //first request
                HttpClient httpClient = HttpClientBuilder.create().build();

                System.out.println(host + url + "?q=" + URLEncoder.encode("1" + hmacSha1 + out));
   /*             URIBuilder builder = new URIBuilder();
                builder.setScheme("http").setHost(host).setPath(url)
                        .setParameter("q", "1" + hmacSha1 + out);
                URI uri = builder.build();
                System.out.println(uri.toString());

                HttpGet httpGet = new HttpGet(uri);
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

}
