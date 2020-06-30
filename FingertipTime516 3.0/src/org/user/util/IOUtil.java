package org.user.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOUtil {
	
	   public static FileInputStream readPicIn(String path){
	        FileInputStream picInputStream = null;
	        try {
	            picInputStream = new FileInputStream(new File(path));  //File����ָ��·��
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        return picInputStream;
	    }/*readPicIn*/

	    //��ȡͼƬ��ȡ����������������ڶ�ȡ
	    public static void readPicOut(InputStream in,  String targetPath){
	        File file = new File(targetPath);   //ͼƬ���λ��
	        String path = targetPath.substring(0,targetPath.lastIndexOf("/"));  //�ֽ�����·��,���һ��/λ���ļ���֮ǰ
	        if (!file.exists()){     //�ж��Ƿ����
	            new File(path).mkdir(); //���Ŀ���ļ������ڣ��ڸ�·�������ļ���
	        }

	        FileOutputStream fos = null;
	        try {
	            fos = new FileOutputStream(file);
	            /*�̶�д��*/
	            byte[] buff = new byte[1024];    //����һ���ֽ�������Ϊ��������
	            int len = 0;    //len��ס��ȡ���뻺�������ֽ���
	            while((len = in.read(buff)) != -1){    //�ж��Ƿ�����ļ�ĩβ
	                fos.write(buff, 0, len);    //�ӵ�һ���ֽڿ�ʼ�����ļ�д��len���ֽ�
	            }
	            fos.flush();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        finally {
	            if (fos!=null){
	                try {
	                    fos.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
}
