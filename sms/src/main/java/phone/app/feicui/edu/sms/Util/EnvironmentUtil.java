package phone.app.feicui.edu.sms.Util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Administrator on 2016/12/29.
 */

public class EnvironmentUtil {
    public void writeFileExteranlStorage() {
        OutputStream os = null;
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED) || !android.os.Environment.isExternalStorageRemovable()) {
            File file = new File(android.os.Environment.getExternalStorageDirectory() + File.separator + "test.txt");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                os = new FileOutputStream(file);
//                os = new FileOutputStream(file, true);
                os.write("I am an bird".getBytes());
                os.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public String readFileFromExteranlStorage() {
        InputStream is = null;
        String str = null;
        StringBuilder sb = null;
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED) || !android.os.Environment.isExternalStorageRemovable()) {
            File file = new File(android.os.Environment.getExternalStorageDirectory() + File.separator + "test.txt");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                is = new FileInputStream(file);
//                BufferedInputStream buffer=new BufferedInputStream(is);//追加的时候这样用
//                sb=new StringBuilder();
                byte[] b = new byte[1024];
                while (is.read(b) != -1) {
                    str = new String(b);
//                    sb.append(str);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        return sb.toString();
        return str;
    }
}
