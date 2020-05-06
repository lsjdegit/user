package com.zt.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class BaseUtil {
private static Connection conn;
private static PreparedStatement pst;
private static ResultSet rs;
private static String Driver="com.mysql.jdbc.Driver";
private static String url="jdbc:mysql://localhost:3306/phone";
private static String usname="root";
private static String password="root";
//����
static{
	Properties proper=new Properties();
	String configFile = "db.properties";
	InputStream is=BaseUtil.class.getClassLoader().getResourceAsStream(configFile);
	try {
		proper.load(is);
		Driver=proper.getProperty("Driver");
		url=proper.getProperty("url");
		usname=proper.getProperty("usname");
		password=proper.getProperty("password");
	} catch (InvalidPropertiesFormatException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	} catch (IOException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}
}
public static void getConnection(){
	try {
		Class.forName(Driver);
		conn = DriverManager.getConnection(url,usname,password);
		System.out.println("���ӳɹ�");
	} catch (ClassNotFoundException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}
}
//��ɾ��
public static int executeUpdate(String sql,Object ...parem){
	int a=0;
	getConnection();
	try {
		pst = conn.prepareStatement(sql);
		if(parem!=null){
			for(int i=0;i<parem.length;i++){
				pst.setObject(i+1,parem[i] );
			}
			 a=pst.executeUpdate();
			 coloseAll();
		}
	} catch (SQLException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}
	return a;
}
//�鿴
public static ResultSet executeQuery(String sql,Object ...parem){
	getConnection();
	try {
		pst = conn.prepareStatement(sql);
		if(parem!=null){
			for(int i=0;i<parem.length;i++){
				pst.setObject(i+1,parem[i] );
			}
			rs=pst.executeQuery();
		}
	} catch (SQLException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}
	return rs;
}
//�ر�
public static void coloseAll(){
	try {
		//rs.close();
		pst.close();
		conn.close();
	} catch (SQLException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}catch (NullPointerException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}
}
}
