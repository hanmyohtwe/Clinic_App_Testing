package com.android.SAXParser;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ClinicInfo extends Activity {

	ClinicQGettersSetters data;
	
	ArrayList<Clinic> name;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);

		String clinic_url;
		
		int Index = 0;
		String id="";
		Bundle extras = getIntent().getExtras();

		if (extras != null) {
			Index = extras.getInt("Index");
			id=extras.getString("Id");
		}
		/**
		 * Get the view of the layout within the main layout, so that we can add
		 * TextViews.
		 **/
		View layout = findViewById(R.id.layout);
		//
		// /**
		// * Create TextView Arrays to add the retrieved data to.
		// **/
		TextView booked_q[];
		//
		TextView clinic_name[];
		TextView clinic_id[];
		TextView test[] = new TextView[1];

		//
		try {
			//
			// /**
			// * Create a new instance of the SAX parser
			// **/
			SAXParserFactory saxPF = SAXParserFactory.newInstance();
			SAXParser saxP = saxPF.newSAXParser();
			XMLReader xmlR = saxP.getXMLReader();
			//
			
			
			
			
			clinic_url = "http://homes.soi.rp.edu.sg/101163/utsc/xml/get_q.php?clinic_id="+id;
//			String clinic_url1=clinic_url+id;
			URL url = new URL(clinic_url);
			
			// // URL
			// // of
			// // the
			// // XMLv
			// // double lat;
			// // double long;
			//
			// // String var="        "+st+"/"
			//
			// /**
			// * Create the Handler to handle each of the XML tags.
			// **/
			ClinicQHandler myXMLHandler = new ClinicQHandler();
			xmlR.setContentHandler(myXMLHandler);
			xmlR.parse(new InputSource(url.openStream()));

		} catch (Exception e) {
			System.out.println(e);
		}
		//
		data = ClinicQHandler.data;

		//
		// /**
		// * Makes the TextView length the size of the TextView arrays by
		// getting
		// * the size of the
		// **/
		booked_q = new TextView[data.getBooked_q().size()];
		clinic_name = new TextView[data.getClinic_name().size()];
		clinic_id = new TextView[data.getClinic_id().size()];
		// lat = new TextView[data.getLat().size()];
		// lng = new TextView[data.getLng().size()];

		//
		// /**
		// * Run a for loop to set All the TextViews with text until the size of
		// * the array is reached.
		// *
		// **/
		for (int i = 0; i < data.getClinic_name().size(); i++) {
			

			booked_q[i] = new TextView(this);
			booked_q[i].setText("Booked Q = " + data.getBooked_q().get(i));

			clinic_name[i] = new TextView(this);
			clinic_name[i].setText("Clinic Name = "
					+ data.getClinic_name().get(i));
			
			clinic_id[i] = new TextView(this);
			clinic_id[i].setText("Clinic ID = "
					+ data.getClinic_id().get(i));
//			
//			test[i] = new TextView(this);
//			test[i].setText("URL" +clinic_url+id);
			
		
			

			//
			// lat[i] = new TextView(this);
			// lat[i].setText("Clinic ID = " + data.getLat().get(i));
			//
			// lng[i] = new TextView(this);
			// lng[i].setText("Latest Q = " + data.getLng().get(i));
			//
			// distance[i] = new TextView(this);
			// distance[i].setText("Latest Q = " + data.getDistance().get(i));

			((ViewGroup) layout).addView(booked_q[i]);
			((ViewGroup) layout).addView(clinic_name[i]);
			 ((ViewGroup) layout).addView(clinic_id[i]);
//			 ((ViewGroup) layout).addView(test[i]);
			// ((ViewGroup) layout).addView(distance[i]);

		}

	}
}