package com.csair.practice.chapter1;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * 使用lambda表达式来代替FileFilter，列出目录下的子目录名
 * @author bbfking
 *
 */
public class FileListLambda {
	public static void main(String[] args) {
		File file = new File("D:\\我的软件");
		File[] files = file.listFiles(File::isDirectory);
		List<File> filelist = Arrays.asList(files);
		filelist.forEach(x->System.out.println(x.getName()));
	}
}
