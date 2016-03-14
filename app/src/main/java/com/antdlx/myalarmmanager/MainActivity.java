package com.antdlx.myalarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c=Calendar.getInstance();

                c.set(Calendar.YEAR,2016);
                c.set(Calendar.MONTH,Calendar.MARCH);//也可以填数字，0-11,一月为0
                c.set(Calendar.DAY_OF_MONTH, 14);
                c.set(Calendar.HOUR_OF_DAY, 20);
                c.set(Calendar.MINUTE, 58);
                c.set(Calendar.SECOND, 20);
                //设定时间为 2011年6月28日19点50分0秒
                //c.set(2011, 05,28, 19,50, 0);
                //也可以写在一行里

                AlarmManager alarmMgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
                int requestCode = 0;
                PendingIntent pendIntent = PendingIntent.getBroadcast(getApplicationContext(),
                        requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//                // 5秒后发送广播，只发送一次
//                int triggerAtTime = (int) SystemClock.elapsedRealtime() + 5 * 1000;
//                alarmMgr.set(AlarmManager.RTC_WAKEUP, triggerAtTime, pendIntent);

                alarmMgr.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendIntent);
                //取消alarm
//                alarmMgr.cancel(pendIntent);

            }
        });
}
}
