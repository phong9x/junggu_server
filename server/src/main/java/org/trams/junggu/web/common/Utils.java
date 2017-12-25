package org.trams.junggu.web.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.util.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.modelmapper.internal.util.Lists;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.trams.junggu.bean.Store;
import org.trams.junggu.business.service.StoreService;
import org.trams.junggu.web.item.FacilityDataItem;
import org.trams.junggu.web.item.response.BuildingStructureItem;
import org.trams.junggu.web.item.response.DistanceItem;
import org.trams.junggu.web.item.response.EntranceStatusItem;
import org.trams.junggu.web.item.response.FormItem;
import org.trams.junggu.web.item.response.ImageExtend;
import org.trams.junggu.web.item.response.LivingFacilityItem;
import org.trams.junggu.web.item.response.MainGoodService;
import org.trams.junggu.web.item.response.ParkingAreaItem;
import org.trams.junggu.web.item.response.PurposeNoteItem;
import org.trams.junggu.web.item.response.RoomOfRefectorItem;
import org.trams.junggu.web.item.response.SpaceItem;
import org.trams.junggu.web.item.response.StaffToHelp;
import org.trams.junggu.web.item.response.ToiletteForDefector;
import org.w3c.dom.Document;



public class Utils {
	@Resource
	private StoreService storeService; 
	public static final Integer STATUS_PAYMENT_NONE =1;
	public static final Integer STATUS_PAYMENT_DONE =2;
	public static final Integer STATUS_PAYMENT_CANCEL_PAYMENT =3;
	
	private static int detailInfoIndex;
	
	public static void main(String[] args) throws Exception {
		System.setProperty("java.net.useSystemProxies", "true");
	      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	      System.out.println("Please enter a location:");
	      String postcode=reader.readLine();
	      String latLongs[] = getLatLongPositions(postcode);
	      System.out.println("Latitude: "+latLongs[0]+" and Longitude: "+latLongs[1]);
	}
	
