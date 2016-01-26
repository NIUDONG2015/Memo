package com.android.yzd.memo.model.Realm;

import android.content.Context;

import com.android.yzd.memo.bean.God;

import java.util.ArrayList;
import java.util.Collections;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Administrator on 2016/1/26.
 */
public class RealmHelper {
    private static RealmHelper instances;
    private Context mContext;

    private RealmHelper(Context context){
        mContext = context;
    }
    public static RealmHelper getInstances(Context context){
        if (instances == null) {
            instances = new RealmHelper(context);
        }
        return instances;
    }
    public static ArrayList<God> selector(Context context, int godType){
        Realm realm = Realm.getInstance(context);
        RealmQuery<God> realmQuery = realm.where(God.class);
        RealmQuery<God> godRealmQuery = realmQuery.equalTo("godType", godType);
        RealmResults<God> realmResults = godRealmQuery.findAll();
        if (realmResults != null && realmResults.size() > 0) {
            ArrayList<God> godList = new ArrayList<>();
            for (God god : realmResults) {
                godList.add(god);
            }
            Collections.reverse(godList);
            return godList;
        }
        return null;
    }
}
