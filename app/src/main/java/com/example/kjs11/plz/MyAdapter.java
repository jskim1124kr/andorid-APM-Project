package com.example.kjs11.plz;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import io.realm.RealmResults;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private RealmResults<Member> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mName;
        public TextView mAge;
        public TextView mEmail;
        public TextView mEmail2;
        public ImageView mPhoto;

        public ViewHolder(View v) {
            super(v);

            mName = (TextView) v.findViewById(R.id.info_text);
            mAge = (TextView) v.findViewById(R.id.info_age);
            mEmail = (TextView) v.findViewById(R.id.info_email);
            mEmail2 = (TextView) v.findViewById(R.id.info_email2);
        }
    }

    public MyAdapter(RealmResults<Member> myDataset) {
        mDataset = myDataset;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card, parent, false);

        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mName.setText("오늘 운동한 부위  " +"\n"+ mDataset.get(position).getName() +"\n");

        holder.mAge.setText("현재 몸무게 " +"\n"+ String.valueOf(mDataset.get(position).getAge())+"킬로그램"+"\n"); //int를 가져온다는점 유의

        holder.mEmail.setText("내일 운동할 부위  " +"\n"+ mDataset.get(position).getEmail()+"\n");

        holder.mEmail2.setText("TODAY " +"\n"+ mDataset.get(position).getPassword()+"\n");
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}







