import org.restlet.Response;
import org.restlet.data.Parameter;
import org.restlet.engine.header.Header;
import org.restlet.resource.ClientResource;
import org.restlet.util.Series;

import java.util.ArrayList;

/*-----------------------------------------------------*/
/*      _____           _               ___   ___      */
/*     |  __ \         | |             |__ \ / _ \     */
/*     | |__) |___  ___| |_ _   _ ___     ) | (_) |    */
/*     |  _  // _ \/ __| __| | | / __|   / / \__, |    */
/*     | | \ \  __/ (__| |_| |_| \__ \  / /_   / /     */
/*     |_|  \_\___|\___|\__|\__,_|___/ |____| /_/      */
/*                                                     */
/*                Date: 23/12/2015 17:12                */
/*                 All right reserved                  */
/*-----------------------------------------------------*/
public class getlog {

	private static  String host = "http://127.0.0.1:8080/";

	public static void main(String[] parameters) {


		try {
			ArrayList<String> list = new ArrayList<String>();
			list.add(get("MAILOPEN"));
			list.add(get("DOCOPEN"));
			list.add(get("MAILOPEN"));
			list.add(get("MAILOPEN"));
			list.add(get("DOCOPEN"));
			list.add(get("DOCOPEN"));

			set(list.get(0));
			set(list.get(2));
			set(list.get(1));
			set(list.get(4));
			set(list.get(5));



		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static String get(String type) throws Exception{
		ClientResource resource = new ClientResource(host + "internal/get_logs");
		resource.addQueryParameter(new Parameter("logtype", type));
		resource = tools.DigestResolution(resource);
		resource.get();
		Response response = resource.getResponse();
		Series<Header> headers = (Series<Header>) response.getAttributes().get("org.restlet.http.headers");
		String ackToken = null;
		String checksum = null;
		for (Header temp : headers) {
			if ("ack_token".equals(temp.getName()))
				ackToken = temp.getValue();
			if ("checksum".equals(temp.getName()))
				checksum = temp.getValue();
		}
		System.out.println(response.getEntity().getText());
		return ackToken;
	}

	private static void set(String ackToken) throws Exception{
		ClientResource ackresource = new ClientResource(host + "internal/ack_logs");
		ackresource.addQueryParameter(new Parameter("acktoken", ackToken));
		ackresource = tools.DigestResolution(ackresource);
		ackresource.get();
		Response ackresourceResponse = ackresource.getResponse();
	}

}
