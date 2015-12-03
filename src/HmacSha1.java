import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class HmacSha1 {

    public static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    public static byte[] hash(byte[] privateKey, String stringToSign) throws NoSuchAlgorithmException, InvalidKeyException {
        // Get an hmac_sha1 key from the raw key bytes
        SecretKeySpec signingKey = new SecretKeySpec(privateKey, HMAC_SHA1_ALGORITHM);
        // Get an hmac_sha1 Mac instance and initialize with the signing key
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        mac.init(signingKey);
        // Compute the hmac on input data bytes
        byte[] rawHmac = mac.doFinal(stringToSign.getBytes());
        // Convert raw bytes to Hex
        return new Hex().encode(rawHmac);
    }

    public static byte[] hash(String privateKey, String stringToSign) throws InvalidKeyException, NoSuchAlgorithmException {
        return hash(privateKey.getBytes(), stringToSign);
    }
}
