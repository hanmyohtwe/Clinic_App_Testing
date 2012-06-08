package com.android.SAXParser;

import java.util.ArrayList;

import android.util.Log;

public class Clinic {

	private ArrayList<String> cName = new ArrayList<String>();
	private ArrayList<String> cLocation = new ArrayList<String>();
	private ArrayList<String> lat = new ArrayList<String>();
	private ArrayList<String> lng = new ArrayList<String>();
	private ArrayList<String> distance = new ArrayList<String>();
	private ArrayList<String> clinic_id = new ArrayList<String>();

	public ArrayList<String> getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName.add(cName);
		Log.i("This is the Clinic Name:", cName);
	}

	public ArrayList<String> getcLocation() {
		return cLocation;
	}

	public void setcLocation(String cLocation) {
		this.cLocation.add(cLocation);
		Log.i("This is the Clinic Location:", cLocation);
	}

	public ArrayList<String> getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat.add(lat);
		Log.i("This is the Clinic Latitude:", lat);
	}

	public ArrayList<String> getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng.add(lng);
		Log.i("This is the Clinic Longitude:", lng);
	}

	public ArrayList<String> getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance.add(distance);
		Log.i("This is the Clinic Distance:", distance);
	}

	public ArrayList<String> getClinic_id() {
		return clinic_id;
	}

	public void setClinic_id(String clinic_id) {
		this.clinic_id.add(clinic_id);
		Log.i("This is the Clinic ID:", clinic_id);
	}

}
