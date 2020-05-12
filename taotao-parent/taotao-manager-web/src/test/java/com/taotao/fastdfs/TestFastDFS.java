package com.taotao.fastdfs;

import java.io.IOException;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import com.taotao.utils.FastDFSClient;

/**
 *  测试fastdfs文件操作
 * @author Administrator
 *
 */
public class TestFastDFS {

	@Test
	public void testUploadFile() throws IOException, MyException {
		
		ClientGlobal.init( "G:\\workspace-git\\taotao\\taotao-parent\\taotao-manager-web\\src\\main\\resources\\resource\\client.conf" );
		
		TrackerClient trackerClient = new TrackerClient();
		TrackerServer trackerServer = trackerClient.getConnection();
		
		StorageServer storageServer = null;
		
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		
		
		NameValuePair [] nameList = new NameValuePair[3];
		
		nameList[0] = new NameValuePair("filename"	, "timg");
		nameList[1] = new NameValuePair("createTime"	, "2020-04-27 17:00:00");
		nameList[2] = new NameValuePair("createUser"	, "silian");
		
		String[] upload_files = storageClient.upload_file("H:\\备份\\timg.jpg", "jpg", nameList);
		
		for (String str : upload_files ) {
			System.out.println(str);
		}
		
		
		
		
		
	}
	
	@Test
	public void testFastDFSClient() {
		
		FastDFSClient client = new FastDFSClient("G:\\workspace-git\\taotao\\taotao-parent\\taotao-manager-web\\src\\main\\resources\\resource\\client.conf");
		NameValuePair [] nameList = new NameValuePair[3];
		
		nameList[0] = new NameValuePair("filename"	, "timg");
		nameList[1] = new NameValuePair("createTime"	, "2020-04-27 17:00:00");
		nameList[2] = new NameValuePair("createUser"	, "silian");
		String path = client.uploadFile("H:\\备份\\timg.jpg", "jpg", nameList);
		System.out.println(path);
		
	}
	
	
	
	
	
	
}
