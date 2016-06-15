import com.edeal.trackingserver.tools.AESCipherTools;
import com.edeal.trackingserver.tools.HmacSha1;

import java.net.URLEncoder;

public class TDFiller {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        //for (int i = 0; i < 20; i++) {
            try {
                String url = "tdclient/external/download";
                String host = "http://127.0.0.1:8081/";

                String key = "znWxSX8JszSEPESYs67wtg==";

                String str8 = "aaaaaaaa";//RandomStringUtils.randomAlphabetic(8);
                String str10 = "aaaaaaaaaa";//RandomStringUtils.randomAlphabetic(10);
                String str16 = "aaaaaaaaaaaaaa";//RandomStringUtils.randomAlphabetic(16);

                String fakeParam = ""
                        + "utk=" + str8 + "&"
                        + "eml=" + "MORNING1234.pdf" + "&"
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

				System.out.println(hmacSha1);
				System.out.println(out);

                //first request
                //HttpClient httpClient = HttpClientBuilder.create().build();

                System.out.println(host + url + "?q=" + URLEncoder.encode("1" + hmacSha1 + out, "UTF-8"));

				AESCipherTools.decrypt(out, key);

				//byte[] out =  new BaseDecryptor().process(hmacSha1 + out);
   /*             URIBuilder builder = new URIBuilder();
                builder.setScheme("http").setHost(host).setPath(url)
                        .setParameter("q", "1" + hmacSha1 + out);
                URI uri = builder.build();
                System.out.println(uri.toString());
*/
             /*   HttpGet httpGet = new HttpGet(host + url + "?q=" + URLEncoder.encode("1" + hmacSha1 + out));
                //parse auth challenge
                HttpResponse firstResponse = httpClient.execute(httpGet);

                for (Header temp : firstResponse.getAllHeaders())
                    System.out.println(temp.toString());
                firstResponse.getEntity().getContent().toString();
*/
            } catch (Exception e) {
                e.printStackTrace();
            }

        //}
    }

}
