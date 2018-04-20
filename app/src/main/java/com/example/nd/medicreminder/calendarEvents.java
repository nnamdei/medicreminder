package com.example.nd.medicreminder;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.nd.medicreminder.R;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class calendarEvents extends AppCompatActivity {
    ArrayList<Medicine> Allmedicines=new ArrayList<Medicine>();
    CompactCalendarView compactCalendar;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());
    Calendar cal= Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);


        compactCalendar = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);

        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        int year = cal.get(Calendar.YEAR);
        String month = month_date.format(cal.getTime());
        String currentmonth=month+"- "+year;
        actionBar.setTitle(currentmonth);

        try {
            Allmedicines=getAllMedicines();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        for(int i=0;i<Allmedicines.size();i++) {
            cal.set(Calendar.DAY_OF_MONTH, Allmedicines.get(i).DoctorApp.get(Calendar.DAY_OF_MONTH));
            cal.set(Calendar.MONTH, Allmedicines.get(i).DoctorApp.get(Calendar.MONTH));
            cal.set(Calendar.YEAR, Allmedicines.get(i).DoctorApp.get(Calendar.YEAR));
            Event ev1 = new Event(Color.parseColor("#016544"), cal.getTimeInMillis());
            compactCalendar.addEvent(ev1);
        }
        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
               Context context = getApplicationContext();

                List<Event> events = compactCalendar.getEvents(dateClicked);
                if(events.toString()=="[]")
                { Toast.makeText(context,"No Events Planned for that day", Toast.LENGTH_SHORT).show();}
                else
                {Toast.makeText(context, "You have a Doctor Appointment for that day", Toast.LENGTH_SHORT).show();}

            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
            actionBar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));
        }
        });
    }

    private ArrayList<Medicine> getAllMedicines ()throws JSONException {
        SharedPreferences prefs = getSharedPreferences("Fav_data", 0);

        String favs_json = prefs.getString("favs", null);
        if (favs_json != null) {
            Type t = new TypeToken<List<Medicine>>() {
            }.getType();

            return new Gson().fromJson(favs_json, t);
        }

        return new ArrayList();
    }
}
