package com.csair.practice.chapter1;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * ��һ����ϰ
 * @author bbfking
 *
 */
public class FileListLambda {
	public static void main(String[] args) {
		listFiles();
		list();
	}
	/**
	 * ʹ��lambda���ʽ������FileFilter���г�Ŀ¼�µ���Ŀ¼��
	 */
	private static void listFiles(){
		File file = new File("D:\\�ҵ����");
		File[] files = file.listFiles(File::isDirectory);
		List<File> filelist = Arrays.asList(files);
		filelist.forEach(x->System.out.println(x.getName()));
	}
	
	private static void list(){
		File file = new File("D:\\�ҵ����");
		String[] filename = file.list((File x, String y)->y.endsWith(".exe"));
		List<String> strs = Arrays.asList(filename);
		strs.forEach(System.out::println);
	}
}
