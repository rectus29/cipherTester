import com.edeal.trackingserver.tools.AESCipherTools;
import com.edeal.trackingserver.tools.HmacSha1;
import org.restlet.data.Parameter;
import org.restlet.resource.ClientResource;

import java.net.URLEncoder;

public class TDFiller {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        for (int i = 0; i < 9; i++) {
            try {
                String url = "tdclient/external/download";
                String host = "http://127.0.0.1:8080/";

                String key = "znWxSX8JszSEPESYs67wtg==";

                String str8 = "aaaaaaaa";//RandomStringUtils.randomAlphabetic(8);
                String str10 = "aaaaaaaaaa";//RandomStringUtils.randomAlphabetic(10);
                String str16 = "aaaaaaaaaaaaaaaa";//RandomStringUtils.randomAlphabetic(16);

                String fakeParam = ""
                        + "utk=" + str8 + "&"
                        + "eml=" + "test"+i+".pdf" + "&"
                        //+ "eml=" + "theorique-m-d5f705498b8665c7184cd3936f90a302.png" + "&"
                        + "wop=" + str16 + "&"
                        + "iblChannel=" + "WEB" + "&"
                        + "portal=WEB&"
                        + "token=" + str16 + "&"
                        + "watermark&"
                        + "firstname=" + str10 + "&"
                        + "lastname=" + str10 + "&"
                        + "company=" + str10 + "&"
						+ "extraData=" + "plop";
				String out = AESCipherTools.encrypt(fakeParam, key);
                String hmacSha1 = new String(HmacSha1.hash(key, out));

				ClientResource resource = new ClientResource(host + url );
				resource.addQueryParameter(new Parameter("q", "1" + hmacSha1 + out));
				//resource.get();
                System.out.println(i + " -  " + host + url + "?q=" + URLEncoder.encode("1" + hmacSha1 + out,
						"UTF-8"));

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
