//
// Created by ether on 2019/11/12.
//

#ifndef PETDREAM_MESSAGEQUEUE_H
#define PETDREAM_MESSAGEQUEUE_H


#include "Message.h"
#include <queue>

class MessageQueue {
public:
    MessageQueue();

    virtual ~MessageQueue();

private:
    std::queue<Message> msgQueue;
};


#endif //PETDREAM_MESSAGEQUEUE_H
