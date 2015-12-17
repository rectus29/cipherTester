import com.edeal.trackingserver.tools.AESCipherTools;
import org.apache.commons.lang3.RandomStringUtils;
import org.restlet.data.Parameter;
import org.restlet.resource.ClientResource;

public class TDTester {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        for (int i = 0; i < 20; i++) {
            try {
                String url = "tdservices/open/pic.gif";
                String host = "http://127.0.0.1:8282/";
                String key = "uejhe064gnex8o0l4Gp2Lg==";
                String fakeParam = ""
                        + "recipienttoken=" + RandomStringUtils.randomAlphabetic(10) + "&"
                        + "recipientmail=" + RandomStringUtils.randomAlphabetic(16) + "&"
                        + "recipientcookie=" + RandomStringUtils.randomAlphabetic(16) + "&"
                        + "documentid=" + RandomStringUtils.randomAlphabetic(16) + "&"
                        + "logstatus=" + RandomStringUtils.randomAlphabetic(16);
                String out = AESCipherTools.encrypt(fakeParam, key);
                String hmacSha1 = new String(HmacSha1.hash(key, out));

                ClientResource resource = new ClientResource(host + url);
                resource.addQueryParameter(new Parameter("q", "1" + hmacSha1 + out));
                resource = AESCipherTools.DigestResolution(resource);
                resource.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
