package com.csair.mapreduce;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 找到大文件中，出现次数最多的IP前十位
 * 
 * @author bbfking
 *
 */
public class FindMostIp {
	public static void main(String[] args) throws IOException {
		Instant start = Instant.now();//开始计时
		//读取文件
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("e://fc1.txt")));
		//通过 Stream生成Map,key为IP值，value为该Ip重复的次数
		Map<String,Long> map = br.lines().parallel().collect(Collectors.groupingBy(x->x,Collectors.counting()));
		br.close();//关闭流
		//对Map的value进行排序，取重复次数最多的前十位，转成  IP:次数字符串
		String s = map.entrySet().stream().parallel().sorted((x,y)->{return -Long.compare(x.getValue(), y.getValue());}).
		map(x-> x.getKey()+":"+x.getValue()).limit(10).collect(Collectors.toList()).toString();
		System.out.println(s);
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("耗时："+timeElapsed.toMillis()/1000+"."+timeElapsed.toMillis()%1000+"秒");
	}
}
