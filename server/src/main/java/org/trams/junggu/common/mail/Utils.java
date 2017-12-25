package org.trams.junggu.common.mail;

import java.io.*;
import java.math.BigInteger;
import java.net.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.*;
import javax.xml.xpath.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.Document;
//import kr.co.tongkni.webservice.ServiceSMSSoapProxy;

public class Utils {
	
	public final static Integer CAMERA_BRAND = 0;
	public final static Integer LENS_BRAND = 1;
	public final static Integer DEAL_METHOD = 2;
	
	public static void main(String[] e) throws Exception{
//		try {
//			//sendMail("jgcil@hanmail.net", "<p>업체명: storename</p><p>0999999999</p>", "Test email");
//			sendMail("kennyphong2811@gmail.com","store_name", "0999999999", "Test email");
//			
//			System.out.println("Success!");
//		} catch (Exception e2) {
//			System.out.println("Failed");
//		}
		//System.out.println(getAuthPhoneCode("kennyphong2811@gmail.com","0973425295"));
		 
		
	}
	
	


	 
	
	
	public static String toString(Object str){
		try {
			return String.valueOf(str);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return "";
	}
 
	/**
	 * convert string to int, if null return 0 ( zero )
	 * @param str
	 * @return
	 */
	public static Integer parseInt(String str){
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return 0;
	}
 
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static Double parseDouble(String str){
		try {
			return Double.parseDouble(str);
		} catch (Exception e) {
		}
		return (double) 0;
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	  public static String getMD5(String input) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            byte[] messageDigest = md.digest(input.getBytes());
	            BigInteger number = new BigInteger(1, messageDigest);
	            String hashtext = number.toString(16);
	            // Now we need to zero pad it if you actually want the full 32 chars.
	            while (hashtext.length() < 32) {
	                hashtext = "0" + hashtext;
	            }
	            return hashtext;
	        }
	        catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        }
	    }
	  /**
	   * 
	   * @param input
	   * @return
	   */
	  public static String getMD5ToNumber(String input) {
		  try {
			  MessageDigest md = MessageDigest.getInstance("MD5");
			  byte[] messageDigest = md.digest(input.getBytes());
			  BigInteger number = new BigInteger(1, messageDigest);
			 
			  return number.toString();
		  }
		  catch (NoSuchAlgorithmException e) {
			   
		  }
		  
		  return "";
	  }
	  
	  /**
	   * 
	   * @param format
	   * @return
	   */
	  public static Date convertToDate(String value,String format){
		  
			SimpleDateFormat formatter = new SimpleDateFormat(format);

			try {

				Date date = formatter.parse(value);
				return date;

			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			return null;
	  }
	  
  
	  public static boolean sendMail(String toEmail,String header,String subject, String content){
		  try {
			  if(toEmail != null){
			    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
			      	 
			    	Mail mm = (Mail) context.getBean("mail");
			        mm.sendMail(toEmail,header,subject, content);
			        return true;
			  }
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		  return false;
	  }
	  
		/**
		 * Generate autt code
		 * @param email
		 * @param password
		 * @return
		 */
		public static String getAuthPhoneCode(String email,String phone){
			phone = phone.replaceFirst("82", "0");
			phone = phone.replace("+82", "0");
			String str = email+ "PTR09X#" + phone+new Date().toString();
			try {
					String hexStr = getMD5ToNumber(str);
					if(hexStr.length() > 10){
						return hexStr.substring(3,9).toUpperCase();	
					}
			} catch (Exception e) {
			}
			return "";
		}
		
		  public static String sendMess(String receivePhone,String smsContent){
			  
			  String send ="0";
			  try {
				  
				  receivePhone = receivePhone.replace("+82", "0");
					String smsID= "photoring";			//sms id
					String hashValue="photoring84";		//sms password
					
				//	ServiceSMSSoapProxy sendsms = new ServiceSMSSoapProxy();
					
					//String senderPhone= "01087017889";
					//String key = (smsID+hashValue+receivePhone);
					//CEncrypt encrypt = new CEncrypt("MD5",key);
					
					//send = sendsms.sendSMS(smsID,encrypt.getEncryptData(), senderPhone, receivePhone, smsContent);
			 		//System.out.println("Result Code:"+send);
					
			} catch (Exception e) {
				send ="0";
			}
			
			return send;
		  }
	}
		  
		  
class CEncrypt
		  {
		      MessageDigest md;
		      String strSRCData = "";
		      String strENCData = "";

		      public CEncrypt(){}
		      //When you create duplicate instances brought the constructor to be able to handle at one time.
		      public CEncrypt(String EncMthd, String strData)
		      {
		          this.encrypt(EncMthd, strData);
		      }

		      //A method for performing an encryption process.
		      public void encrypt(String EncMthd, String strData)
		     {
		         try
		        {
		            MessageDigest md = MessageDigest.getInstance(EncMthd); // "MD5" or "SHA1"
		           byte[] bytData = strData.getBytes();
		           md.update(bytData);

		           byte[] digest = md.digest();
		           for(int i =0;i<digest.length;i++)
		           {
		            	 strENCData = strENCData + String.format("%02x",digest[i] & 0xFF).toLowerCase();
		           }
		         }catch(NoSuchAlgorithmException e)
		        {
		           System.out.print("There is no encryption algorithm.");
		        };
		      
		        //Save the original data.
		        strSRCData = strData;
		      }

		      //The inline accessor functions.
		      public String getEncryptData(){return strENCData;}
		      public String getSourceData(){return strSRCData;}

		      //The method that the data is compared for equality.
		      public boolean equal(String strData)
		      {
		        //Even if the encrypted data is compared ditch , even if the source being compared....
		        if(strData == strENCData) return true;
		        return false;
		      }
		  	
		  }
