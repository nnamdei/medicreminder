package com.example.nd.medicreminder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.nd.medicreminder.R;

public class DeleteMedicine  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine_delete);
        // setContentView(R.layout.allmedicine_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.delete_container, new AllMedicines_Fragment())
                    // .add(R.id.container, new AllMedicines_Fragment())
                    .commit();

        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);


        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        if (id == R.id.action_settings) {

            startActivity(new Intent(this, SettingActivity.class));

            return true;


        }

        return super.onOptionsItemSelected(item);
    }
}
