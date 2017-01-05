package com.example.myapplication.Activity.dao;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/24.
 */

public class MyExpandableListAdapter extends BaseExpandableListAdapter {
    Context context;//上下文
    LayoutInflater inflater; //声明一个布局管理器对象
    Map<String, Object> map;   //声明一个map对象
    List<Map<String, Object>> group;//声明一个组集合
    List<List<Map<String, Object>>> child; //声明一个子元素集合

    /**
     * 自定义适配器的构造函数
     *
     * @param context 上下文
     * @param group   组集合
     * @param child   子元素集合
     */
    public MyExpandableListAdapter(Context context, List<Map<String, Object>> group, List<List<Map<String, Object>>> child) {
        this.context = context;//初始化上下文
        inflater = LayoutInflater.from(context); //初始化布局管理器对象
        this.group = group;//初始化组集合
        this.child = child; //初始化子元素集合
    }

    /**
     * ExpandableListAdapter(这是一个类)里面的所有条目
     * 都可用吗？如果是yes，就意味着所有条目可以选择和点击了。
     * 返回值：返回True表示所有条目均可用。
     */
    public boolean areAllItemsEnabled() {
        return true;
    }

    /**
     * 获取组长
     *
     * @return
     */
    @Override
    public int getGroupCount() {
        return group.size();
    }


    /**
     * 获取指定组中子元素的个数
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        return child.get(groupPosition).size();
    }

    //    public long getCombinedChildId(long groupId , long childId ) {
//        // TODO Auto-generated method stub
//        return 0;
//    }
//    public long getCombinedGroupId(long groupId) {
//        // TODO Auto-generated method stub
//        return 0;
//    }

    /**
     * 得到指定组的组数据
     *
     * @param groupPosition:指定的组的位置
     * @return 返回指定组的组数据
     */
    @Override
    public Object getGroup(int groupPosition) {
//        group.get(groupPosition);//获取map对象
//        group.get(groupPosition).get("Group");//获取key值为Group的数据
        return group.get(groupPosition).get("Group");
    }

    /**
     * 获取指定组中的指定子元素数据。
     *
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        /**
         * child.get(groupPosition);//是得到groupPosition处的list对象
         *child.get(groupPosition).get(childPosition);//得到child的map对象
         *child.get(groupPosition).get(childPosition).get("child");//是得到key值为Child的值
         */

        return child.get(groupPosition).get(childPosition).get("child");
    }

    /**
     * 获取指定组的Id
     *
     * @param groupPosition
     * @return
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * 获取指定组中的指定子元素ID，这个ID在组里一定是唯一的。联合ID（getCombinedChildId(long, long)）在所有条*目（所有组和所有元素）中也是唯一的。
     *
     * @param groupPosition
     * @return
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;//子元素的位置
    }

    /**
     * 组和子元素是否持有稳定的ID,也就是底层数据的改变不会影响到它们。
     *
     * @return 返回一个Boolean类型的值，
     */
    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolderGroup viewHolder;
        if (convertView == null) {//判断convertView是否为空，convertView是RecycleBean调用getScrapView函数得到废弃已缓存的view
            viewHolder = new ViewHolderGroup();//初始化控件管理器对象
            convertView = inflater.inflate(R.layout.parent_layout, null);//重新加载布局
            viewHolder.logo_tv = (TextView) convertView.findViewById(R.id.logo);//给组元素绑定ID
            viewHolder.arrow = (ImageView) convertView.findViewById(R.id.arrow);//给组元素箭头绑定ID
            convertView.setTag(viewHolder);//convertView将viewHolder设置到Tag中，以便再次绘制ExpandableListView时从Tag中取出viewHolder;
        } else {//如果convertView不为空，即getScrapView得到废弃已缓存的view，从Tag中取出之前存入的viewHolder
            viewHolder = (ViewHolderGroup) convertView.getTag();
        }
        viewHolder.logo_tv.setText(getGroup(groupPosition).toString());//设置组值
        if (isExpanded) {//如果组是展开状态，箭头向下
            viewHolder.arrow.setImageResource(R.mipmap.bomb0);
        } else {//如果组是伸缩状态，箭头向右
            viewHolder.arrow.setImageResource(R.mipmap.ic_launcher);
        }
        return convertView; //返回得到的指定组的视图对象
    }

    /**
     * 获取一个视图对象，显示指定组中的指定子元素数据。
     *
     * @param groupPosition 组位置（该组内部含有子元素）
     * @param childPosition 子元素位置（决定返回哪个视图）
     * @param isLastChild   子元素是否处于组中的最后一个
     * @param convertView   重用已经有的视图对象，它是RecycleBin缓存机制调用getScrapView方法获取废弃已缓存的view.返回的视图(View)对象始终依附于的视图组。通俗的说是它的父视图。
     * @param parent
     * @param groupPosition
     * @param childPosition
     * @param isLastChild
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolderChild viewHolderChild;
         /*当convertView为空，也就是没有废弃已缓存 view时，将执行下面方法，调用layoutinflate的
         * inflate()方法来加载一个view。
         * 如有不懂，请点击：http://blog.csdn.net/libmill/article/details/49644743
         */
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.child_layout, null); //重新加载布局
            viewHolderChild = new ViewHolderChild();//初始化控件管理器（自己命名的）
            viewHolderChild.tv = (TextView) convertView.findViewById(R.id.tv);//绑定控件id
             /*convertView的setTag将viewHolderChild设置到Tag中，以便系统第二次绘制
                ExpandableListView时从Tag中取出
            */
            convertView.setTag(viewHolderChild);
        } else {//当convertView不为空时，从Tag中取出viewHolderChild
            viewHolderChild = (ViewHolderChild) convertView.getTag();
        }
//        viewHolderChild.tv.setText(getChild(groupPosition, childPosition).toString());//给子元素的TextView设置值???????为什么（什么时候有用？？？？）
        return convertView;//返回视图对象，这里是childPostion处的视图
    }

    /**
     * 是否选中指定位置上的子元素。
     *
     * @param groupPosition
     * @param childPosition
     * @return
     */

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    /**
     * 如果当前适配器不包含任何数据则返回True。经常用来决定一个空视图是否应该被显示。
     * 一个典型的实现将返回表达式getCount() == 0的结果，但是由于getCount()包含了头部和尾部，适配器可能需要不同的行为。
     */
//    public boolean isEmpty() {
//        // TODO Auto-generated method stub
//        return false;
//    }

    /**
     * 当组收缩状态的时候此方法被调用。
     */
//    public void onGroupCollapsed(int groupPosition) {
//        // TODO Auto-generated method stub
//
//    }

    /**
     * 当组展开状态的时候此方法被调用。
     */
//    public void onGroupExpanded(int groupPosition) {
//        // TODO Auto-generated method stub
//
//    }

    /**
     * 注册一个观察者(observer)，当此适配器数据修改时即调用此观察者。
     *
     * @param observer:当数据修改时通知调用的对象
     */
//    public void registerDataSetObserver(DataSetObserver observer) {
//        // TODO Auto-generated method stub
//
//    }

    /**
     * 取消先前通过registerDataSetObserver(DataSetObserver)方式注册进该适配器中的观察者对象。
     *
     * @param observer 取消这个观察者的注册
     */
//    public void unregisterDataSetObserver(DataSetObserver observer) {
//        // TODO Auto-generated method stub
//
//    }

    /**
     * 组控件管理器
     */
    class ViewHolderGroup {
        TextView logo_tv;
        ImageView arrow;
    }

    /**
     * 子控件管理器
     */
    class ViewHolderChild {
        TextView tv;
    }
}
