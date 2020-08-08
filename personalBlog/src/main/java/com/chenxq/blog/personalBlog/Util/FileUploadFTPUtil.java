package com.chenxq.blog.personalBlog.Util;

import io.swagger.models.properties.Property;

//图片上传工具类
public class FileUploadFTPUtil {
	/**
	 * 属性集
	 * 
	 */
	private static Property property = null;
 
	/**
	 * FTP 登录用户名
	 */
	private static String userName;
 
	/**
	 * FTP 登录密码
	 */
	private static String passWord;
 
	/**
	 * FTP 服务器地址IP地址
	 */
	private static String hostName;
 
	/**
	 * FTP 端口
	 */
	private static int port;
 
	/**
	 * 文件服务器路径
	 */
	private static String path;
 
	/**
	 * 文件服务器访问地址
	 */
	private static String header;
 
	/**
	 * 配置文件的路径名
	 */
	private static String configFile = "application.properties";
	/**
	 * ftp文件下载的地址，例如：模板
	 */
	private static String tmstctpFilePath;
 
	/**
	 * 关闭连接-FTP方式
	 *
	 * @param ftp
	 *            FTPClient对象
	 * @return boolean
	 */
	public static boolean closeFTP(FTPClient ftp) {
		if (ftp.isConnected()) {
			try {
				ftp.disconnect();
				System.out.println("ftp已经关闭");
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
 
	/**
	 * 上传文件-FTP方式
	 *
	 * @param hostName
	 *            FTP服务器地址
	 * @param port
	 *            FTP服务器端口
	 * @param userName
	 *            FTP登录用户名
	 * @param passWord
	 *            FTP登录密码
	 * @param path
	 *            FTP服务器上传地址
	 * @param fileName
	 *            文件名称
	 * @param inputStream
	 *            输入流
	 * @return boolean
	 * @throws Exception
	 */
	public static String uploadFile(String partPath, byte[] decoderBytes,String imgName) throws Exception {
		FTPClient ftp = new FTPClient();
		try {
			setArg(configFile);
			// 连接FTP服务器
			ftp.connect(hostName, port);
			// 下面三行代码必须要，而且不能改变编码格式，否则不能正确下载中文文件
			ftp.setControlEncoding("GBK");
			FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
			conf.setServerLanguageCode("zh");
			// 登录ftp
			ftp.login(userName, passWord);
			if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
				ftp.disconnect();
				System.out.println("连接服务器失败");
			}
			System.out.println("登陆服务器成功");
			String realPath = path + "/" + partPath;
			boolean changeWD = ftp.changeWorkingDirectory(realPath);// 转移到指定FTP服务器目录
			if (!changeWD) {
				if (!CreateDirecroty(realPath, ftp)) {
					throw new Exception("创建远程文件夹失败!");
				}
			}
			FTPFile[] fs = ftp.listFiles();// 得到目录的相应文件列表
			String fileName = imgName;
			fileName = FtpUtils.changeName(fileName, fs);
			fileName = new String(fileName.getBytes("GBK"), "ISO-8859-1");
			realPath = new String(realPath.getBytes("GBK"), "ISO-8859-1");
			// 转到指定上传目录
			ftp.changeWorkingDirectory(realPath);
			// 将上传文件存储到指定目录
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			// 如果缺省该句 传输txt正常 但图片和其他格式的文件传输出现乱码
			ftp.storeFile(fileName, new ByteArrayInputStream(decoderBytes));
			// 退出ftp
			ftp.logout();
			System.out.println("上传成功。。。。。。");
			return header + realPath + fileName;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			// 关闭ftp连接
			closeFTP(ftp);
		}
	}
 
	/**
	 * 判断是否有重名文件
	 *
	 * @param fileName
	 * @param fs
	 * @return
	 */
	public static boolean isFileExist(String fileName, FTPFile[] fs) {
		for (int i = 0; i < fs.length; i++) {
			FTPFile ff = fs[i];
			if (ff.getName().equals(fileName)) {
				return true; // 如果存在返回 正确信号
			}
		}
		return false; // 如果不存在返回错误信号
	}
 
	/**
	 * 根据重名判断的结果 生成新的文件的名称
	 *
	 * @param fileName
	 * @param fs
	 * @return
	 */
	public static String changeName(String fileName, FTPFile[] fs) {
		int n = 0;
		// fileName = fileName.append(fileName);
		while (isFileExist(fileName.toString(), fs)) {
			n++;
			String a = "[" + n + "]";
			int b = fileName.lastIndexOf(".");// 最后一出现小数点的位置
			int c = fileName.lastIndexOf("[");// 最后一次"["出现的位置
			if (c < 0) {
				c = b;
			}
			StringBuffer name = new StringBuffer(fileName.substring(0, c));// 文件的名字
			StringBuffer suffix = new StringBuffer(fileName.substring(b + 1));// 后缀的名称
			fileName = name.append(a) + "." + suffix;
		}
		return fileName.toString();
	}
 
	/**
	 * 递归创建远程服务器目录
	 *
	 * @param remote
	 *            远程服务器文件绝对路径
	 *
	 * @return 目录创建是否成功
	 * @throws IOException
	 */
	public static boolean CreateDirecroty(String remote, FTPClient ftp) throws IOException {
		boolean success = true;
		String directory = remote.substring(0, remote.lastIndexOf("/") + 1);
		// 如果远程目录不存在，则递归创建远程服务器目录
		if (!directory.equalsIgnoreCase("/") && !ftp.changeWorkingDirectory(new String(directory))) {
 
			int start = 0;
			int end = 0;
			if (directory.startsWith("/")) {
				start = 1;
			} else {
				start = 0;
			}
			end = directory.indexOf("/", start);
			while (true) {
				String subDirectory = new String(remote.substring(start, end));
				if (!ftp.changeWorkingDirectory(subDirectory)) {
					if (ftp.makeDirectory(subDirectory)) {
						ftp.changeWorkingDirectory(subDirectory);
					} else {
						System.out.println("创建目录失败");
						success = false;
						return success;
					}
				}
				start = end + 1;
				end = directory.indexOf("/", start);
				// 检查所有目录是否创建完毕
				if (end <= start) {
					break;
				}
			}
		}
		return success;
	}
 
	/**
	 * 
	 * @param configFile
	 */
	private static void setArg(String configFile) {
		property = new Property(configFile);
		try {
			userName = property.getValue("ciftpUserName");
			passWord = property.getValue("ciftpPassword");
			hostName = property.getValue("ciftpHost");
			path = property.getValue("ciftpPath");
			port = Integer.parseInt(property.getValue("ciftpPort"));
			header = property.getValue("ciftpHeader");
			tmstctpFilePath=property.getValue("tmstctpFilePath");
		} catch (Exception e1) {
			System.out.println("配置文件 【" + configFile + "】不存在！");
			e1.printStackTrace();
		}

--------------------- 
作者：梧_桐 
来源：CSDN 
原文：https://blog.csdn.net/Qizonghui/article/details/82562068 
版权声明：本文为博主原创文章，转载请附上博文链接！
}
