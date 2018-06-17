package site.iway.androidtouchblurview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLayoutChangeListener;

import site.iway.androidhelpers.AssetsHelper;
import site.iway.androidhelpers.BitmapHelper;
import site.iway.androidhelpers.TouchBlurView;
import site.iway.javahelpers.Scale;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TouchBlurView touchBlurView = (TouchBlurView) findViewById(R.id.touchBlurView);
        touchBlurView.addOnLayoutChangeListener(new OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom,
                                       int oldLeft, int oldTop, int oldRight, int oldBottom) {
                if (right - left > 0 && bottom - top > 0) {
                    Bitmap bitmap = AssetsHelper.readImageFile(MainActivity.this, "image.jpg");
                    bitmap = BitmapHelper.scale(bitmap, Scale.CenterFit, right - left, bottom - top);
                    TouchBlurView touchBlurView = (TouchBlurView) v;
                    touchBlurView.setBitmap(bitmap, 50, 100);
                }
            }
        });
    }
}
