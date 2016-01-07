import org.restlet.Response;
import org.restlet.data.Parameter;
import org.restlet.resource.ClientResource;

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


	public static void main(String[] parameters) {

		try {
		 String host="http://127.0.0.1:8080/";
		 String login="edeal";
		String password="toto";
		String url="internal/get_logs";

		ClientResource resource = new ClientResource(host + url);
			resource.addQueryParameter(new Parameter("logtype", "MAILOPEN"));
			resource = 	tools.DigestResolution(resource);
			resource.get();
			Response response = resource.getResponse();
			System.out.println(response.getEntity().getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
