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
	 * <p>将文件转码成base64字符
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
	 * <p>将base64字符解码成文件</P>
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
	 * <p>将base64保存成文本文件
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
