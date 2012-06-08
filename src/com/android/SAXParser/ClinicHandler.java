package com.android.SAXParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ClinicHandler extends DefaultHandler {

	String elementValue = null;
	Boolean elementOn = false;
	public static Clinic data = null;

	public static Clinic getXMLData() {
		return data;
	}

	public static void setXMLData(Clinic data) {
		ClinicHandler.data = data;
	}

	/**
	 * This will be called when the tags of the XML starts.
	 **/
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		elementOn = true;

		if (localName.equals("markers")) {
			data = new Clinic();
//		} 
//		else if (localName.equals("clinic")) {
//			data = new Clinic();
			// /**
			// * We can get the values of attributes for eg. if the clinic tag
			// had
			// an
			// * attribute( <clinic attr= "clinic_id">1</clinic> ) we can get
			// the
			// value
			// * "clinic_id". Below is an example of how to achieve this.
			// *
			// * String attributeValue = attributes.getValue("attr");
			// * data.setAttribute(attributeValue);
			// *
			// * */
		}
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
		if (localName.equalsIgnoreCase("clinic_name"))
			data.setcName(elementValue);
		else if (localName.equalsIgnoreCase("clinic_location"))
			data.setcLocation(elementValue);
		else if (localName.equalsIgnoreCase("lat"))
			data.setLat(elementValue);
		else if (localName.equalsIgnoreCase("lng"))
			data.setLng(elementValue);
		else if (localName.equalsIgnoreCase("distance"))
			data.setDistance(elementValue);
		else if (localName.equalsIgnoreCase("clinic_id"))
			data.setClinic_id(elementValue);
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
