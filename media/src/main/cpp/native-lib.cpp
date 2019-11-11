#include <jni.h>
#include <string>
#include "util/LogUtil.h"

extern "C" {
#include "includes/libavformat/avformat.h"
}

#define native_lib_TAG "native-lib"
JavaVM *jvm;


void test(JNIEnv *env, jobject thiz) {
    AVFormatContext avFormatContext;
    LOGI(native_lib_TAG, "%s:version=%d", __func__, avformat_version());
}


JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *reserved) {
    JNIEnv *env;
    jvm = vm;
    JNINativeMethod methods[]{
            {"test", "()V", (void *) &test}
    };
    if (vm->GetEnv((void **) &env, JNI_VERSION_1_6) != JNI_OK) {
        return -1;
    }
    jclass jlz = env->FindClass("com/pet/media/Player");

    env->RegisterNatives(jlz, methods, sizeof(methods) / sizeof(methods[0]));
    return JNI_VERSION_1_6;
}

