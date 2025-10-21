package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import model.MyMember;
import model.MyOrder;

public class Tool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void saveMyMember(MyMember member) {
		try {
			FileOutputStream fos = new FileOutputStream("MyMember.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(member);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static MyMember readMyMember() {
		MyMember m = null;
		
		try {
			FileInputStream fis = new FileInputStream("MyMember.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			m = (MyMember)ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}
	
	public static void saveMyOrder(MyOrder order) {
		try {
			FileOutputStream fos = new FileOutputStream("MyOrder.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(order);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static MyOrder readMyOrder() {
		MyOrder o = null;
		
		try {
			FileInputStream fis = new FileInputStream("MyOrder.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			o = (MyOrder)ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return o;
	}
	
	public static void createExcelFile(String fileName, String sheetName) {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			HSSFWorkbook excelBook = new HSSFWorkbook();
			HSSFSheet sheet = excelBook.createSheet(sheetName);
			
			HSSFRow row = sheet.createRow(0);
			row.createCell(0).setCellValue(Tool.getColumnNames()[0]);
			row.createCell(1).setCellValue(Tool.getColumnNames()[1]);
			row.createCell(2).setCellValue(Tool.getColumnNames()[2]);
			row.createCell(3).setCellValue(Tool.getColumnNames()[3]);
			row.createCell(4).setCellValue(Tool.getColumnNames()[4]);
			row.createCell(5).setCellValue(Tool.getColumnNames()[5]);
			row.createCell(6).setCellValue(Tool.getColumnNames()[6]);
			row.createCell(7).setCellValue(Tool.getColumnNames()[7]);
			
			excelBook.write(fos);
			excelBook.close();
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insertExcelFile(String fileName, String sheetName, MyOrder order) {
		try {
			FileInputStream fis = new FileInputStream(fileName);
			HSSFWorkbook excelBook = new HSSFWorkbook(fis);
			HSSFSheet sheet = excelBook.getSheet(sheetName);
			int currentRows = sheet.getPhysicalNumberOfRows();
			
			HSSFRow row = sheet.createRow(currentRows);
			row.createCell(0).setCellValue(order.getOrderId());
			row.createCell(1).setCellValue(order.getBlackTea());
			row.createCell(2).setCellValue(order.getGreenTea());
			row.createCell(3).setCellValue(order.getOolongTea());
			row.createCell(4).setCellValue(order.getMilkTea());
			row.createCell(5).setCellValue(order.getTotal());
			row.createCell(6).setCellValue(order.getPayType());
			row.createCell(7).setCellValue(order.getUserId());
			
			FileOutputStream fos = new FileOutputStream(fileName);
			excelBook.write(fos);
			excelBook.close();
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String[] getColumnNames() {
		return new String[] {"訂單編號", "紅茶", "綠茶", "烏龍茶", "奶茶", "總計", "付款方式", "用戶編號"};
	}

}
