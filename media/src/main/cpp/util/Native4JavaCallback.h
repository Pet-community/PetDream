//
// Created by ether on 2019/11/12.
//

#ifndef PETDREAM_NATIVE4JAVACALLBACK_H
#define PETDREAM_NATIVE4JAVACALLBACK_H

#include "LogUtil.h"
#include <jni.h>

#define Native4JavaCallback_TAG "Native4JavaCallback"

class Native4JavaCallback {
public:
    Native4JavaCallback(JNIEnv *env_,  _jobject *jobject_);

    virtual ~Native4JavaCallback();

    void callPrepare(bool state);

private:
    JNIEnv *env;
    jmethodID prepareId;
    jclass jlz;
    JavaVM *jvm;
    jobject jobj;
};


#endif //PETDREAM_NATIVE4JAVACALLBACK_H
