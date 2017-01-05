package phone.app.feicui.edu.sms.Dao;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Xml;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import phone.app.feicui.edu.sms.Bean.SmsBean;

/**
 * Created by Administrator on 2016/12/28.
 */

public class SmsDao {
    private Context ctx;

    public SmsDao(Context cot) {
        ctx = cot;
    }

    private ArrayList<SmsBean> getAllSms() {//.获取短信数据
        ArrayList<SmsBean> RAl = new ArrayList<SmsBean>();//
        return RAl;
    }

    public ArrayList<SmsBean> readList() {//注：(xml文件开头的第一句话)encoding:xml文件的编码  standalone:是否独立
        ArrayList arrayList = null;
        SmsBean bean = null;
        try {
            XmlPullParser xm = Xml.newPullParser(); //1.通过Xml获取一个XmlPullParser对象
            //2.设置XmlPullParser对象的参数，需要解析的是哪个xml文件,设置一个文件读取流
            AssetManager assets = ctx.getAssets();//通过context获取一个资产管理者对象
            InputStream i = assets.open("back.xml"); //通过资产管理者对象能获取一个文件读取流
//            InputStream i = ctx.getAssets().open("back.xml");
            xm.setInput(i, "utf-8");
            int eType = xm.getEventType(); //3.获取当前xml行的事件类型
            while (eType != XmlPullParser.END_DOCUMENT) {//4.判断事件类型是否是文档结束的事件类型
                String currentName = xm.getName();
                switch (eType) {
                    case XmlPullParser.START_TAG:
                        if (currentName.equals("Smss")) {
                            arrayList = new ArrayList<SmsBean>();
                        } else if (currentName.equals("Sms")) {
                            bean = new SmsBean();
                            bean.id = xm.getAttributeValue(null, "id");//这样写的作用
                        } else if (currentName.equals("num")) {
                            bean.num = xm.nextText();//这样写的作用
                        } else if (currentName.equals("msg")) {
                            bean.msg = xm.nextText();
                        } else if (currentName.equals("date")) {
                            bean.data = xm.nextText();
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (currentName.equals("Sms")) {
                            arrayList.add(bean);
                        }
                        break;
                    default:
                        break;
                }
                eType = xm.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }


    public void writeToXml() {
        ArrayList<SmsBean> arrayList = getAllSms();
        XmlSerializer xs = Xml.newSerializer();
        try {
            ArrayList<SmsBean> allSms = getAllSms();//.获取短信数据
            //1.通过Xml获取一个XmlSerializer对象
            xs.setOutput(ctx.openFileOutput("backupsms2.txt", Context.MODE_PRIVATE), "utf-8");  //2.设置XmlSerializer的一些参数，比如：设置xml写入到哪个文件中
            xs.startDocument("utf-8", true);//3.序列化一个xml的声明头
            xs.startTag(null, "Smss");  //4.序列化一个根节点的开始节点
            for (SmsBean bean : arrayList) {  //5.循环遍历list集合序列化一条条短信
                xs.startTag(null, "sms");
                xs.attribute(null, "id", bean.id + "");
                xs.startTag(null, "num");//开始标签
                xs.text(bean.num);
                xs.endTag(null, "num");//结束标签
                xs.startTag(null, "msg");
                xs.text(bean.msg);
                xs.endTag(null, "msg");
                xs.startTag(null, "date");
                xs.text(bean.data);
                xs.endTag(null, "date");
                xs.endTag(null, "sms");
            }
            xs.endTag(null, "Smss");
            xs.endDocument();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
