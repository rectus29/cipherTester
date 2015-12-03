import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.OperationMode;
import org.apache.shiro.crypto.PaddingScheme;
import org.apache.shiro.util.ByteSource;


public class CipherTools {

    public static CipherTools ourInstance;
    private OperationMode operationMode = OperationMode.CBC;
    private PaddingScheme paddingScheme = PaddingScheme.PKCS5;


    public static CipherTools get(){
        if(ourInstance == null)
            ourInstance = new CipherTools();
        return ourInstance;
    }

    /**
	 * encrypt String with given AES key
	 * @param string 	String to encrypt
	 * @param key 		key to use to encrypt base64 encoded
	 * @return	String 	encrypted data
	 * @throws Exception
	 */
	public String encrypt(String string, String key) throws Exception {
		return encrypt(string, key,operationMode, paddingScheme);
	}


    public String encrypt(String string, String key, OperationMode opeMode, PaddingScheme paddingScheme) throws Exception {
        AesCipherService aes = new AesCipherService();
        aes.setMode(opeMode);
        aes.setPaddingScheme(paddingScheme);
        byte[] keyBytes = new Base64().decode(key);
        byte[] plaintextBytes = CodecSupport.toBytes(string);
        ByteSource cipherText = aes.encrypt(plaintextBytes, keyBytes);
        return new Base64().encodeToString(cipherText.getBytes());

    }





	/**
	 * decrypt data with given AES key
	 * @param encrypted	String data to decrypt
	 * @param key		AES key to use base64 encoded
	 * @return String 	data decypted
	 * @throws Exception
	 */
	public Object decrypt(String encrypted, String key) throws Exception {
		AesCipherService aes = new AesCipherService();
        aes.setMode(operationMode);
        aes.setPaddingScheme(paddingScheme);
		byte[] plaintextToDecode = new Base64().decode(encrypted);
		byte[] keyBytes = new Base64().decode(key);
		ByteSource cipherText = aes.decrypt(plaintextToDecode, keyBytes);
		return new String(cipherText.getBytes());
	}

	/**
	 * Generate AES key
	 * @return	String Aes key as Base64 encoded String
	 */
	public static String generateAesKey() {
		byte[] rootkey = new AesCipherService().generateNewKey().getEncoded();

		return new Base64().encodeToString(rootkey);
	}


}
