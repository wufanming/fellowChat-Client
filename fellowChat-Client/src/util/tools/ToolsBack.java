package util.tools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.StringTokenizer;

public class ToolsBack {

	public static String[] getConfig(){
		String[] str = new String[2];//字符串数组用于保存数据库名，和密码信息
		File file = new File("manChatBackground.cfg");
		if(file.exists()){
			try{
				FileInputStream fin = new FileInputStream(file);
				BufferedInputStream bin = new BufferedInputStream(fin);
				int length = bin.available();//返回可以从此输入流读取（或跳过）、且不受此输入流接下来的方法调用阻塞的估计字节数
				if(length>0){
					byte[] data = new byte[length];
					bin.read(data);
					//将读出的内容转换成字符串
					String s = new String(data);
					//stringTokenizer允许应用程序将字符串分解为标记
					StringTokenizer token = new StringTokenizer(s," ");
					str[0] = token.nextToken();
				//	str[1] = token.nextToken();
					
					return str;
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static void setConfig(String configText)
	{
		try {
			 File file = new File("manChatBackground.cfg");
				FileOutputStream fout = null;
				
					fout = new FileOutputStream(file);
			
				BufferedOutputStream bout = new BufferedOutputStream(fout);
				
				bout.write(configText.getBytes());
				bout.flush();
				bout.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	   
	}
}
