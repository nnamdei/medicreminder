package com.example.nd.medicreminder;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.media.Ringtone;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;

import com.example.nd.medicreminder.R;

/**
 * Created by Dina Saad on 21-Nov-16.
 */
public class Alert  extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_alert);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences( this.getBaseContext());
        String displayNotificationsKey = getString(R.string.pref_enable_Vibration_key);
        final boolean displayNotifications = prefs.getBoolean(displayNotificationsKey,
                    Boolean.parseBoolean(getString(R.string.pref_enable_Vibration_default)));


        final Vibrator vibrator;
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(displayNotifications) {

     vibrator.vibrate(new long[]{0, 200, 0}, 0);

}
       AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set title
        alertDialogBuilder.setTitle("Medication Reminder");

        // set dialog message
        alertDialogBuilder
                .setMessage("Time for your Medicine ")
                .setCancelable(false)
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        stopService(getIntent());
                        Ringtone r=AlarmReceiver.ringtone;
                        //alarmManager.cancel(pendingIntent);
                        if(displayNotifications) {
                        vibrator.cancel();}
                        r.stop();
                        dialog.cancel();
                        finish();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
}