//
// Created by ether on 2019/11/12.
//

#include "Native4JavaCallback.h"


Native4JavaCallback::Native4JavaCallback(JNIEnv *env_, jobject jobject_) : env(env_) {
    env->GetJavaVM(&jvm);
    jobj = env->NewGlobalRef(jobject_);
    jlz = env->GetObjectClass(jobj);
    prepareId = env->GetMethodID(jlz, "callPrepare", "(Z)V");
}

void Native4JavaCallback::callPrepare(bool state) {
    JNIEnv *jniEnv;
    if ((jvm->AttachCurrentThread(&jniEnv, nullptr)) != JNI_OK) {
        LOGE(Native4JavaCallback_TAG, "%s:jvm绑定线程失败", __func__);
        return;
    }
    jniEnv->CallVoidMethod(jobj, prepareId, state);
    jvm->DetachCurrentThread();
}


Native4JavaCallback::~Native4JavaCallback() {
    if (jobj != nullptr) {
        env->DeleteGlobalRef(jobj);
    }
    LOGE(Native4JavaCallback_TAG,"%s:已释放",__func__);
}

