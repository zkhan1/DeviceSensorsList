package com.example.environmentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.SENSOR_SERVICE;

public class MainActivity extends AppCompatActivity {

    // Global variables
    TextView txtView;
    ListView listView;
    SensorManager sensorManager;
    List<Sensor> sensorList;
    List<String> listString;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Attach reference variable, listView, to the layout's listview
       listView = (ListView) findViewById(R.id.listview1);
       // Attach reference variable, listString, to an ArrayList
       listString = new ArrayList<String>();
       //  This will check how many and what kind of sensors are available via api
        SensorManager sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        //List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_HEART_RATE);

        // This can check if a specific sensor (hw piece) is available on a device or not
        PackageManager PM = this.getPackageManager();
        //boolean ambientTemperature = PM.hasSystemFeature(PM.FEATURE_SENSOR_AMBIENT_TEMPERATURE);
        //boolean ambientTemperature2;

        for (int i = 0; i < sensorList.size(); i++) {
            // listString.add(sensorList.get(i).getName() + " available? " + PM.hasSystemFeature(PM+"."+"FEATURE_SENSOR_"+sensorList.get(i).getName().toUpperCase()));
            String str = sensorList.get(i).getName();
            String[] arrOfStr = str.split(" ", 2);

            // listString.add(sensorList.get(i).getName() + " available? " + PM.hasSystemFeature(sensorList.get(i).getName().toUpperCase()));
            //listString.add(sensorList.get(i).getName() + " Sensor Name " + arrOfStr[0].toString().toUpperCase());
            //listString.add(sensorList.get(i).getName() + " available? " + PM.hasSystemFeature(PM.FEATURE_SENSOR_STEP_COUNTER));
            //listString.add(sensorList.get(i).getName() + " available? " + PM.hasSystemFeature(PM+"."+"FEATURE_SENSOR_"+arrOfStr[0].toString().toUpperCase()));

            // Following are the important sensors. It is hard to know their exact names
            // so, it is better to find a word in sensor's string and find if HW is present or not
            if (sensorList.get(i).getName().toUpperCase().contains("STEP_COUNTER")) {
                listString.add(sensorList.get(i).getName() + " available? " + PM.hasSystemFeature(PM.FEATURE_SENSOR_STEP_COUNTER));
            } else if (sensorList.get(i).getName().toUpperCase().contains("BAROMETER"))  {
                listString.add(sensorList.get(i).getName() + " available? " + PM.hasSystemFeature(PM.FEATURE_SENSOR_BAROMETER));
            } else if (sensorList.get(i).getName().toUpperCase().contains("GYROSCOPE"))  {
            listString.add(sensorList.get(i).getName() + " available? " + PM.hasSystemFeature(PM.FEATURE_SENSOR_GYROSCOPE));
            } else if (sensorList.get(i).getName().toUpperCase().contains("ACCELEROMETER"))  {
                listString.add(sensorList.get(i).getName() + " available? " + PM.hasSystemFeature(PM.FEATURE_SENSOR_ACCELEROMETER));
            } else if (sensorList.get(i).getName().toUpperCase().contains("COMPASS"))  {
                listString.add(sensorList.get(i).getName() + " available? " + PM.hasSystemFeature(PM.FEATURE_SENSOR_COMPASS));
            } else if (sensorList.get(i).getName().toUpperCase().contains("LIGHT"))  {
                listString.add(sensorList.get(i).getName() + " available? " + PM.hasSystemFeature(PM.FEATURE_SENSOR_LIGHT));
            } else if (sensorList.get(i).getName().toUpperCase().contains("PROXIMITY"))  {
                listString.add(sensorList.get(i).getName() + " available? " + PM.hasSystemFeature(PM.FEATURE_SENSOR_PROXIMITY));
            } else if (sensorList.get(i).getName().toUpperCase().contains("AMBIENT"))  {
                listString.add(sensorList.get(i).getName() + " available? " + PM.hasSystemFeature(PM.FEATURE_SENSOR_AMBIENT_TEMPERATURE));
            } else if (sensorList.get(i).getName().toUpperCase().contains("HUMIDITY"))  {
                listString.add(sensorList.get(i).getName() + " available? " + PM.hasSystemFeature(PM.FEATURE_SENSOR_RELATIVE_HUMIDITY));
            } else if (sensorList.get(i).getName().toUpperCase().contains("HEART"))  {
                listString.add(sensorList.get(i).getName() + " available? " + PM.hasSystemFeature(PM.FEATURE_SENSOR_HEART_RATE));
            } else if (sensorList.get(i).getName().toUpperCase().contains("ECG"))  {
                listString.add(sensorList.get(i).getName() + " available? " + PM.hasSystemFeature(PM.FEATURE_SENSOR_HEART_RATE_ECG));
            } else if (sensorList.get(i).getName().toUpperCase().contains("STEP_DETECTOR"))  {
                listString.add(sensorList.get(i).getName() + " available? " + PM.hasSystemFeature(PM.FEATURE_SENSOR_STEP_DETECTOR));
            }

        }

        // Let's fill up the list of sensors available on my device
        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_2,
                android.R.id.text1, listString
        );

        listView.setAdapter(adapter);

        /* Another way of doing it but not necessary
        String sensorInfo = "";
        for (Sensor s : sensorList) {
            sensorInfo = sensorInfo + s.getName()+ "\n";
        }
        txtView = (TextView) findViewById(R.id.txtView1);
        //txtView.setText(sensorInfo);
        */




        // This can check if a specific sensor (hw piece) is available on a device or not
      //  PackageManager PM = this.getPackageManager();
        //boolean ambientTemperature = PM.hasSystemFeature(PM.FEATURE_SENSOR_AMBIENT_TEMPERATURE);
      //  boolean ambientTemperature2 = PM.hasSystemFeature(PM.FEATURE_SENSOR_BAROMETER);

        //txtView.setText(String.valueOf(ambientTemperature2));







    }
}
