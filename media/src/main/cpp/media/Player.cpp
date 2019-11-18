//
// Created by ether on 2019/11/12.
//

#include "Player.h"

using namespace std;

Player::Player(Native4JavaCallback *callback_) {
    callback_sptr = shared_ptr<Native4JavaCallback>(callback_);
//    if (!msgQueue.empty()) {
//
//    }

}

Player::~Player() {

}

void test() {

}

void Player::prepare() {
    std::thread testThread([this]() {
        callback_sptr->callPrepare(false);
    });
    testThread.detach();

}
