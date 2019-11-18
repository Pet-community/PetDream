//
// Created by ether on 2019/11/12.
//

#ifndef PETDREAM_PLAYER_H
#define PETDREAM_PLAYER_H

#include <string>
#include <queue>
#include "../util/Native4JavaCallback.h"
#include "../util/Message.h"
#include <thread>
class Player {
public:

    Player(Native4JavaCallback *callback_);

    virtual ~Player();

    void prepare();

private:
    std::string a;
    std::shared_ptr<Native4JavaCallback> callback_sptr;
    std::queue<Message> msgQueue;
};


#endif //PETDREAM_PLAYER_H
