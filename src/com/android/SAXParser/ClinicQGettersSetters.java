package com.android.SAXParser;

import java.util.ArrayList;

import android.util.Log;

public class ClinicQGettersSetters {

	private ArrayList<String> booked_q = new ArrayList<String>();
	private ArrayList<String> clinic_name = new ArrayList<String>();
	private ArrayList<String> clinic_id = new ArrayList<String>();
	private ArrayList<String> latest_q_no = new ArrayList<String>();

	public ArrayList<String> getBooked_q() {
		return booked_q;
	}

	public void setBooked_q(String booked_q) {
		this.booked_q.add(booked_q);
		Log.i("This is the Booke Q:", booked_q);
	}

	public ArrayList<String> getClinic_name() {
		return clinic_name;
	}

	public void setClinic_name(String clinic_name) {
		this.clinic_name.add(clinic_name);
		Log.i("This is the Clinic Name:", clinic_name);
	}

	public ArrayList<String> getClinic_id() {
		return clinic_id;
	}

	public void setClinic_id(String clinic_id) {
		this.clinic_id.add(clinic_id);
		Log.i("This is the Clinic ID:", clinic_id);
	}

	public ArrayList<String> getLatest_q() {
		return latest_q_no;
	}

	public void setLatest_q(String latest_q) {
		this.latest_q_no.add(latest_q);
		Log.i("This is the Latest Q:", latest_q);
	}

}
