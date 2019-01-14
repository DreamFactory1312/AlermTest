package org.careerop.alermtest;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    String msg = "Android : ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(msg, "The onCreate() event");

        ((Button) findViewById(R.id.btnStart)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(v);
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));
                cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
                cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));
                cal.set(Calendar.DATE, cal.get(Calendar.DATE));
                cal.set(Calendar.HOUR_OF_DAY, 15);
                cal.set(Calendar.MINUTE, 23);
                cal.set(Calendar.SECOND, 00);


                Intent intent = new Intent(getApplicationContext(), Mote.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 1234, intent, PendingIntent.FLAG_UPDATE_CURRENT | Intent.FILL_IN_DATA);

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
                Toast.makeText(getApplicationContext(), "Alarm Set.", Toast.LENGTH_LONG).show();
            }
        });

        ((Button) findViewById(R.id.btnStop)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(v);
            }
        });
    }

    public void startService(View view) {
        startService(new Intent(getBaseContext(), MyService.class));
    }

    // Method to stop the service
    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), MyService.class));
    }
}
