LOCAL_PATH := $(call my-dir)  
include $(CLEAR_VARS)  
include E:/Libraries/OpenCV-2.4.10-android-sdk/sdk/native/jni/OpenCV.mk  
LOCAL_MODULE     := image_proc  
LOCAL_SRC_FILES  := com_grayprocess_jni_ImgProc.cpp  
include $(BUILD_SHARED_LIBRARY)  