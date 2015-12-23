import com.edeal.trackingserver.tools.AESCipherTools;
import org.restlet.representation.Representation;
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
public class ConfigPushTest {


	public static void main(String[] parameters) {

		try {
		 String host="http://127.0.0.1:8080/";
		 String login="edeal";
		String password="7e32fc4e4e747e6eef2c8215613d61f7";
		String url="tdservices/watermark_config";

		ClientResource resource = new ClientResource(host + url);
			resource = 	AESCipherTools.DigestResolution(resource);
			Representation responseRep = resource.post(resource);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
