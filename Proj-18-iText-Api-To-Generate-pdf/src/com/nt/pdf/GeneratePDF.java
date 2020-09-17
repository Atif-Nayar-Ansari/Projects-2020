package com.nt.pdf;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePDF {

	public static void main(String[] args)throws Exception {
		
		//create file name
		String file= "F:\\Temp\\turtle24.pdf";
		
		//create document object
		Document document = new  Document();
		
		//get printwriter instance
		PdfWriter.getInstance(document, new FileOutputStream(file));
		
		//open document
		document.open();
		
		//add content
		Paragraph para = new Paragraph("This is My first para..");
		
		//add content
		document.add(para);
		
		//close documet
		document.close();
		
		System.out.println("finished..");
				
	}

}
