package com.grayprocess.jni;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
//import 
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener{

	private Button btnProc;  
    private ImageView imageView;  
    private Bitmap bmp;  
    
    //OpenCV类库加载并初始化成功后的回调函数，在此我们不进行任何操作  
    private BaseLoaderCallback  mLoaderCallback = new BaseLoaderCallback(this) {

		@Override
		public void onManagerConnected(int status) {
            switch (status) {  
            case LoaderCallbackInterface.SUCCESS:{  
                System.loadLibrary("image_proc");  
            } break;  
            default:{  
			// TODO Auto-generated method stub
                super.onManagerConnected(status);  
            } break;  
        }  
		}  
    	
   };    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
        btnProc = (Button) findViewById(R.id.btn_gray_process);  
        imageView = (ImageView) findViewById(R.id.image_view);  
        //将lena图像加载程序中并进行显示  
         bmp = BitmapFactory.decodeResource(getResources(), R.drawable.lena);  
        imageView.setImageBitmap(bmp);  
        btnProc.setOnClickListener(this);  
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
        int w = bmp.getWidth();  
        int h = bmp.getHeight();  
        int[] pixels = new int[w*h];       
        bmp.getPixels(pixels, 0, w, 0, 0, w, h);  
        int[] resultInt = ImgProc.grayProc(pixels, w, h);  
        Bitmap resultImg = Bitmap.createBitmap(w, h, Config.ARGB_8888);  
        resultImg.setPixels(resultInt, 0, w, 0, 0, w, h);  
        imageView.setImageBitmap(resultImg); 
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
        //通过OpenCV引擎服务加载并初始化OpenCV类库，所谓OpenCV引擎服务即是  
        //OpenCV_2.4.3.2_Manager_2.4_*.apk程序包，存在于OpenCV安装包的apk目录中  
        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_3, this, mLoaderCallback); 
	}
	
}
