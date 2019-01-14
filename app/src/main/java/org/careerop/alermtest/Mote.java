package org.careerop.alermtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by JuyelRana on 17/05/26.
 */

public class Mote extends BroadcastReceiver {

    MediaPlayer player = null;
    private Context context;

    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        Toast.makeText(context, "Alarm worked.", Toast.LENGTH_LONG).show();
        player = MediaPlayer.create(context, R.raw.azan3);
        player.setLooping(true); // Set looping
        player.setVolume(100, 100);
        player.start();

    }


}