	 public static String[] getLatLongPositions(String address) throws Exception
	  {
	    int responseCode = 0;
	    String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true";
	    System.out.println("URL : "+api);
	    URL url = new URL(api);
	    HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
	    httpConnection.connect();
	    responseCode = httpConnection.getResponseCode();
	    if(responseCode == 200)
	    {
	      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
	      Document document = builder.parse(httpConnection.getInputStream());
	      XPathFactory xPathfactory = XPathFactory.newInstance();
	      XPath xpath = xPathfactory.newXPath();
	      XPathExpression expr = xpath.compile("/GeocodeResponse/status");
	      String status = (String)expr.evaluate(document, XPathConstants.STRING);
	      if(status.equals("OK"))
	      {
	         expr = xpath.compile("//geometry/location/lat");
	         String latitude = (String)expr.evaluate(document, XPathConstants.STRING);
	         expr = xpath.compile("//geometry/location/lng");
	         String longitude = (String)expr.evaluate(document, XPathConstants.STRING);
	         return new String[] {latitude, longitude};
	      }
	      else
	      {
	         throw new Exception("Error from the API - response status: "+status);
	      }
	    }
	    return null;
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
	
	public static Integer parseInt(Object obj){
		try {
			return Integer.parseInt(obj.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return 0;
	}
	public static Long parseLong(Object obj){
		try {
			return Long.parseLong(obj.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return (long) 0;
	}
	
	public static String toString(Object str){
		try {
			return String.valueOf(str);
		} catch (Exception e) {
			System.out.println(e.toString());
			return "";
		}
	
	}
	public static String getStringFromArray(String[] str, int index){
		try {
			return String.valueOf(str[index]);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return "";
	}
	
	public static Date getPresentTime(String formatDate){
		java.util.Date utilDate = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat(formatDate);
	    java.sql.Date sqlDate = null;
	    sqlDate= java.sql.Date.valueOf(sdf.format(utilDate.getTime()));
	    return sqlDate;
	}
	
	public static Date getDate(String formatDate,String startDateString){
	    DateFormat df = new SimpleDateFormat(formatDate); 
	    Date startDate;
	    try {
	        startDate = df.parse(startDateString);
	        return startDate;
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    
	    return null;
	}
	
	
	public static int getHourUtilRentCreate(Calendar dateRent,Calendar dateFire){
		try {
		 
			long milliseconds = dateFire.getTimeInMillis()-dateRent.getTimeInMillis();
			return (int)(milliseconds / (1000*60*60));
		} catch (Exception e) {
		}
		
		return -1;
	}
	
	public static java.sql.Date convertStringtoSqlDate(String date,String formatDate){
		SimpleDateFormat format = new SimpleDateFormat(formatDate);
		java.util.Date parsed = null;
		try {
			parsed = format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
	    return sqlDate;
	}
	
	public static java.util.Date convertStringtoUtilDate(String date,String formatDate){
		SimpleDateFormat format = new SimpleDateFormat(formatDate);
		java.util.Date parsed = null;
		try {
			parsed = format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return parsed;
	}
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	public static String getFindEmail(String email){
		try {
			String[] e = email.split("@");
			int lenght = e[0].length();
			String rex = e[0].substring(lenght-3, lenght);
			return email.replaceAll(rex, "***");
			
		} catch (Exception e) {
		}
		return "";
	}
	/**
	 * 
	 * @param email
	 * @return
	 */
	public static String getHiddentString(String str,int hiddneNumber){
		try {
			int lenght = str.length();
			String rex = str.substring(lenght-hiddneNumber, lenght);
			return str.replaceAll(rex, "***");
			
		} catch (Exception e) {
		}
		return "";
	}
	/**
	 * 
	 * @param array
	 * @param cement
	 * @return
	 */
	public static <T> String join(T[] array, String cement) {
	    StringBuilder builder = new StringBuilder();

	    try {
		    if(array == null || array.length == 0) {
		        return null;
		    }

		    for (T t : array) {
		        builder.append(t).append(cement);
		    }

		    builder.delete(builder.length() - cement.length(), builder.length());
		} catch (Exception e) {
		}

	    return builder.toString();
	}
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String getHourMinute(Date date){
		try {
			DateFormat writeFormat = new SimpleDateFormat( "HH시mm분");
			return writeFormat.format( date );
		} catch (Exception e) {
		}
		
		return "";
	}
	public static String getHourMinute(Time time){
		try {
			DateFormat writeFormat = new SimpleDateFormat( "HH:mm");
			return writeFormat.format( time );
		} catch (Exception e) {
		}
		
		return "";
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
	  
		/**
		 * Generate autt code
		 * @param email
		 * @param password
		 * @return
		 */
		public static String getAuthPhoneCode(String srt,String str2){
			
			String str = srt+ "ML^#09X#" + str2;
			try {
					String hexStr = getMD5(str);
		            return hexStr.substring(3,9).toUpperCase();			
			} catch (Exception e) {
			}
			return "";
		}
		
		  


		public static String sendMess(String phone, String content) {
			return "0";
		}
		
		public static Cookie createCookie(String cookieName, String cookieValue) {
		    Cookie cookie = new Cookie(cookieName, cookieValue);
		    final int expiryTime = 60 * 60 * 24;  // 24h in seconds
		    cookie.setPath("/");
		    cookie.setMaxAge(expiryTime);
		    cookie.setSecure(true);
		    return cookie;
		}
		
		public static String ConvertInterrestJsonToStringOfName(String json) {
			JSONParser parser = new JSONParser();
			try {
				JSONObject jsonObj = (JSONObject) parser.parse(json);
				JSONArray obj = (JSONArray) parser.parse(Utils.toString(jsonObj.get("interest")));
				String str="";
				int index=1;
				for (Object object : obj) {
					JSONObject item = (JSONObject)object;
					Utils.toString(Utils.toString(item.get("name")));
					if(index==1){
						str+=Utils.toString(Utils.toString(item.get("name")));
					}else{
						str+=", "+Utils.toString(Utils.toString(item.get("name")));
					}
					index++;
					
				}
				return str;
			} catch (Exception e) {
				System.out.println(e);
				return "";
			}
			
		}
		public static String ConvertJsonTo_String(String json,String objectName, String atributeName) {
			JSONParser parser = new JSONParser();
			try {
				JSONObject jsonObj = (JSONObject) new JSONParser().parse(json);
				JSONArray obj = (JSONArray) jsonObj.get(objectName);
				String str="";
				int index=0;
				for (Object object : obj) {
					JSONObject item = (JSONObject)object;
					Utils.toString(Utils.toString(item.get(atributeName)));
					if(index==0){
						str+=Utils.toString(Utils.toString(item.get(atributeName)));
					}else{
						str+=", "+Utils.toString(Utils.toString(item.get(atributeName)));
					}
					index++;
					
				}
				return str;
			} catch (Exception e) {
				System.out.println(e);
				return "";
			}
			
		}
		
		public static List<String> ConvertJsonTo_ListString(String json,String atributeName) {
			JSONParser parser = new JSONParser();
			try {
				JSONObject jsonObj = (JSONObject) new JSONParser().parse(json);
				JSONArray msg = (JSONArray) jsonObj.get(atributeName);
				Iterator<String> iterator = msg.iterator();
				List<String> str=new ArrayList<>();
				int index=0;
				while (iterator.hasNext()) {
					str.add(iterator.next());
				}
				return str;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		
		public static List<FormItem> ConvertJsonTo_List_FormItem(String json,String objectName, String atributeName) {
			JSONParser parser = new JSONParser();
			try {
				JSONObject jsonObj = (JSONObject) new JSONParser().parse(json);
				JSONArray objParent = (JSONArray) jsonObj.get(objectName);
				List<FormItem> list=new ArrayList<>();
				for (Object object : objParent) {
					JSONObject item = (JSONObject)object;
					JSONObject jsonObj2 = (JSONObject) new JSONParser().parse(Utils.toString(item));
					JSONArray objChild = (JSONArray) jsonObj2.get(atributeName);
					if(objChild!=null){
					for (Object object2 : objChild) {
						JSONObject item2 = (JSONObject)object2;
						FormItem formItem=new FormItem();
						formItem.setKey(Utils.toString(item2.get("key")));
						formItem.setValue(Utils.toString(item2.get("value")));
						formItem.setName(Utils.toString(item2.get("name")));
						list.add(formItem);
					}
					}
				}
				return list;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
			
		}

		public static Map<String,Object> convertJsonArrayToMap(String jsonarray) {
			try {
				Map<String,Object> listData = new HashMap<String,Object>();
				
				JSONObject jsonObj = (JSONObject) new JSONParser().parse("{\"data\":"+jsonarray+"}");
				JSONArray objParent = (JSONArray) jsonObj.get("data");
				for (Object object : objParent) {
					listData.put(object.toString(), object);
				}
				return listData;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
			
		}
		
		public static List<ImageExtend> ConvertJsonTo_ListExtendImage(String json) {
			JSONParser parser = new JSONParser();
			try {
				JSONObject jsonObj = (JSONObject) new JSONParser().parse(json);
				JSONArray objParent = (JSONArray) jsonObj.get("image_extend_attach");
				List<ImageExtend> list=new ArrayList<>();
				for (Object object : objParent) {
					JSONObject item = (JSONObject)object;
					JSONObject jsonObj2 = (JSONObject) new JSONParser().parse(Utils.toString(item));
					 
					JSONArray objChild = (JSONArray) jsonObj2.get("photos");
					ImageExtend image=new ImageExtend();
					image.setName(item.get("name_of_relevant").toString());
					List<String> photos=new ArrayList<>();
					if(objChild!=null){
					for (Object object2 : objChild) {
						if(object2==null){
							photos.add("");
						}else{
							photos.add(Utils.toString(object2.toString()));
						}
						
					}
					image.setPhoto(photos);
					}
					list.add(image);
				}
				return list;
 
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
				
		public static Double calculateAmountOfPayment(Integer membertype, Integer numberOfTime) {

			Double amountOfPayment=0.0;
			try {
				if(membertype==1){
					amountOfPayment=(double) (numberOfTime*55000);
				}else{
					amountOfPayment=(double) (numberOfTime*30000);
				}
			} catch (Exception e) {
				return 0.0;
			}
			return amountOfPayment;
			
		}
		
		public static Double calculateFee(Integer membertype, Integer numberOfTime) {
			Double fee=0.0;
			try {
				if(membertype==1){
					fee=(double) (numberOfTime*15000);
				}else{
					fee=(double) (numberOfTime*13750);
				}
				
			} catch (Exception e) {
				return 0.0;
			}
			return fee;
			
		}
		public static Double calculateRevenue(Integer membertype, Integer numberOfTime) {

			Double revenue=0.0;
			try {
				if(membertype==1){
					revenue=(double) (numberOfTime*40000 );
				}else{
					revenue=(double) (numberOfTime*16250  );
				}
				
			} catch (Exception e) {
				return 0.0;
			}
			return revenue;
			
		}
		 public static String ConvertStringListToJson(String name,String[] listString){
			 JSONObject obj = new JSONObject();
			 JSONArray list = new JSONArray();
			 for (int i = 0; i < listString.length; i++) {
				 list.add(listString[i]);
			}
			 obj.put( name,list);
			 return obj.toJSONString();
		 }
		 public static String ConvertDoubleStringListToJson(String name1,String[] listString1,String name2,String[] listString2){
			 JSONObject obj = new JSONObject();
			 JSONArray list1 = new JSONArray();
			 JSONArray list2 = new JSONArray();
			 for (int i = 0; i < listString1.length; i++) {
				 list1.add(listString1[i]);
			}
			 for (int i = 0; i < listString2.length; i++) {
				 list2.add(listString2[i]);
			}
			 obj.put( name1,list1);
			 obj.put( name2,list2);
			 return obj.toJSONString();
		 }
		 public static String convertStringListToJson(List<Integer> list){
			 JSONArray listData = new JSONArray();
			 if(list != null && list.size() > 0){
				 for (int i = 0; i < list.size(); i++) {
					 listData.add(list.get(i));
				 }
			 }
			 return listData.toJSONString();
		 }
		 public static String convertMapToJson(Map<String,Object>  list){
			 JSONArray listData = new JSONArray();
			 
			 List<Object> listD = new ArrayList<Object>(list.values());
			 
			 if(list != null && listD.size() > 0){
				 for (int i = 0; i < listD.size(); i++) {
					 listData.add(listD.get(i));
				 }
			 }
			 return listData.toJSONString();
		 }
		 public static String ConvertStringListToJsonObjectContain_ID_Name(String[] listString,String objectName){
			 JSONObject parent = new JSONObject();
			 JSONArray list = new JSONArray();
			 List<String> listId = new ArrayList<>();
			 List<String> listName = new ArrayList<>();
			 
			 for (int i = 0; i < listString.length; i++) {
				 String[] split=listString[i].split("-");
				 JSONObject obj = new JSONObject();
				 obj.put( objectName+"_id",split[0].toString());
				 obj.put( objectName+"_name",split[1].toString());
				 list.add(obj); 
			}
			parent.put(objectName, list);
			
			 return parent.toJSONString();
		 }
		 
		 public static String ConvertStringListToAddressStore(String[] listString){
			 JSONObject parent = new JSONObject();	
			 JSONArray list = new JSONArray();
			 List<String> listId = new ArrayList<>();
			 List<String> listName = new ArrayList<>();
			 JSONObject obj = new JSONObject();
			 obj.put( "address1",listString[0].toString());
			 obj.put( "address2",listString[1].toString());
			 list.add(obj); 
			 
			 parent.put("address", list);
			 return parent.toJSONString();
		 }
	
		 public static <T> String ConvertListToJson(String name,List<T> listString){
			 JSONObject obj = new JSONObject();
			 JSONArray list = new JSONArray();
			 if(listString != null){
				 for (T object : listString) {
					 list.add(object);
				}
			 }
			 obj.put( name,list);
			 return obj.toJSONString();
		 }
		 
		 public static JSONObject getArrayJson(List<FormItem> items,String name){
				JSONObject responseDetailsJson = new JSONObject();
			    JSONArray jsonArray = new JSONArray();
			    
			    try {
				    for (FormItem object : items) {
				    	JSONObject formDetailsJson = object.tojSon();
				    	jsonArray.add(formDetailsJson);
					}
				    responseDetailsJson.put(name, jsonArray);
				} catch (Exception e) {
				}
			    
				return responseDetailsJson;
			}
		 
		 
		 public static Long convertFromTime(Date date){
			 try {
				return date.getTime();
			} catch (Exception e) {
			}
			 
			 return new Long(0);
		 }
		 public static String formatPhoneNumber(String str){
			 String temp="";
				 try {
					 Integer a= (Integer)str.length()/4;
					 Integer b= str.length()-(a)*4;
					 int index=0;
					 for (int i = a; i >=0; i--) {
						 if(i==a){
							 temp=str.substring(str.length()-(index*4+4), str.length()-index*4)+temp;
						 }else if(i==0){
							 temp=str.substring(0, b)+"-"+temp;
						 }else{
							 temp=str.substring(str.length()-(index*4+4), str.length()-index*4)+"-"+temp;
						 }
						 index++;
						 
					}
					 
				} catch (Exception e) {
					return str;
				}
			 return temp;
		 }
		 
		 public static String getOtherInfomation(Store s){
			 String str="";
			 detailInfoIndex = 0;

			 	RoomOfRefectorItem roomOfRefectorItem = new RoomOfRefectorItem();
				DistanceItem distanceItem =new DistanceItem();
				BuildingStructureItem buildingStructureItem = new BuildingStructureItem();
				EntranceStatusItem entranceStatusItem = new EntranceStatusItem();
				LivingFacilityItem living = new LivingFacilityItem();
				MainGoodService goodService = new MainGoodService();
				ParkingAreaItem parkingAreaItem = new ParkingAreaItem();
				PurposeNoteItem purposeNoteItem = new PurposeNoteItem();
				SpaceItem spaceItem = new SpaceItem();
				StaffToHelp staffToHelp = new StaffToHelp();	
				ToiletteForDefector toilet = new ToiletteForDefector();
				roomOfRefectorItem.parserJson(s.getRoomOfRefector());
				distanceItem.parserJson(s.getDistance());
				buildingStructureItem.parserJson(s.getBuildingStructure());
				entranceStatusItem.parserJson(s.getEntranceStatus());
				living.parserJson(s.getLivingFacility());
				goodService.parserJson(s.getMainGoodService());
				parkingAreaItem.parserJson(s.getParkingArea());
				purposeNoteItem.parserJson(s.getPurposeNote());
				spaceItem.parserJson(s.getSpace());
				staffToHelp.parserJson(s.getStaffHelpDefector());
				toilet.parserJson(s.getToiletteForDefector());
				if(s.getStoreName()!=null && !s.getStoreName().equalsIgnoreCase("")  ){
					str+=" \n역 이름: "+s.getStoreName();
					detailInfoIndex++;
				}
				if(s.getStoreExit()!=null && !s.getStoreExit().equalsIgnoreCase("")  ){
					str+="\n역 출구: "+s.getStoreExit();
					detailInfoIndex++;
				}
				if(s.getStoreElevatorPositon()!=null && !s.getStoreElevatorPositon().equalsIgnoreCase("")  ){
					str+="\n엘리베이터 위치: "+s.getStoreElevatorPositon();
					detailInfoIndex++;
				}
			 str+=getString_Checkbox_OtherInfo("역으로부터의 거리",distanceItem.getMain());
			 
			 if(detailInfoIndex != 0){
				 str+="\n";
				 detailInfoIndex = 0;
			 }
			 
//			 str+=getString_Textbox_OtherInfo("건물구조",buildingStructureItem.getMain(),"","층");
			 
			 List<FormItem> formItems = buildingStructureItem.getMain();
			 if(!formItems.isEmpty() ){
				 String floor[] = {"-", "-", "-"};
				 str+="\n건물구조: ";
				 for(FormItem formItem : formItems){
					 String value = formItem.getValue();
					 if((!value.equals("") && !value.equals(null))){
						 floor[Integer.parseInt(formItem.getKey()) - 1] = value;
					 }
				 }
				 str+= "지하 "+floor[0]+"층, 지상 "+floor[1]+"층, 총 "+floor[0]+"층";
				 detailInfoIndex++;
			 }
			 
			 if(detailInfoIndex != 0){
				 str+="\n";
				 detailInfoIndex = 0;
			 }
			 
			 str+=getString_Textbox_Purpose(purposeNoteItem.getMain1());
			 str+=getString_Textbox_Purpose(purposeNoteItem.getMain2());
			 str+=getString_Textbox_Purpose(purposeNoteItem.getMain3());
			 
//			 str+=getString_Textbox_OtherInfo("",purposeNoteItem.getMain1(),"용도","비고");
//			 str+=getString_Textbox_OtherInfo("",purposeNoteItem.getMain2(),"용도","비고");
//			 str+=getString_Textbox_OtherInfo("",purposeNoteItem.getMain3(),"용도","비고");
			 str+=getString_Checkbox_OtherInfo("주차구역",parkingAreaItem.getMain());
			 str+=getString_Checkbox_OtherInfo_ETC("주차장 위치",parkingAreaItem.getParkingLotArea());
			 
			 if(detailInfoIndex != 0){
				 str+="\n";
				 detailInfoIndex = 0;
			 }
			 
			 str+=getString_Textbox_OtherInfo("장애인주차장",parkingAreaItem.getParkingLotDefector(),"","대");
			 str+=getString_Checkbox_OtherInfo("주차장에서 상점입구까지 거리",parkingAreaItem.getDistance());
			 
			 if(detailInfoIndex != 0){
				 str+="\n";
				 detailInfoIndex = 0;
			 }
			 
			 str+=getString_Checkbox_OtherInfo("주출입구 형태",entranceStatusItem.getMain());
			 str+=getString_Checkbox_OtherInfo("턱",entranceStatusItem.getLift());
			 str+=getString_Checkbox_OtherInfo("출입문",entranceStatusItem.getDoor());
			 str+=getString_Checkbox_OtherInfo("출입문 폭",entranceStatusItem.getWideOfDoor());
//			 str+=getString_Textbox_OtherInfo("출입문 폭",entranceStatusItem.getWideOfDoor(),"","인승");
			 
			 if(detailInfoIndex != 0){
				 str+="\n";
				 detailInfoIndex = 0;
			 }
			 
			 str+=getString_Checkbox_OtherInfo("생활시설(상점) 내 엘리베이터",living.getMain());
//			 str+=getString_Checkbox_OtherInfo("엘리베이터 내부공간",living.getSpace());
			 str+=getString_Textbox_OtherInfo("엘리베이터 내부공간",living.getSpace(), "", "인승");
			 str+=getString_Checkbox_OtherInfo("엘리베이터 전동휠체어 이용가능여부",living.getElevatorWheelChair());
			 str+=getString_Checkbox_OtherInfo("엘리베이터 전동스쿠터 이용가능여부",living.getElevatorWhichScouter());
			 str+=getString_Checkbox_OtherInfo("장애인용 버튼",living.getButtonForDefectorDanger());
			 str+=getString_Checkbox_OtherInfo("엘리베이터 까지 시각장애인용 점자블럭과 안내표시판이",living.getBrailleNoticeBoard());
			 
			 if(detailInfoIndex != 0){
				 str+="\n";
				 detailInfoIndex = 0;
			 }
			 
			 str+=getString_Checkbox_OtherInfo("내부공간",spaceItem.getMain());
			 str+=getString_Checkbox_OtherInfo("내부공간 - 전동휠체어를 타고 이동",spaceItem.getInteriorSpacewheelchairCanUse());
			 str+=getString_Checkbox_OtherInfo("내부공간 - 전동스쿠터를 타고 이동",spaceItem.getInteriorSpaceScouterCanUse());
			 str+=getString_Checkbox_OtherInfo("내부공간 계단이나 단차 존재여부", spaceItem.getInteriorSpaceSStairOrWay());
			 str+=getString_Checkbox_OtherInfo("장애인과 함께 동석하거나 이동할 있는 자리",spaceItem.getSpaceCanUseByDefectorAndPeople());
			 
			 if(detailInfoIndex != 0){
				 str+="\n";
				 detailInfoIndex = 0;
			 }
			 
			 str+=getString_Checkbox_OtherInfo("상점 서비스테이블 및 물품비치대 형식",spaceItem.getStoreServiceTableAndRackForm());
			 str+=getString_Checkbox_OtherInfo("내부공간에 시각장애인이 이동 동선이 편하도록 점자블럭이",spaceItem.getBrailleBlockBlinderInside());
			 str+=getString_Checkbox_OtherInfo("시각장애인용 점자안내판",spaceItem.getBrailleNoticeBoardBlinder());
			 str+=getString_Textbox_OtherInfo("영화관·공연장내에 장애인 이용이 가능한 곳(관)",spaceItem.getCinemaTheatreWhereDefactor(),"","");
			 str+=getString_Checkbox_OtherInfo("영화관·공연장내에 장애인좌석 위치",spaceItem.getPlaceDefectorInCinemaTheatre());
			 
			 if(detailInfoIndex != 0){
				 str+="\n";
				 detailInfoIndex = 0;
			 }
			 
			 str+=getString_Checkbox_OtherInfo("장애인용 객실 유/무",roomOfRefectorItem.getMain());
			 
//			 if(roomOfRefectorItem.getPositionOfRoom() != null){
//				 items.add(roomOfRefectorItem.getPositionOfRoom().get(0));
//			 }
			 List<FormItem> items =new ArrayList<>();
			 str+=getString_Textbox_OtherInfo("장애인용 객실 위치",items,""," 층");
			 items =new ArrayList<>();
			 
			 if (roomOfRefectorItem.getPositionOfRoom() != null && roomOfRefectorItem.getPositionOfRoom().size() > 0) {
				 items.add(roomOfRefectorItem.getPositionOfRoom().get(0));
			 }
			 
			 str+=getString_Textbox_OtherInfo("객실 수",items,"","객실");
			 str+=getString_Checkbox_OtherInfo("장애인용이 이용이 가능한 객실 유/무",roomOfRefectorItem.getRoomDefector());
			 str+=getString_Checkbox_OtherInfo("내부공간 - 전동휠체어를 타고 이용",roomOfRefectorItem.getInteriorWheelchair());
			 str+=getString_Checkbox_OtherInfo("내부공간 - 전동스쿠터를 타고 이용",roomOfRefectorItem.getInteriorSpaceScouter());
			 str+=getString_Checkbox_OtherInfo("내부공간 계단이나 단차 존재여부",roomOfRefectorItem.getInteriorSpaceStair());
			 str+=getString_Checkbox_OtherInfo("수동휠체어 대여 가능여부",roomOfRefectorItem.getHireManual());
			 
			 if(detailInfoIndex != 0){
				 str+="\n";
				 detailInfoIndex = 0;
			 }
			 
			 str+=getString_Checkbox_OtherInfo("객실 내 화장실 넓이",roomOfRefectorItem.getAreaOfToilette());
			 str+=getString_Checkbox_OtherInfo("객실 내 화장실 손잡이 존재여부",roomOfRefectorItem.getStrapInToilette());
			 str+=getString_Checkbox_OtherInfo("장애인 이용가능한 음식점",roomOfRefectorItem.getFoodCourt());
			 str+=getString_Checkbox_OtherInfo("내부공간에 시각장애인이 이동 동선이 편하도록 점자블럭이",roomOfRefectorItem.getInInteriorSpace());
			 str+=getString_Checkbox_OtherInfo("시각장애인용 점자안내판",roomOfRefectorItem.getBrailleNotice());
			 
			 if(detailInfoIndex != 0){
				 str+="\n";
				 detailInfoIndex = 0;
			 }
			 
			 str+=getString_Checkbox_OtherInfo("장애인화장실 존재여부",toilet.getMain());
			 str+=getString_Checkbox_OtherInfo("화장실 남녀구분",toilet.getToiletteGender());
			 str+=getString_Checkbox_OtherInfo("출입문 형태",toilet.getEntranceDoor());
			 str+=getString_Checkbox_OtherInfo("일반화장실 휠체어 접근여부",toilet.getNormalToilette());
			 str+=getString_Textbox_OtherInfo("일반화장실 설치 수",toilet.getNumberOfBuildingPlaced(),"","곳 (칸 수 아님.)");
			 str+=getString_Checkbox_OtherInfo("일반화장실 위치",toilet.getPositionOfToilette());
			 str+=getString_Checkbox_OtherInfo("화장실 출입 시 시각장애인용 점자블럭이",toilet.getBrailleNotice());
			 
			 if(detailInfoIndex != 0){
				 str+="\n";
				 detailInfoIndex = 0;
			 }
			 
			 str+=getString_Textbox_OtherInfo("장애인 화장실 설치 수",toilet.getNumberOfBuildingDefector(),"","곳 (칸 수 아님.)");
			 str+=getString_Checkbox_OtherInfo("장애인 화장실 위치",toilet.getPosition());
			 str+=getString_Checkbox_OtherInfo("장애인 화장실 남녀구분",toilet.getGenderNeutral());
			 str+=getString_Checkbox_OtherInfo("장애인 화장실 출입문 형태",toilet.getDoorStatus());
			 str+=getString_Checkbox_OtherInfo("장애인 화장실 내부공간(휠체어 회전)",toilet.getSpaceInside());
			 str+=getString_Checkbox_OtherInfo("장애인 화장실 소변기 손잡이(일반화장실에)",toilet.getHandleNextUrinal());
			 str+=getString_Checkbox_OtherInfo("장애인 화장실 대변기 손잡이",toilet.getHandleNextCloset());
			 str+=getString_Checkbox_OtherInfo_ETC("장애인 화장실 청결 여부",toilet.getCleaning());
			 
			 if(detailInfoIndex != 0){
				 str+="\n";
				 detailInfoIndex = 0;
			 }
			 
			 str+=getString_Textbox_MainGood("주요 물품 및 서비스1",goodService.getMain1());
			 str+=getString_Textbox_MainGood("주요 물품 및 서비스2",goodService.getMain2());
			 str+=getString_Textbox_MainGood("주요 물품 및 서비스3",goodService.getMain3());
			 str+=getString_Textbox_MainGood("주요 물품 및 서비스4",goodService.getMain4());
			 str+=getString_Checkbox_OtherInfo("장애인 고객을 위한 안내 직원 존재 여부",staffToHelp.getMain());
			 str+=getString_Checkbox_OtherInfo("입구 출입 시",staffToHelp.getHelpToGet());
			 str+=getString_Checkbox_OtherInfo("장애인 고객을 위해",staffToHelp.getJustHelp());

			 return str;
			
		 }
		 
		 public static String getString_Textbox_MainGood(String name,List<FormItem> formItem){
			 String str="";
			 try {
				 String strValue="";
				 for (int i = 0; i < formItem.size(); i++) {
					 if(!formItem.get(i).getValue().equalsIgnoreCase("") && formItem.get(i).getValue()!=null){
						 if(i==0){
							 strValue+="구분: "+formItem.get(i).getValue();
						 }else if(i==1){
							 strValue+=", 가격: "+formItem.get(i).getValue();
						 }else if(i==2){
							 strValue+=", 비고: "+formItem.get(i).getValue();
						 }
					 }
				}
				 if(strValue!=""){
					 str+="\n"+name+"\n"+strValue+""; 
					 detailInfoIndex++;
				 }
			} catch (Exception e) {
			}
			return str;
		 }
		 
		 public static String getString_Checkbox_OtherInfo(String name,List<FormItem> formItem){
			 String str="";
			 try {
				 String strValue="";
				 for (int i = 0; i < formItem.size(); i++) {
					 if(!formItem.get(i).getName().equalsIgnoreCase("") && formItem.get(i).getName()!=null){
						 if(i==0){
							 strValue+=formItem.get(i).getName();
						 }else{
							 strValue+=", "+formItem.get(i).getName();
						 }
					 }
				}
				 if(strValue!=""){
					 str+= "\n"+name+": "+strValue+""; 
					 detailInfoIndex++;
				 }
			} catch (Exception e) {
			}
			return str;
		 }
		 
		 public static String getString_Textbox_Purpose(List<FormItem> formItem){
			    String str="";
			    try {
			    	 String strValue="";
					    for (int i = 0; i < formItem.size(); i++) {
					     if(!formItem.get(i).getValue().equalsIgnoreCase("") && formItem.get(i).getValue()!=null){
					      if(i==0){
					       strValue+="용도: "+formItem.get(i).getValue();
					      }else if(i==1){
					       strValue+=", 비고: "+formItem.get(i).getValue();
					      }
					     }
					   }
					    if(strValue!=""){
					     str+="\n"+strValue+""; 
					     detailInfoIndex++;
					    }
				} catch (Exception e) {
				}
			   return str;
			   }
		 
		 
		 public static String getString_Textbox_OtherInfo(String name,List<FormItem> formItem,String before, String after){
			 String str="";
			 try {
				 String strValue="";
				 for (int i = 0; i < formItem.size(); i++) {
					 if(!formItem.get(i).getValue().equalsIgnoreCase("") && formItem.get(i).getValue()!=null){
						 if(i==0){
							 
							 if(before!=""){
								 strValue+=before+" ";
							 }
							 strValue+=formItem.get(i).getValue();
							 if(after!=""){
								 strValue+=" "+after;
							 }
						 }else{
							 strValue+=", ";	
							 if(before!=""){
								 strValue+=before+" ";
							 }
							 strValue+=formItem.get(i).getValue();
							 if(after!=""){
								 strValue+=" "+after;
							 }
						 }
					 }
				}
				 if(strValue!=""){
					 if(name!=""){
						 str+="\n"+name+": "+strValue+""; 
					 }else{
						 str+="\n"+strValue+""; 
					 }
					 detailInfoIndex++;
					 			 }
			} catch (Exception e) {
			}
			return str;
		 }
		 
		 
		 public static String getString_Checkbox_OtherInfo_ETC(String name,List<FormItem> formItem){
			 String str="";
			 try {
				 String strValue="";
				 if(!formItem.get(0).getName().equalsIgnoreCase("") && formItem.get(0).getName()!=null){
					 if(formItem.get(0).getValue().equalsIgnoreCase("3")){
						 strValue+= formItem.get(0).getName()+" ("+formItem.get(1).getValue()+")";
					 }else{
						 strValue+= formItem.get(0).getName();
					 }
				 }
				 if(strValue!=""){
					 str+= "\n"+name+": "+strValue+""; 
					 detailInfoIndex++;
				 }
			} catch (Exception e) {
			}
			return str;
		 }
		
		 
}
