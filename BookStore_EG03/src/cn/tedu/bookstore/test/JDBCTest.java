package cn.tedu.bookstore.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.tedu.bookstore.bean.User;
import cn.tedu.bookstore.utils.JDBCUtils;

public class JDBCTest {
	
	@Test
	public void test1(){
//		XMLWriter writer = null;
//		InputStream resourceAsStream = User.class.getClassLoader().getResourceAsStream("c3p0-config.xml");
//		try {
//			SAXReader read=new SAXReader();
//			Document read2 = read.read(resourceAsStream);
//			List<Element> selectNodes = read2.selectNodes("//property[@name='driverClass']");
//			for(Element e:selectNodes){
//				e.setText("666");
//				System.out.println(e.attributeValue("name"));
//				System.out.println(e.getText());
//				writer=new XMLWriter(new FileOutputStream(new  File("D:\\eclipsexin\\workspace\\BookStore_EG01\\build\\classes\\c3p0-config.xml")));
//				writer.write(read2);
//				writer.close();
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		JDBCUtils JDBCUtils=new JDBCUtils();
		Connection con=JDBCUtils.getConnection();
		System.out.println(con);
	}
}
