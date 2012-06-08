package com.android.SAXParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ClinicQHandler extends DefaultHandler {

	String elementValue = null;
	Boolean elementOn = false;
	public static ClinicQGettersSetters data = null;

	public static ClinicQGettersSetters getXMLData() {
		return data;
	}

	public static void setXMLData(ClinicQGettersSetters data) {
		ClinicQHandler.data = data;
	}

	/**
	 * This will be called when the tags of the XML starts.
	 **/
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		elementOn = true;

		if (localName.equals("clinic")) {
			data = new ClinicQGettersSetters();
		} 
//		 else if (localName.equals("Q")) {
//		 /**
//		 * We can get the values of attributes for eg. if the clinic tag had
//		 an
//		 * attribute( <clinic attr= "clinic_id">1</clinic> ) we can get the
//		 value
//		 * "clinic_id". Below is an example of how to achieve this.
//		 *
//		 * String attributeValue = attributes.getValue("attr");
//		 * data.setAttribute(attributeValue);
//		 *
//		 * */
//		 }
	}

	/**
	 * This will be called when the tags of the XML end.
	 **/
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		elementOn = false;

		/**
		 * Sets the values after retrieving the values from the XML tags
		 * */
		if (localName.equalsIgnoreCase("booked_number"))
			data.setBooked_q(elementValue);
		else if (localName.equalsIgnoreCase("clinic_name"))
			data.setClinic_name(elementValue);
		else if (localName.equalsIgnoreCase("clinic_id"))
			data.setClinic_id(elementValue);
		else if (localName.equalsIgnoreCase("latest_q_no"))
			data.setLatest_q(elementValue);
	}

	/**
	 * This is called to get the tags value
	 **/
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {

		if (elementOn) {
			elementValue = new String(ch, start, length);
			elementOn = false;
		}

	}

}
