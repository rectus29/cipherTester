import com.edeal.trackingserver.tools.AESCipherTools;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.shiro.crypto.AesCipherService;

import java.net.URI;
import java.util.Date;
import java.util.UUID;

public class AES128 {

    public static void main(String[] args) {
        Date start = new Date();
        System.out.println(new Date().getTime() + "Hello World!");

        try {
            String key = "YnN5BFb1EZ6hD22+ZKRLEQ==";



            for (int i = 0; i < 10000; i++) {
                String fakeParam = ""
                        + "utk=" + UUID.randomUUID().toString() + "&"
                        + "eml=" + "documentID" + "&"
                        + "wop=" + RandomStringUtils.randomAlphabetic(10) + "&"
                        + "iblChannel=" + RandomStringUtils.randomAlphabetic(25) + "&"
                        + "filemd5=(2nd random string)&"
                        + "portal=WEB&"
                        + "token=" + RandomStringUtils.randomAlphabetic(10) + "&"
                        + "watermark=true&"
                        + "firstname=" + RandomStringUtils.randomAlphabetic(10) + "&"
                        + "lastname=" + RandomStringUtils.randomAlphabetic(10) + "&"
                        + "company=BP2S&"
                        + "checksum=REZREZREZREZREZREZREZREZ";
                System.out.println(AESCipherTools.get().encrypt(fakeParam, key));
            }

            System.out.println("start -> " + start.getTime());
            System.out.println("stop -> " +  -(start.getTime()  - new Date().getTime()));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
