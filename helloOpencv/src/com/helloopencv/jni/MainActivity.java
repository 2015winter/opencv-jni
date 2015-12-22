package com.helloopencv.jni;
//default import
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.WindowManager;
//import myUse
import android.widget.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

//import opencv
import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Mat;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;
import org.opencv.android.JavaCameraView;

public class MainActivity extends Activity implements CvCameraViewListener2{
	
	//define my CameraView
	private CameraBridgeViewBase mOpenCvCameraView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.activity_main);
		mOpenCvCameraView = (CameraBridgeViewBase) findViewById(R.id.HelloOpenCvView);
		mOpenCvCameraView.setVisibility(SurfaceView.VISIBLE);		
		mOpenCvCameraView.setCvCameraViewListener(this);
//		ImageView iv = (ImageView) findViewById(R.id.myImageView);
//		Bitmap bm = getLocalBitmap("E:/MyWorkSpace/WorkSpaceCocos2dx/MyCocos2dx/MyCocosProjects/cpp-empty-test/Resources/bground1.bmp");
//		iv.setImageBitmap(bm);
	}
	
	public static Bitmap getLocalBitmap(String path)
	{
		try
		{
			FileInputStream fis = new FileInputStream(path);
			return BitmapFactory.decodeStream(fis);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Override 
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if(mOpenCvCameraView != null)
			mOpenCvCameraView.disableView();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
	/*	int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);*/
		return true;
	}
private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this){

	@Override
	public void onManagerConnected(int status) {
		switch(status){
		case LoaderCallbackInterface.SUCCESS:
		{
			Log.i("debug", "OpenCV loaded successfully");
			mOpenCvCameraView.enableView();
		}default:
		{
		// TODO Auto-generated method stub
		super.onManagerConnected(status);
		}break;
		}
	}
	
};
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_3, this, mLoaderCallback);
	}

	@Override
	public void onCameraViewStarted(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCameraViewStopped() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Mat onCameraFrame(CvCameraViewFrame inputFrame) {
		// TODO Auto-generated method stub
		return inputFrame.rgba();//get frames from camera and process it
	}
	
}
