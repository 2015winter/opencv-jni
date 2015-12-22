in order to implement cross-platform of the combination of cocos2dx and opencvCamera,the project is the first project which has work to use opencv camera.
~~~~~~~~~~~~~~~~~~~~~~~~~~~
attention:
there is some problem, e.g,there need 64-bit libopencv_java.so instead of 32-bit one, my android device may be not support 32-bit,this is to say, I have 
to load OpenCV Manager Library with 64-bit version, and while I find OpenCV Offical Sample Tutorial (Camera Preview,Camera Calibration) without using JNI has a run error (OpenCV was not initially ...) on my Android device,but the Samples (face-detection, Mixed Processing) using JNI can work well.
~~~~~~~~~~~~~~~~~~~~~~~~~~~
My Solution:
Copy the face-dectection/libs/armeabi-v7a/*.so to helloOpencv/libs/armeabi-v7a.