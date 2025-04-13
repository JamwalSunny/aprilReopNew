package org.testing.runner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
public class TestRunner  {
		public static void main(String[] args) throws BiffException, IOException {

			XmlSuite xs = new XmlSuite(); //create xmlSuiteObject
			xs.setName("Suite1"); //set Suite name
			XmlTest xT= new XmlTest(xs); //set xmlTest object
			File f = new File("D:\\TestPlan.xls");//file connection
			
			Workbook wk = Workbook.getWorkbook(f); //create workbook object
			Sheet s = wk.getSheet(0); //create sheet object
			int rows = s.getRows(); //getting count of no of rows
			ArrayList<XmlClass> al = new ArrayList<XmlClass>(); //create arraylist object
			for(int i=1;i<rows;i++) //loop for rows
			{
				Cell c = s.getCell(4,i); //checking cell/column name,getting content of cell
				if(c.getContents().equals("Y")); //fetching status of test cases based on flag Y or N
				{
					Cell pkg =s.getCell(2,i);  //fetching the package name
					Cell class_name = s.getCell(3,i); //fetching class name
					String v = pkg.getContents()+"."+class_name.getContents(); //store it in a string object
					XmlClass c1 = new XmlClass(v); //create xmlclass object
					al.add(c1); //add xmlclass obj to arraylist
				}			
					
				}
			System.out.println(al.size()); //fetch size of arrayList
			xT.setClasses(al); //store all classes in a arraylist and give that arraylist to testobject.
			ArrayList<XmlTest> al2 = new ArrayList<XmlTest>(); //create XmlTest object
			al2.add(xT); 
			xs.setTests(al2);//store all the test object in arraylist and give that arraylist to the suite object
			ArrayList<XmlSuite> al3 = new ArrayList<XmlSuite>();
			al3.add(xs);  //store all the suite object in arraylist and give that arraylist to the testNg
			TestNG t = new TestNG();
			t.setXmlSuites(al3);
			t.run();
			}
			
			
			
			
		}

