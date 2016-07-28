package com.taojt.adapterviewflippertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private int[] imageIds = {R.mipmap.shuangzi, R.mipmap.shuangyu,
            R.mipmap.chunv, R.mipmap.tiancheng, R.mipmap.tianxie,
            R.mipmap.sheshou, R.mipmap.juxie, R.mipmap.shuiping,
            R.mipmap.shizi, R.mipmap.baiyang, R.mipmap.jinniu,
            R.mipmap.mojie};
    private AdapterViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flipper = (AdapterViewFlipper) findViewById(R.id.flipper);
        BaseAdapter baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(imageIds[i]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };
        flipper.setAdapter(baseAdapter);
    }
    public void prev(View source){
        flipper.showPrevious();
        flipper.stopFlipping();
    }
    public void auto(View source){
        flipper.startFlipping();

    }
    public void next(View source){
        flipper.showNext();
        flipper.stopFlipping();

    }

}
