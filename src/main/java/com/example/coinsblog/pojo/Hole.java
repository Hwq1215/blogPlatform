package com.example.coinsblog.pojo;

import lombok.*;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Hole {
    Integer id;
    String content;
    Timestamp timestamp;
    Integer status;
    String url;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStartDay(){
        int year= timestamp.getYear() + 1900;
        int month = timestamp.getMonth() + 1;
        int day= timestamp.getDate();
        return ""+ year +"-"+ (month>9?"":"0") + month + "-" + (day>9?"":"0") + day;
    }

    public String getLastDay(){

        Timestamp nowTime = new Timestamp(System.currentTimeMillis());
        int comp = 0;
        if((comp = nowTime.getYear() - this.timestamp.getYear())>0){
            if(comp == 1){
                return "去年";
            }
            return ""+comp+"年前";
        }else if((comp = nowTime.getMonth() - this.timestamp.getMonth())>0){
            if(comp == 1){
                return "上个月";
            }
            return ""+comp+"月前";
        }else if((comp = nowTime.getDate() - this.timestamp.getDate())>0){
            if(comp == 1){
                return "昨天";
            }else if(comp == 2){
                return "前天";
            }
            return ""+comp+"天前";
        }else if((comp = nowTime.getHours() - this.timestamp.getHours())>0){
            return ""+comp+"小时前";
        }else{
            comp = nowTime.getHours() - this.timestamp.getHours();
            return ""+comp+"分钟前";
        }
    }
}
