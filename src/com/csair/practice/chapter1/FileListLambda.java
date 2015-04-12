package com.csair.practice.chapter1;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * ʹ��lambda���ʽ������FileFilter���г�Ŀ¼�µ���Ŀ¼��
 * @author bbfking
 *
 */
public class FileListLambda {
	public static void main(String[] args) {
		File file = new File("D:\\�ҵ����");
		File[] files = file.listFiles(File::isDirectory);
		List<File> filelist = Arrays.asList(files);
		filelist.forEach(x->System.out.println(x.getName()));
	}
}
