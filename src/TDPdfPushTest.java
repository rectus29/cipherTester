import org.restlet.data.MediaType;
import org.restlet.ext.html.FormData;
import org.restlet.ext.html.FormDataSet;
import org.restlet.representation.FileRepresentation;
import org.restlet.representation.Representation;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;

public class TDPdfPushTest {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        try {
            String urlString = "/internal/storepdf";
            String host = "http://localhost:8080";

            // takes file path from first program's argument
            File uploadFile = new File("C:/Users/Rectus_29/Desktop/P1WS28199F1F.PDF");


            FormDataSet multipartFormData = new FormDataSet();
            multipartFormData.setMultipart(true);
            Representation fileRepresentation = new FileRepresentation(uploadFile, MediaType.valueOf(new MimetypesFileTypeMap().getContentType(uploadFile)));
            multipartFormData.getEntries().add(new FormData("file", fileRepresentation));
			/*ClientResource testPostFiles = AESCipherTools.DigestResolution(new ClientResource(host + urlString));
			testPostFiles.addQueryParameter(new Parameter("documentID", "plop"));
			testPostFiles.addQueryParameter(new Parameter("documentChkSum", "9d82d27dd12c6f3f177ee4d05ad19670bf073afc"));
			testPostFiles.post(multipartFormData);
*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
