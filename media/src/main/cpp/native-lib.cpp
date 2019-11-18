#include <jni.h>
#include <string>
#include "util/LogUtil.h"
#include "util/Native4JavaCallback.h"
#include "media/Player.h"

extern "C" {
#include "include/libavformat/avformat.h"
}

#define native_lib_TAG "native-lib"
JavaVM *jvm;
Native4JavaCallback *callback;
Player *player;

void init(JNIEnv *env, jobject thiz) {
    if (!callback) {
        callback = new Native4JavaCallback(env, thiz);
    }
    if (!player) {
        player = new Player(callback);
    }
}

void prepare(JNIEnv *env, jobject thiz, jstring path_) {
    player->prepare();
}


JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *reserved) {
    JNIEnv *env;
    jvm = vm;
    JNINativeMethod methods[]{
            {"init",    "()V",                   (void *) &init},
            {"prepare", "(Ljava/lang/String;)V", (void *) &prepare}
    };
    if (vm->GetEnv((void **) &env, JNI_VERSION_1_6) != JNI_OK) {
        return -1;
    }
    jclass jlz = env->FindClass("com/pet/media/Player");

    env->RegisterNatives(jlz, methods, sizeof(methods) / sizeof(methods[0]));
    return JNI_VERSION_1_6;
}

