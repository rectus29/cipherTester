import org.apache.commons.codec.digest.DigestUtils;
import org.restlet.data.MediaType;
import org.restlet.data.Parameter;
import org.restlet.ext.html.FormData;
import org.restlet.ext.html.FormDataSet;
import org.restlet.representation.FileRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class TDPdfPushTest {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		try {
			String urlString = "/tdclient/internal/storepdf";
			String host = "http://localhost:8080";

			List<File> fileList = new ArrayList<>();
			fileList.add(new File("C:\\Users\\a.bernard\\Desktop\\test0.pdf"));
			//fileList.add(new File("C:\\Users\\a.bernard\\Desktop\\test1.pdf"));
//			fileList.add(new File("C:\\Users\\a.bernard\\Desktop\\test2.pdf"));
//			fileList.add(new File("C:\\Users\\a.bernard\\Desktop\\test3.pdf"));
//			fileList.add(new File("C:\\Users\\a.bernard\\Desktop\\test4.pdf"));
//			fileList.add(new File("C:\\Users\\a.bernard\\Desktop\\test5.pdf"));

			for(File temp : fileList){
				File uploadFile = temp;
				FileInputStream fis =  new FileInputStream(uploadFile);
				String sha1CS = DigestUtils.sha1Hex(fis);
				FormDataSet multipartFormData = new FormDataSet();

				multipartFormData.setMultipart(true);
				Representation fileRepresentation = new FileRepresentation(uploadFile, MediaType.valueOf(new MimetypesFileTypeMap().getContentType(uploadFile)));
				multipartFormData.getEntries().add(new FormData("file", fileRepresentation));
				ClientResource testPostFiles = new ClientResource(host + urlString);
				testPostFiles.addQueryParameter(new Parameter("documentID", temp.getName()));
				testPostFiles.addQueryParameter(new Parameter("documentChkSum", sha1CS));
				testPostFiles = tools.DigestResolution(testPostFiles);
				testPostFiles.post(multipartFormData);
			}


			// takes file path from first program's argument


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
