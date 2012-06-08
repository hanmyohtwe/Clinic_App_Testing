package com.android.SAXParser;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ClinicView extends ListActivity {

	Clinic data;
	ArrayList<Clinic1> name = new ArrayList<Clinic1>();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);

		/**
		 * Get the view of the layout within the main layout, so that we can add
		 * TextViews.
		 **/
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
			URL url = new URL(
					"http://homes.soi.rp.edu.sg/101163/utsc/xml/get_clinic.php?lat=1.442543&lng=103.785618&radius=2");
			// URL url2 = new URL(
			// "http://homes.soi.rp.edu.sg/101163/utsc/xml/get_clinic.php?lat=1.442543&lng=103.785618&radius=1");
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
			ClinicHandler myXMLHandler = new ClinicHandler();
			xmlR.setContentHandler(myXMLHandler);
			xmlR.parse(new InputSource(url.openStream()));
			//

		} catch (Exception e) {
			System.out.println(e);
			
		}


		// //
		data = ClinicHandler.data;
		
				
		ArrayList<String> test=new ArrayList<String>();
		for (int i = 0; i < data.getcName().size(); i++) {
			test.add(data.getClinic_id().get(i).toString());
			
			Clinic1 clinicinfo = new Clinic1(data.getcName().get(i), data
					.getLat().get(i), data.getLng().get(i), data.getClinic_id()
					.get(i));
			name.add(clinicinfo);

		}
		
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,data.getcName()));
		


	}

	public void onListItemClick(ListView parent, View v, int position, long id) {
		/*
		 * Toast.makeText(this,"You have selected" + namelist.get(position),
		 * Toast.LENGTH_SHORT).show();
		 */

		// Intent intentNewAct=new Intent(getBaseContext(),
		// RestaurantInfo.class);
		// intentNewAct.putExtra("Shoe", index);
		// startActivity(intentNewAct);

		Intent i = new Intent(this, ClinicInfo.class);
		Bundle extras = new Bundle();
		// extras.putString("Name", ClinicI
		// extras.putString("Info", ClinicInfo.get(position).info);
		extras.putString("Id", name.get(position).getId());
		extras.putInt("Index", position);
		i.putExtras(extras);
		startActivityForResult(i, 1);
	}
}