package com.kirill.phoneinfo;

import android.os.AsyncTask;

/**
 * Created by kirill on 9/27/14.
 * My GitHub: https://github.com/ZhukovKirill
 */
public class AsyncTaskAdId extends AsyncTask<String, String, String> {

//    public AsyncResponse delegate=null;

    @Override
    protected String doInBackground(String... params) {
        return "";
    }

    @Override
    protected void onPostExecute(String adId) {
        super.onPostExecute(adId);
        InfoActivity.getInfo().put("ADID", adId);
//        delegate.processFinish(adId);
    }


}
