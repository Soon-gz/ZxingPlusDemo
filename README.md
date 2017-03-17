# ZxingPlusDemo
当前最新版本：1.1.3
[我的博客,详细介绍使用方法](http://blog.csdn.net/sw5131899/article/details/55260525)

###二维码几乎成为现在安卓手机不可或缺的功能之一，不论是推广还是相互关注功能的需求，都需要二维码生成和扫描解析等等。Zxing是安卓手机二维码生成中非常好用的了。但是导入Zxing还需要自定义很多功能，那么我们可不可以把这些常用的功能封装好，做一个三方库，方便自己更方便大家呢。是的，方便方便....（手动偷笑）

##使用方法

* 1：导入gradle: compile 'com.singleshu:ZxingPlus:1.1.3'

* 2：6.0以上版本在自己的Activity中动态申请权限，封装好了一个权限请求工具类，
只是请求当前相机需要的权限。 PermissionUtils.getInstance().requestPermission(this);

* 3：我将二维码的扫描和图片解析，生成逻辑封装了在抽象父类BaseQRScanActivity，同事将
XML布局进行了分离。可以高扩展。自定义布局，自己设定界面以及扫描动画背景设定。为了方便调用，在抽象基础上再次抽象出一个默认的扫描界面，该界面有二维码扫描，闪光灯，图片解析三个基本功能。考虑到每个项目都有不同需求，所以将各个控件都通过get方法暴露给调用层，可以修改图片颜色背景，或者隐藏。
然后把扫描结果暴露给调用层。给出示例代码
```java
public class QRCodeScanAtivity extends DefaultQRScanActivity {

    //对控件的自定义，可以修改隐藏默认控件
    @Override
    protected void initCustomViewAndEvents() {

    }

    //扫描图片结果解析回调 recode二维码字符串
    @Override
    protected void onAlbumResult(int requestCode, int resultCode, String recode) {
        Bundle bundle = new Bundle();
        bundle.putString("result",recode);
        startActivity(new Intent(QRCodeScanAtivity.this,ResultActivity.class).putExtras(bundle));
        finish();
    }
    //二维码图片解析回调  rawResult 二维码字符串
    @Override
    protected void handleDecodeResult(String rawResult, Bundle bundle) {
        bundle.putString("result",rawResult);
        startActivity(new Intent(QRCodeScanAtivity.this,ResultActivity.class).putExtras(bundle));
        finish();
    }
}
```
但是记住6.0的要手动申请权限
```java
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test = (TextView) findViewById(R.id.test);
        imageView = (ImageView) findViewById(R.id.image1);
        //6.0加上动态权限申请，需要在外面Acitvity做申请
        PermissionUtils.getInstance().requestPermission(this);
    }
```

##版本更新
#1.1.4

新加入功能，生成带图标二维码，图标默认是取3/4显示，可自定义大小。

#使用介绍
```Java
 //生成二维码带图标,这和图片大小相关，默认取3/4显示
            case R.id.scorewithlogo:
                imageView.setImageBitmap(QRCodeUtil.createWithLogo(test.getText().toString(), BitmapFactory.decodeResource(getResources(), R.drawable.timg)));
                break;
```
```Java
//生成带图标二维码,自设置大小  取 multipart/divisor显示
            case R.id.custom_scorewithlogo:
                imageView.setImageBitmap(QRCodeUtil.createWithLogo(test.getText().toString(), BitmapFactory.decodeResource(getResources(), R.drawable.timg),1,4));
                break;
```
具体使用参照demo。



感谢各位对我的支持，觉得好用请给个star，欢迎fork。