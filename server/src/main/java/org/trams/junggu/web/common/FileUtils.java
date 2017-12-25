package org.trams.junggu.web.common;


import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtils {

	public static void main(String [] args){
		
			try{
				zip("d:\\2.jpg","d:\\2.zip");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
	    }
	
    public static void zip(String fileInput,String fileOutput)
    {
    	byte[] buffer = new byte[1024];
    	
    	try{
    		
    		FileOutputStream fos = new FileOutputStream(fileOutput);
    		ZipOutputStream zos = new ZipOutputStream(fos);
    		
    		File inFile = new File(fileInput);
    		
    		ZipEntry ze= new ZipEntry(inFile.getName());
    		zos.putNextEntry(ze);
    	
    		FileInputStream in = new FileInputStream(fileInput);
    		int len;
    		while ((len = in.read(buffer)) > 0) {
    			zos.write(buffer, 0, len);
    		}

    		in.close();
    		zos.closeEntry();
           
    		//remember close it
    		zos.close();
          
    		System.out.println("Done");

    	}catch(IOException ex){
    	   ex.printStackTrace();
    	}
    }
	
	/**
	 * Upload image to servre
	 * @param file
	 * @param servletContext
	 * @return
	 */
	public static String saveFile(MultipartFile file,ServletContext servletContext,int wdith,int height){
		String imgPatch = "" ;
		try {
			String fileName = null;
			InputStream inputStream = null;
			OutputStream outputStream = null;

			inputStream = file.getInputStream();
			String separator = java.nio.file.FileSystems.getDefault().getSeparator();
			String patch = servletContext.getRealPath("")+"images";
			String fileNewName = new Date().getTime() +"."+FilenameUtils.getExtension(file.getOriginalFilename());
			fileName = patch + separator+"upload"+separator+ fileNewName;
			outputStream = new FileOutputStream(fileName);
			int readBytes = 0;
			byte[] buffer = new byte[10000];
			while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
				outputStream.write(buffer, 0, readBytes);
			}
			outputStream.close();
			inputStream.close();
			
			saveFileResize(new File(fileName),wdith,height);
			

			imgPatch = "/images/upload/"+fileNewName;
			 
		} catch (Exception e) {
			System.out.println(e);

		}
		
		return imgPatch;
	}
	
	
	
	
	
	public static String saveFileOrigin(MultipartFile file,ServletContext servletContext){
		String imgPatch = "" ;
		try {
			String fileName = null;
			InputStream inputStream = null;
			OutputStream outputStream = null;

			inputStream = file.getInputStream();
			String separator = java.nio.file.FileSystems.getDefault().getSeparator();
			String patch = servletContext.getRealPath("")+"images";
			String fileNewName =  System.nanoTime() +"."+FilenameUtils.getExtension(file.getOriginalFilename());
			fileName = patch + separator+"upload"+separator+ fileNewName;
			outputStream = new FileOutputStream(fileName);
			int readBytes = 0;
			byte[] buffer = new byte[10000];
			while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
				outputStream.write(buffer, 0, readBytes);
			}
			outputStream.close();
			inputStream.close();
			
			//saveFile(new File(fileName),FilenameUtils.getExtension(file.getOriginalFilename()));

			imgPatch = "/images/upload/"+fileNewName;
			 
		} catch (Exception e) {
			System.out.println(e);

		}
		
		return imgPatch;
	}
	/**
	 * Upload image to servre
	 * @param base64encode
	 * @param servletContext
	 * @return
	 */
	public static String saveFile(String base64encode,String fileNewName,ServletContext servletContext,int wdith,int height){
		String imgPatch = "" ;
		try {
			byte[] inputStream = Base64.decodeBase64(base64encode);
			OutputStream outputStream = null;
			String separator = java.nio.file.FileSystems.getDefault().getSeparator();
			//String fileNewName = new Date().getTime() +".png";
			String patch = servletContext.getRealPath("")+"images";
			String fileName = patch + separator+"upload"+separator+ fileNewName;
			outputStream = new FileOutputStream(fileName);
			 
			outputStream.write(inputStream);
			 
			outputStream.close();
			
			//saveFileResize(new File(fileName),wdith,height);
			
			imgPatch = separator+"images"+separator+"upload"+separator+fileNewName;
		} catch (Exception e) {
		}
		
		return imgPatch;
	}
	/**
	 * Upload image to servre
	 * @param base64encode
	 * @param servletContext
	 * @return
	 */
	public static String saveFileOrigin(String base64encode,String fileNewName,ServletContext servletContext){
		String imgPatch = "" ;
		try {
			byte[] inputStream = Base64.decodeBase64(base64encode);
			OutputStream outputStream = null;
			String separator = "/";
			//String fileNewName = new Date().getTime() +".png";
			String patch = servletContext.getRealPath("")+"images";
			String fileName = patch + separator+"upload"+separator+ fileNewName;
			outputStream = new FileOutputStream(fileName);
			outputStream.write(inputStream);
			outputStream.close();
			//saveFileResize(new File(fileName),wdith,height);
			imgPatch = separator+"images"+separator+"upload"+separator+fileNewName;
		} catch (Exception e) {
		}
		
		return imgPatch;
	}
	/**
	 * Upload image to servre
	 * @param base64encode
	 * @param servletContext
	 * @return
	 */
	public static String saveFile(String base64encode,ServletContext servletContext,int wdith,int height){
		String imgPatch = "" ;
		try {
			byte[] inputStream = Base64.decodeBase64(base64encode);
			OutputStream outputStream = null;
			String separator = java.nio.file.FileSystems.getDefault().getSeparator();
			String fileNewName = new Date().getTime() +".png";
			String patch = servletContext.getRealPath("")+"images";
			String fileName = patch + separator+"upload"+separator+ fileNewName;
			outputStream = new FileOutputStream(fileName);
			
			outputStream.write(inputStream);
			
			outputStream.close();
			
			saveFileResize(new File(fileName),wdith,height);
			
			imgPatch = separator+"images"+separator+"upload"+separator+fileNewName;
		} catch (Exception e) {
		}
		
		return imgPatch;
	}
	
	public static String saveFileResize(File originalFime,int width,int height){
		String patch = "";
		try {
			
			BufferedImage originalImage = ImageIO.read(originalFime);
			int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
			BufferedImage scaleImage = scaleImage(originalImage, width,height,Color.white);
			BufferedImage resizeImageJpg = remakeImage(scaleImage, width,height,type);
			
			ImageIO.write(resizeImageJpg, "jpg", originalFime); 
				
		} catch (Exception e) {

		}
		return patch;
	}
	
	
	private static BufferedImage remakeImage(BufferedImage originalImage, int thumbWidth, int thumbHeight, int type) {

		int width = originalImage.getWidth();
		int height = originalImage.getHeight();
		

	    BufferedImage resizedImage = new BufferedImage(thumbWidth, thumbHeight, type);
	    Graphics2D g = resizedImage.createGraphics();
	    
	    g.setColor(Color.WHITE);
	    g.fillRect(0, 0, thumbWidth, thumbHeight);
	    g.setColor(Color.BLACK);
	    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
	    g.drawImage(originalImage, (thumbWidth-width)/2,(thumbHeight - height)/2, width, height,null);
	  
	    g.dispose();


	    return resizedImage;
	}
	
	private static BufferedImage scaleImage(BufferedImage img, int maxWidth, int maxHeight,Color background) {
		
	    int imgWidth = img.getWidth();
	    int imgHeight = img.getHeight();
	    
	    Dimension largestDimension = new Dimension(maxWidth, maxHeight);

	    float aspectRatio = (float) imgWidth / imgHeight;

	    if (imgWidth > maxWidth || imgHeight > maxHeight) {
	      if ((float) largestDimension.width / largestDimension.height > aspectRatio) {
	        largestDimension.width = (int) Math.ceil(largestDimension.height * aspectRatio);
	      }
	      else {
	        largestDimension.height = (int) Math.ceil(largestDimension.width / aspectRatio);
	      }

	      imgWidth = largestDimension.width;
	      imgHeight = largestDimension.height;
	    }
	    
//	    if (imgWidth*maxHeight < imgHeight*maxWidth) {
//	    	maxWidth = imgWidth*maxHeight/imgHeight;
//	    } else {
//	    	maxHeight = imgHeight*maxWidth/imgWidth;
//	    }
	    
	    
	    BufferedImage newImage = new BufferedImage(imgWidth, imgHeight,
	            BufferedImage.TYPE_3BYTE_BGR);
	    Graphics2D g = newImage.createGraphics();
	    try {
	        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
	        g.setBackground(background);
	        g.clearRect(0, 0, imgWidth, imgHeight);
	        g.drawImage(img, 0, 0, imgWidth, imgHeight, null);
	    } finally {
	        g.dispose();
	    }
	    return newImage;
	}
}
