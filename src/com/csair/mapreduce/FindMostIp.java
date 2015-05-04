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
 * �ҵ����ļ��У����ִ�������IPǰʮλ
 * 
 * @author bbfking
 *
 */
public class FindMostIp {
	public static void main(String[] args) throws IOException {
		Instant start = Instant.now();//��ʼ��ʱ
		//��ȡ�ļ�
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("e://fc1.txt")));
		//ͨ�� Stream����Map,keyΪIPֵ��valueΪ��Ip�ظ��Ĵ���
		Map<String,Long> map = br.lines().parallel().collect(Collectors.groupingBy(x->x,Collectors.counting()));
		br.close();//�ر���
		//��Map��value��������ȡ�ظ���������ǰʮλ��ת��  IP:�����ַ���
		String s = map.entrySet().stream().parallel().sorted((x,y)->{return -Long.compare(x.getValue(), y.getValue());}).
		map(x-> x.getKey()+":"+x.getValue()).limit(10).collect(Collectors.toList()).toString();
		System.out.println(s);
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("��ʱ��"+timeElapsed.toMillis()/1000+"."+timeElapsed.toMillis()%1000+"��");
	}
}
