//
// Created by ether on 2019/11/11.
//

#ifndef PETDREAM_LOGUTIL_H
#define PETDREAM_LOGUTIL_H

#include <android/log.h>

#define LOGE(LOG_TAG, ...) __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)
#define LOGV(LOG_TAG, ...) __android_log_print(ANDROID_LOG_VERBOSE,LOG_TAG,__VA_ARGS__)
#define LOGI(LOG_TAG, ...) __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define LOGW(LOG_TAG, ...) __android_log_print(ANDROID_LOG_WARN,LOG_TAG,__VA_ARGS__)

#endif //PETDREAM_LOGUTIL_H
