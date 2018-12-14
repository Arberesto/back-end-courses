package it.sevenbits.courses.sm.log;

import static java.lang.Math.min;

class MessageTransition {
    private final MessageMap messageMap;

     MessageTransition() {
        this.messageMap = new MessageMap();
    }

     String getMessage(final String type,final String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.messageMap.getNextMessage(type).toString());
         if ("MESSAGE".equals(type)) {
             sb.append(message);
         }
         return sb.toString();
    }

}
