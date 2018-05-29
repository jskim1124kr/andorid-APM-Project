package com.example.kjs11.plz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tsengvn.typekit.TypekitContextWrapper;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;

public class ReportMain extends Activity implements View.OnClickListener{

    private static final String TAG = "ReportMain";

    Realm realm;
    Button btDelete, btJoin;
    TextView tvNotice;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private RealmQuery<Member> query;
    private RealmResults<Member> results;
    private boolean isLogin = false;
    private boolean isAdmin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_reportlist);

        RelativeLayout lin = (RelativeLayout) findViewById(R.id.login_main);
        lin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboard();
                return false;

            }
        });
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfiguration);

        btDelete = (Button) findViewById(R.id.bt_delete);
        btJoin = (Button) findViewById(R.id.bt_join);
        tvNotice = (TextView) findViewById(R.id.tv_notice);

        btDelete.setOnClickListener(this);
        btJoin.setOnClickListener(this);

        realm = Realm.getDefaultInstance();

        query = realm.where(Member.class);
        results = query.findAll();
        results = results.sort("id", Sort.DESCENDING);

        results.addChangeListener(new RealmChangeListener<RealmResults<Member>>() {
            @Override
            public void onChange(RealmResults<Member> element) {
                mAdapter = new MyAdapter(results);
                mRecyclerView.setAdapter(mAdapter);
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(results);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_delete:
                realm.executeTransaction(new Realm.Transaction(){
                    @Override
                    public void execute(Realm realm) {
                        Member mMember = realm.where(Member.class).findFirst(); //첫번재 데이터를 찾아서 지운다.
                        if (mMember != null){
                            mMember.deleteFromRealm();
                        } else {
                            return;
                        }
                    }
                });
                break;
            case R.id.bt_join:
                Intent joinIntent = new Intent(this, ReportInsert.class);
                startActivityForResult(joinIntent, 0);

                break;

        }
    }


    @Override
    public void onDestroy(){
        super.onDestroy();
        realm.removeAllChangeListeners();
        realm.close();
    }

    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(
                this.getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
    }
    @Override protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
}












