package com.example.getsensorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mTextSensors;
    SensorManager sensorManager;
    List<Sensor> sensorList;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextSensors = findViewById(R.id.textSensors);

        button = findViewById(R.id.retrieve_sensors_btn);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        mTextSensors.append("(# Sensors:" + sensorList.size() + ")\n\n");
        for (Sensor sensor : sensorList) {
            mTextSensors.append("Sensor name: " + sensor.getName() + "\n");
            mTextSensors.append("Sensor type: " + sensor.getType() + "\n\n");
        }
    }
}