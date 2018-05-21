# AndroidTouchBlurView
Android 滑动模糊视图。

### 本应用的示例

![image](https://github.com/iWay7/AndroidTouchBlurView/blob/master/sample.gif)   

### 本示例基于 AndroidHelpers 库，访问 https://github.com/iWay7/AndroidHelpers 添加依赖。

#### 开始使用：
##### 类似这样，在布局文件中声明一个 TouchBlurView 视图即可：
```
<site.iway.helpers.TouchBlurView
    android:id="@+id/touchBlurView"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```
##### 设置图片，模糊半径，笔触大小等参数：
```
TouchBlurView touchBlurView = (TouchBlurView) findViewById(R.id.touchBlurView);
touchBlurView.setBitmap(AssetsHelper.readImageFile(this, "image.jpg"), 50, 50);
```

##### 默认显示位置在左上角，可以根据布局的宽高并借助 BitmapHelper 改变：
```
TouchBlurView touchBlurView = (TouchBlurView) findViewById(R.id.touchBlurView);
touchBlurView.addOnLayoutChangeListener(new OnLayoutChangeListener() {
    @Override
    public void onLayoutChange(View v, int left, int top, int right, int bottom,
                               int oldLeft, int oldTop, int oldRight, int oldBottom) {
        if (right - left > 0 && bottom - top > 0) {
            Bitmap bitmap = AssetsHelper.readImageFile(MainActivity.this, "image.jpg");
            bitmap = BitmapHelper.scale(bitmap, Scale.CenterCrop, right - left, bottom - top);
            TouchBlurView touchBlurView = (TouchBlurView) v;
            touchBlurView.setBitmap(bitmap, 50, 100);
        }
    }
});
```