package com.example.getsensorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView mTxtSensors;
    SensorManager sensorMgr;
    List<Sensor> sensorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtSensors = findViewById(R.id.txtSensors);
        sensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorList = sensorMgr.getSensorList(Sensor.TYPE_ALL);
        mTxtSensors.append("(# Sensor: "+ sensorList.size() + ")\n\n");

        for(Sensor sensor: sensorList){
            mTxtSensors.append("Sensor name: "+ sensor.getName()+ "\n");
            mTxtSensors.append("Sensor type: "+ sensor.getType() +"\n\n");

        }

    }
}