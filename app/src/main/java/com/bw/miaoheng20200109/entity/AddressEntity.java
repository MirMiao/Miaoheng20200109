package com.bw.miaoheng20200109.entity;

import java.util.List;

/**
 * 时间 :2020/1/9  9:11
 * 作者 :苗恒
 * 功能 :
 */
public class AddressEntity {

    /**
     * result : [{"address":"北京 海淀区 八维","createTime":1578581970000,"id":38383,"phone":"18580544823","realName":"张三","userId":13387,"whetherDefault":1,"zipCode":"101010"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * address : 北京 海淀区 八维
         * createTime : 1578581970000
         * id : 38383
         * phone : 18580544823
         * realName : 张三
         * userId : 13387
         * whetherDefault : 1
         * zipCode : 101010
         */

        private String address;
        private long createTime;
        private int id;
        private String phone;
        private String realName;
        private int userId;
        private int whetherDefault;
        private String zipCode;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getWhetherDefault() {
            return whetherDefault;
        }

        public void setWhetherDefault(int whetherDefault) {
            this.whetherDefault = whetherDefault;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }
    }
}
