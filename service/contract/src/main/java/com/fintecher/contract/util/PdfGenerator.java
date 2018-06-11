package com.fintecher.contract.util;

import com.fintecher.util.ZWStringUtils;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * pdf生成工具类
 * @author wangcy
 *
 */
public class PdfGenerator {
	private static final Logger logger = Logger.getLogger(PdfGenerator.class);
	public static void generate(String htmlStr, OutputStream out, String pictureName) {
		try {
			Document document = new Document(PageSize.A4);
			PdfWriter writer = PdfWriter.getInstance(document, out);
			writer.setViewerPreferences(PdfWriter.ALLOW_PRINTING | PdfWriter.PageLayoutSinglePage);
			document.open();
			XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(htmlStr.getBytes()), Charset.forName("UTF-8"), new AsianFontProvider());
			document.close();
//			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//			Document doc = builder.parse(new ByteArrayInputStream(htmlStr.getBytes("UTF-8")));
//			ITextRenderer renderer = new ITextRenderer();
//			String systemPath = PdfGenerator.class.getResource("/").getFile();
//			renderer.getFontResolver().addFont(systemPath+"simsun.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//			renderer.setDocument(doc, null);
//			if(!ZWStringUtils.isEmpty(pictureName)){
//				renderer.getSharedContext().setBaseURL("file:"+pictureName);
//			}
//			//解决图片的相对路径问题
//			renderer.layout();
//			renderer.createPDF(out);
//			renderer.getFontResolver().flushCache();
		} catch (Exception e) {
			logger.warn(e.getMessage(),e);
			e.printStackTrace();
		}finally{
			try {
				if(!ZWStringUtils.isEmpty(out)){
					out.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
//	public static void generate(String htmlStr, OutputStream out) {
//		try {
//			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//			Document doc = builder.parse(new ByteArrayInputStream(htmlStr.getBytes("UTF-8")));
//			ITextRenderer renderer = new ITextRenderer();
//			String systemPath = ContractUtil.class.getClassLoader().getResource("/").getFile();
//			renderer.getFontResolver().addFont(systemPath+"SIMSUN.TTC", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//			renderer.setDocument(doc, null);
//			renderer.layout();
//			renderer.createPDF(out);
//			out.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
