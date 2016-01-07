import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");


		long date = new Date().getTime();
		System.out.println(date);
		Date date1 = new Date();
		date1.setTime(date);
		System.out.println(date1);


//        try {
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            String url = "/tdservices/download";
//            String host = "http://localhost:8282";
//            //first request
//            HttpClient httpClient = HttpClientBuilder.create().build();
//            HttpGet httpGet = new HttpGet(host + url);
//
//            //parse auth challenge
//            HttpResponse firstResponse = httpClient.execute(httpGet);
//            String authString = firstResponse.getHeaders("WWW-Authenticate")[0].toString();
//            Pattern r = Pattern.compile("qop=\"(.*?)\"", Pattern.DOTALL);
//            Matcher m = r.matcher(authString);
//
//
//            String qop = null;
//            if (m.find()) {
//                qop = m.group(1);
//            }
//            r = Pattern.compile("nonce=\"(.*?)\"", Pattern.DOTALL);
//            m = r.matcher(authString);
//            String nonce = null;
//            if (m.find()) {
//                nonce = m.group(1);
//            }
//            r = Pattern.compile("opaque=\"(.*?)\"", Pattern.DOTALL);
//            m = r.matcher(authString);
//            String opaque = null;
//            if (m.find()) {
//                opaque = m.group(1);
//            }
//            String nc = "00000001";
//            String cnonce = "0a4f113b";
//
//            //build response
//            String HA1 = (DigestUtils.md5Hex("edeal:EdealTD:7e32fc4e4e747e6eef2c8215613d61f7"));
//            System.out.println(HA1);
//            String HA2 = (DigestUtils.md5Hex("GET:" + url));
//            System.out.println(HA2);
//            String response = (DigestUtils.md5Hex(((HA1 + ":" + nonce + ":" + nc + ":" + cnonce + ":" + qop + ":" + HA2))));
//            System.out.println(response);
//            HttpGet http2Get = new HttpGet(host + url);
//
//            http2Get.setHeader("Authorization", "Digest username=\"edeal\"," +
//                            "realm=\"" + "EdealTD" + "\"," +
//                            "nonce=\"" + nonce + "\"," +
//                            "uri=\"" + url + "\"," +
//                            "qop=\"" + qop + "\"," +
//                            "nc=\"" + nc + "\"," +
//                            "cnonce=\"" + cnonce + "\"," +
//                            "response=\"" + response + "\"," +
//                            "opaque=\"" + opaque + "\""
//            );
//            firstResponse = httpClient.execute(http2Get);
//            System.out.println(firstResponse.getStatusLine().getStatusCode());
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}
