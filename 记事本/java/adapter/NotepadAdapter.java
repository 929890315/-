package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.bean.NotepadBean;

import java.util.List;

public class NotepadAdapter extends BaseAdapter {
    private LayoutInflater LayoutInflater;
    private List<NotepadBean> list;
    public NotepadAdapter(Context context,List<NotepadBean> list){
        this.LayoutInflater= android.view.LayoutInflater.from(context);
        this.list=list;
    }
    @Override
    public int getCount(){
        return list==null ? 0 : list.size();
    }
    @Override
    public Object getItem(int position){
        return list.get(position);
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;
        if(convertView==null){
            convertView=LayoutInflater.inflate(R.layout.notepad_item_layout,null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        NotepadBean noteInfo=(NotepadBean) getItem(position);
        viewHolder.tvNotepadContent.setText(noteInfo.getNotepadContent());
        viewHolder.tvNotepadTime.setText(noteInfo.getNotepadTime());
        return convertView;
    }
    class ViewHolder{
        TextView tvNotepadContent;
        TextView tvNotepadTime;
        public  ViewHolder(View view){
            tvNotepadContent=(TextView) view.findViewById(R.id.item_content);
            tvNotepadTime=(TextView) view.findViewById(R.id.item_time);
        }
    }
}
