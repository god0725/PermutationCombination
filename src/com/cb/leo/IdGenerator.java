package com.cb.leo;

    public class IdGenerator {
        int lastIdUsed;

        public synchronized int incrementValue(){
            return ++lastIdUsed;
        }
    }

