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
			String host = "http://127.0.0.1:8080/";
			String url = "internal/watermark_config";

			ClientResource resource = new ClientResource(host + url);
			resource.addQueryParameter("config", "{\"stampPolicy\":\"ALL\",\"font\":\"HELVETICA\",\"fontSize\":10.0,\"templateSupportedKeywords\":[\"firstname\",\"lastname\",\"company\"],\"template\":\"Document downloaded by $$firstname$$ $$lastname$$ ($$company$$)\",\"color\":\"lightGray\",\"stampPosX\":{\"positionPolicy\":\"WIDTH_CENTERED\",\"value\":10.0},\"stampPosY\":{\"positionPolicy\":\"HEIGHT_FROM_BOTTOM\",\"value\":10.0}}");
			resource = tools.DigestResolution(resource);
			resource.get();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
