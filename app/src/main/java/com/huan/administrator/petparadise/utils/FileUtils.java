package com.huan.administrator.petparadise.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.util.EncodingUtils;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.huan.administrator.petparadise.MyApp;

public class FileUtils {
	/**
	 * 写数据到SD中的文件
	 * 
	 * @param fileName
	 * @param write_str
	 * @throws IOException
	 */
	public static void writeFileSdcardFile(String filePath,String fileName,
			String write_str) throws IOException {
		try {
			File dir = new File(filePath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
            File file = new File(filePath+"/"+fileName);
            FileOutputStream fout = new FileOutputStream(file);
			byte[] bytes = write_str.getBytes();

			fout.write(bytes);
			fout.flush();
			fout.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 读SD中的文件
	public static String readFileSdcardFile(String fileName) throws IOException {
		String res = null;
		try {
			FileInputStream fin = new FileInputStream(fileName);

			int length = fin.available();

			byte[] buffer = new byte[length];
			fin.read(buffer);

			res = EncodingUtils.getString(buffer, "UTF-8");

			fin.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	 public static void makeRootDirectory(String filePath) {  
	        File file = null;  
	        try {  
	            file = new File(filePath);  
	            if (!file.exists()) {  
	                file.mkdir();  
	            }  
	        } catch (Exception e) {  
	  
	        }  
	    }  
	 
	 public static String getFromAssets2(Context context ,String fileName) {
			InputStream is;
			String text = "";
			try {
				is = context.getResources().getAssets().open(fileName);

				int size = is.available();
				// Read the entire asset into a local byte buffer.
				byte[] buffer = new byte[size];
				is.read(buffer);
				is.close();

				// Convert the buffer into a string.
				text = new String(buffer, "UTF-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return text;
		}

	/** 从assets 文件夹中读取图片 */
	public static Drawable loadImageFromAsserts( String fileName) {
		try {
			InputStream is = MyApp.mcontext.getResources().getAssets().open(fileName);
			return Drawable.createFromStream(is, null);
		} catch (IOException e) {
			if (e != null) {
				e.printStackTrace();
			}
		} catch (OutOfMemoryError e) {
			if (e != null) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			if (e != null) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
