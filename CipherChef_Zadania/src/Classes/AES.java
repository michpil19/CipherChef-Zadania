package Classes;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class AES extends EncryptionMethod{

    private String outputString;
    private String inputString;
    private String keyString;
    private SecretKey secretKey;
    private String algorithm;
    private IvParameterSpec iv;

    public AES(String algorithm) {
        this.algorithm = algorithm;
    }

    public AES() {
        super.setName("AES");
    }

    public void encrypt()
            throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {


        //Zadanie4
        //Uzupełnij funkcję encrypt() tak aby szyfrowała ona otrzymany na wejściu ciąg znaków (inputString).
        //Proszę wykorzystać zmienną algorithm jako argument metody Cipher.getInstance oraz pamiętać o tym że
        //oprócz algorytmu ECB wszystkie pozostąłe wykorzystują wektor inicjalizacyjny
        //ProTip: W razie trudności posiłkuj się metodą decrypt()
        //W celu sprawdzenia poprawności swojego rozwiązania możesz odkomentować odpowiednie linie w klasie Main i uruchomić program

    }

    public void decrypt()
            throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {

        Cipher cipher = Cipher.getInstance("AES/" + algorithm + "/PKCS5Padding");

        if (algorithm.equals("ECB")) cipher.init(Cipher.DECRYPT_MODE, secretKey);
        else cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

        byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(inputString.getBytes(StandardCharsets.UTF_8)));
        setOutputString(new String(plainText));

    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public void generateIv() {

        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        setIv(new IvParameterSpec(iv));

    }

    public String getOutputString() {
        return outputString;
    }

    public String getKeyString() {
        return keyString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public void setKeyString(String keyString) {

        this.keyString = keyString;
        secretKey = new SecretKeySpec(keyString.getBytes(StandardCharsets.UTF_8), "AES");
    }

    public String getInputString() {
        return inputString;
    }

    public void setOutputString(String outputString) {
        this.outputString = outputString;
    }

    public void setIv(IvParameterSpec iv) {
        this.iv = iv;
    }

    public void setIv(String ivString) {
        this.iv = new IvParameterSpec(Base64.getDecoder().decode(ivString.getBytes(StandardCharsets.UTF_8)));
    }

    public String getIvString() {
        return Base64.getEncoder().encodeToString(iv.getIV());
    }

    public String getAlgorithm() {
        return algorithm;
    }
}
