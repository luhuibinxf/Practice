package phone.app.feicui.edu.sms.Dao;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/12/29.
 */

public class SaveInstance {
    static Context mctx;
    private static SaveInstance saveInstance=null;
    SharedPreferences sp = null;
    SharedPreferences.Editor et;

    public SaveInstance() {
//        sp = mctx.getSharedPreferences("is", Context.MODE_APPEND);
        sp = mctx.getSharedPreferences("is", Context.MODE_APPEND);
        et = sp.edit();
    }

    public synchronized static SaveInstance getSaveInstance(Context ctx) {
        mctx = ctx;//上面为什么是静态的
        if (saveInstance == null) {
            return new SaveInstance();
        }
        return saveInstance;
    }

    public void putString(String key, String value) {
        et.putString("isSaved", "ok");
        et.commit();
    }

    public void putBoolean(String key, boolean value) {
        et.putBoolean(key, value);
        et.commit();
    }

    public void putFloat(String key, float value) {
        et.putFloat(key, value);
        et.commit();
    }

    public void putLong(String key, Long value) {
        et.putLong(key, value);
        et.commit();
    }

    public String getStringValue(String key) {
        return sp.getString(key, "unsaved");
    }

    public boolean getBooleanValue(String key) {
        return sp.getBoolean(key, false);
    }

    public Float getFloatValue(String key) {
        return sp.getFloat(key, 0f);
    }


//    public boolean getLongValue(String key) {
//        return sp.getBoolean(key, false);
//    }
}
