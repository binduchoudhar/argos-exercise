package com.argos.exercise;

import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.Gson;

public class ExtractData {
	
	public static String getHukdData(){
		List<Product> products = new ArrayList<Product>();
		try {
			try {

				InputStream is = new URL("http://api.hotukdeals.com/rest_api/v2/?key=3d57d77cdaf9417c1621b12bf4e263ed")
						.openStream();
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(is);

				NodeList parentNodeList = doc.getElementsByTagName("deals");
				NodeList nodeList = parentNodeList.item(0).getChildNodes();
				
				
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node node = nodeList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						Product product = new Product();
						product.setName(getTextValue(element, "title"));
						product.setPrice(getBigDecimalValue(element, "price"));
						product.setTemperature(getBigDecimalValue(element, "temperature"));
						product.setImageUrl(getTextValue(element, "deal_image_highres"));
						products.add(product);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		return convertIntoString(products);
	}
	
	private static String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);
			if (el.getFirstChild() != null) {
				textVal = el.getFirstChild().getNodeValue();
			}
		}
		return textVal;
	}
	
	private static BigDecimal getBigDecimalValue(Element ele, String tagName) {
		BigDecimal textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);
			if (el.getFirstChild() != null) {
				textVal = new BigDecimal(el.getFirstChild().getNodeValue());
			}
		}
		return textVal;
	}
	
	private static String convertIntoString(List<Product> products){
		Gson gson = new Gson();
		return gson.toJson(products);
	}

}
