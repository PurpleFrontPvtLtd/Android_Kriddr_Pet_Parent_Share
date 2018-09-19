package com.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import com.bumptech.glide.Glide;



import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.util.ArrayList;
import java.util.Map;

import kriddrpetparent.com.kriddr.R;


/**
 * Created by pf-05 on 1/23/2018.
 */

public class SliderPagerAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;
    Context activity;
    ArrayList<Map<Integer,Object>> image_arraylist;



    public SliderPagerAdapter(Context activity, ArrayList<Map<Integer,Object>> image_arraylist) {

        this.activity = activity;
        this.image_arraylist = image_arraylist;
    }

    @Override
    public int getCount() {
        return image_arraylist.size();

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.layout_slider,container,false);
        SimpleDraweeView im_slider = (SimpleDraweeView) view.findViewById(R.id.im_slider);

        Map<Integer,Object> myList=image_arraylist.get(position);

       // Picasso.with(activity.getApplicationContext()).load((Integer) myList.get(0)).into(im_slider);
     //   Glide.with(activity).load((Integer)myList.get(0)).into(im_slider);
        //ResizeOptions resizeOptions=new ResizeOptions(im_slider.getWidth(),im_slider.getHeight());
        Uri uri = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                .path(String.valueOf((Integer)myList.get(0)))
                .build();
        final ImageRequest imageRequest2 =
                ImageRequestBuilder.newBuilderWithSource(uri)

                        .build();
        im_slider.setImageRequest(imageRequest2);


         container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View)object;
        container.removeView(view);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
