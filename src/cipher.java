import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Security;

public class cipher {

	private static SecretKey key = null;
	private static Cipher cipher = null;

	public static void main(String[] args) throws Exception {

		Security.addProvider(new com.sun.crypto.provider.SunJCE());

		KeyGenerator keyGenerator =
		KeyGenerator.getInstance("DESede");
		keyGenerator.init(112);
		SecretKey secretKey = keyGenerator.generateKey();
		cipher = Cipher.getInstance("DESede");

		String clearText = "I am an Employee";
		byte[] clearTextBytes = clearText.getBytes("UTF8");

		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] cipherBytes = cipher.doFinal(clearTextBytes);
		String cipherText = new Base64().encodeAsString(cipherBytes);

		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedBytes = cipher.doFinal(cipherBytes);
		String decryptedText = new String(decryptedBytes, "UTF8");



		System.out.println("Before encryption: " + clearText);
		System.out.println("After encryption: " + cipherText);
		System.out.println("After decryption: " + decryptedText);
	}
}
