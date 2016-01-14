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
public class ConfigReadTest {

	public static void main(String[] parameters) {

		try {
			String host = "http://127.0.0.1:8080/";
			String url = "internal/get_watermark_config";

			ClientResource resource = new ClientResource(host + url);
			resource = tools.DigestResolution(resource);
			resource.get();
			System.out.println(resource.getResponse().getEntityAsText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
