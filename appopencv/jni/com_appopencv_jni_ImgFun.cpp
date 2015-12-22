#include <opencv2/opencv.hpp>
#include <com_appopencv_jni_ImgFun.h>
using namespace cv;
JNIEXPORT jint JNICALL Java_com_appopencv_jni_ImgFun_testImg(JNIEnv *, jclass)
{
	Mat image;

	VideoCapture cap;
	int camOpen = cap.open(CV_CAP_ANY);

	namedWindow("window", CV_WINDOW_AUTOSIZE);

	while (true) {
		cap >> image;
		if(image.empty())
		{
			imshow("window", image);
		}

    // delay 33ms
		waitKey(33);        
	}
	return 1;
}