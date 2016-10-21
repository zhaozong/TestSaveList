package com.slightech.testsavelist;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rokey on 2016/10/21.
 */

public class Util {
    Context context;
    private SharedPreferences sp;

    public Util(Context context) {
        this.context = context;
        sp = context.getSharedPreferences("res",Context.MODE_PRIVATE);
    }

    public  boolean saveArray(List<String> sKey) {

        SharedPreferences.Editor mEdit1= sp.edit();
        mEdit1.putInt("Status_size",sKey.size()); /*sKey is an array*/

        for(int i=0;i<sKey.size();i++) {
            mEdit1.remove("Status_" + i);
            mEdit1.putString("Status_" + i, sKey.get(i));
        }
        return mEdit1.commit();
    }
    public List<String> loadArray(Context mContext) {
        List<String> sKey = new ArrayList<>();
        sKey.clear();
        int size = sp.getInt("Status_size", 0);

        for(int i=0;i<size;i++) {
            sKey.add(sp.getString("Status_" + i, null));
        }
        return sKey;
    }
}
