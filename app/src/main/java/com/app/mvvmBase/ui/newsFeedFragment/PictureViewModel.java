package com.app.mvvmBase.ui.newsFeedFragment;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;

import com.bumptech.glide.Glide;
import com.app.mvvmBase.R;

public class PictureViewModel {

   public MutableLiveData<String> imageUrl = new MutableLiveData<>();

    public MutableLiveData<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(MutableLiveData<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(view);
    }
}
