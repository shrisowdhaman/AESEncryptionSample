package com.shri;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * @author shrisowdhaman
 *
 * Nov 21, 2017
 */
public class AESEncryption {

	
	private static SecretKeySpec secretKey; 
	
	private static Cipher cipher;	
	
	private String key="x!A%D*G-KaPdSgVkYp3s6v8y/B?E(H+M";
	 
	public AESEncryption(){
		try {
				secretKey = new SecretKeySpec(key.getBytes(), "AES");
				cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * Encrypts the value to be placed back in XML
	 */
	public String encrypt(String plaintext)   {
	  try{
         cipher.init(Cipher.ENCRYPT_MODE, secretKey);
         byte[] cipherText = cipher.doFinal(plaintext.getBytes("UTF8"));
         String encryptedString = new String(Base64.encodeBase64(cipherText),"UTF-8");
         return encryptedString;
	  }catch(Exception err){
		  System.out.println(err.getMessage());
   	   	  return "";
      }
	}

	/**
	 * Decrypts the string value
	 */
	public String decrypt(String encryptedText)  {
       try{
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] cipherText = Base64.decodeBase64(encryptedText.getBytes("UTF8"));
		String decryptedString = new String(cipher.doFinal(cipherText), "UTF-8");
		return decryptedString;
       }catch(Exception err){
    	   System.out.println(err.getMessage());   
    	   return "";
       }

	}
	public static void main(String[] args) {

		AESEncryption aes = new AESEncryption();
		
		//Encrypt
		String plainText = "<REQ><NAME>shri</NAME><ADDRESS>NewJersey</ADDRESS></REQ>";
		System.out.println(aes.encrypt(plainText));
		
		//Decrypt
		String encryptedText = "KqAmT6p3l5BIKoAIBGjh2qT6vDwsdMazmt+plK/TQKqXmxf5/3RFVcPKzB05zr2c";
		System.out.println(aes.decrypt(encryptedText));
		
		
	}

}
