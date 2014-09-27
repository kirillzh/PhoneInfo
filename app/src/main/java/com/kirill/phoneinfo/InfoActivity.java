package com.kirill.phoneinfo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

import java.io.IOException;
import java.util.HashMap;


public class InfoActivity extends Activity {

    private static Context context;
    private static HashMap<String, String> info = new HashMap<String, String>();

    public static HashMap<String, String> getInfo() {
        return info;
    }

    public static Context getAppContext() {
        return InfoActivity.context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InfoActivity.context = getApplicationContext();

        info.put("Device Name", android.os.Build.MODEL);
        info.put("Product Name", android.os.Build.PRODUCT);
        info.put("Manufacturer Name", android.os.Build.MANUFACTURER);
        info.put("Product Name", android.os.Build.PRODUCT);
        info.put("Brand Name", android.os.Build.BRAND);

        info.put("ADID", "" + getAdId());
        info.put("IMEI", ((TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId());
        setContentView(R.layout.activity_info);

        final ListView listViewInfo = (ListView) findViewById(R.id.list_view_info);
        ListViewArrayAdapter arrayAdapter = new ListViewArrayAdapter(info);
        listViewInfo.setAdapter(arrayAdapter);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    private static void putContent() {

    }

    private static String getAdId() {


        AdvertisingIdClient.Info adInfo = null;
        try {
            adInfo = AdvertisingIdClient.getAdvertisingIdInfo(InfoActivity.getAppContext());
        } catch (IOException e) {
            // Unrecoverable error connecting to Google Play services (e.g.,
            // the old version of the service doesn't support getting AdvertisingId).
        } catch (GooglePlayServicesNotAvailableException e) {
            // Google Play services is not available entirely.
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        }
        return adInfo != null ? adInfo.getId() : null;
        //final boolean isLAT = adInfo.isLimitAdTrackingEnabled();
    }
}
