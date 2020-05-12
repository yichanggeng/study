package com.taotao.utils;

import java.io.IOException;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

/**
 * 封装fastdfs客户端的操作
 * @author Administrator
 *
 */
public class FastDFSClient {

	
	private TrackerClient trackerClient = null;
	private TrackerServer trackerServer = null;
	
	private StorageServer storageServer = null;
	private StorageClient1 storageClient = null;
	
	
	public FastDFSClient( String conf ) {
		
		if( conf.contains("classpath:") ) {
			conf = conf.replace("classpath:", this.getClass().getResource("/").getPath() );
		}
		
		try {
			ClientGlobal.init( conf );
			
			trackerClient = new TrackerClient();
			trackerServer = trackerClient.getConnection();
			
			storageClient = new StorageClient1(trackerServer, storageServer);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	/**
	 * 上传指定的文件
	 * @param fileName 文件的全路径名
	 * @param extName  文件扩展名，不带. ; 传入null则会自动获取文件名的扩展名
	 * @param mataList 文件扩展信息，如创建时间等
	 * @return
	 */
	public String uploadFile( String fileName , String extName  , NameValuePair[] mataList ) {
		
		try {
			return storageClient.upload_file1(fileName, extName, mataList);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 上传指定的文件
	 * @param fileName 文件的全路径名
	 * @return
	 */
	public String uploadFile( String fileName ) {
		return this.uploadFile(fileName , null , null );
	}
	
	
	/**
	 * 上传指定的文件
	 * @param fileName 文件的全路径名
	 * @param extName  文件扩展名，不带. ; 传入null则会自动获取文件名的扩展名
	 * @return
	 */
	public String uploadFile( String fileName , String extName ) {
		return this.uploadFile(fileName , extName , null );
	}
	
	/**
	 * 上传文件内容
	 * @param fileContent 文件内容 ， 字节数组
	 * @param extName 文件扩展名，不带. ; 传入null则会自动获取文件名的扩展名
	 * @param mataList 文件扩展信息，如创建时间等
	 * @return
	 */
	public String uploadFile( byte[] fileContent , String extName , NameValuePair[] mataList ) {
		try {
			return storageClient.upload_file1(fileContent, extName, mataList);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 上传文件数据
	 * @param fileContent fileContent 文件内容 ， 字节数组
	 * @return 
	 */
	public String uploadFile( byte[] fileContent ) {
		return this.uploadFile(fileContent, null , null );
	}
	
	/**
	 * 文件上传
	 * @param fileContent fileContent 文件内容 ， 字节数组
	 * @param extName extName 文件扩展名，不带. ; 传入null则会自动获取文件名的扩展名
	 * @return
	 */
	public String uploadFile( byte[] fileContent , String extName ) {
		return this.uploadFile(fileContent, extName , null );
	}
	
}
