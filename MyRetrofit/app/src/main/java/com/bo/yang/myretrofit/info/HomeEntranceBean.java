package com.bo.yang.myretrofit.info;

import java.util.List;

/**
 * Created by yangbo on 2017/5/3.
 */
public class HomeEntranceBean {
    public List<ObjectBean> object;

    @Override
    public String toString() {
        return "HomeEntranceBean{" +
                "object=" + object +
                '}';
    }

    public static class ObjectBean {


        public String contentURL;
        public String name;
        public String tag;
        public String iconURL;
        public String objectId;
        public String createdAt;
        public String updatedAt;
        public String className;
        public String __type;

        @Override
        public String toString() {
            return "ObjectBean{" +
                    "contentURL='" + contentURL + '\'' +
                    ", name='" + name + '\'' +
                    ", tag='" + tag + '\'' +
                    ", iconURL='" + iconURL + '\'' +
                    ", objectId='" + objectId + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", updatedAt='" + updatedAt + '\'' +
                    ", className='" + className + '\'' +
                    ", __type='" + __type + '\'' +
                    '}';
        }
    }
}
