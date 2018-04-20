package com.example.nd.medicreminder;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public interface  MedicineHandler {
    public void addToMedicineList(Medicine m) throws Exception;
    public void deleteFromMedicineList(Medicine m) throws Exception;
    public ArrayList<Medicine> getChosenMedicine() throws JSONException;
    public int findIndex(JSONArray ar, Medicine m) throws JSONException;
    boolean foundInMedicineList(JSONArray ar, Medicine m) throws JSONException;
}
