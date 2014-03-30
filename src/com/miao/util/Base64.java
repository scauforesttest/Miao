package com.miao.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

public class Base64 {

	/**
	 * <p>���ļ�ת���base64�ַ�
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static String encodeBase64File(String path ) throws Exception
	{
		File file=new File(path);
		FileInputStream fis=new FileInputStream(file);
		byte[] buffer =new byte[(int)file.length()];
		fis.read(buffer);
		fis.close();
		return new BASE64Encoder().encode(buffer);
	}
	
	/**
	 * <p>��base64�ַ�������ļ�</P>
	 * @param code
	 * @param targetPath
	 * @throws Exception
	 */
	public static void decoderBase64File(String code,String targetPath) throws Exception{
		
		byte[] buffer=new BASE64Decoder().decodeBuffer(code);
		FileOutputStream fos=new FileOutputStream(targetPath);
		fos.write(buffer);
		fos.close();
	}
	
	/**
	 * <p>��base64������ı��ļ�
	 * @param code
	 * @param targetPath
	 * @throws Exception
	 */
	public static void toFile(String code,String targetPath) throws Exception{
		byte[] buffer=code.getBytes();
		FileOutputStream fos=new FileOutputStream(targetPath);
		fos.write(buffer);
		fos.close();
	}
	
}
