LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

OPENCV_CAMERA_MODULES:=on
OPENCV_INSTALL_MODULES:=on
include E:/Libraries/OpenCV-2.4.10-android-sdk/sdk/native/jni/OpenCV.mk
LOCAL_C_INCLUDES += $(LOCAL_PATH)

LOCAL_MODULE :=ImgFun
LOCAL_SRC_FILES :=com_appopencv_jni_ImgFun.cpp
LOCAL_LDLIBS +=  -llog -ldl
include $(BUILD_SHARED_LIBRARY)