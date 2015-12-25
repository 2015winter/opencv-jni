package com.alexzhou.jni;

import android.os.Handler;
import android.os.Message;

/**
author:alexzhou 
email :zhoujiangbohai@163.com
date  :2012-12-14
 **/

public class JniTestHelper {
	
	private static Handler mHandler;
	
	public static void init(Handler handler)
	{
		JniTestHelper.mHandler = handler;
	}
	
    public static native void setPackageName(String packageName);
    
    public static native void exitApp();
    
    private static void showTipDialog(final String title, final String text)
    {
    	Message msg = mHandler.obtainMessage();
    	msg.what = JniTest.SHOW_DIALOG;
    	DialogMessage dm = new DialogMessage();
    	dm.title = title;
    	dm.msg = text;
    	msg.obj = dm;
    	msg.sendToTarget();
    }
    
}

