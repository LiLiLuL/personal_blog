function time(){
    var vWeek,vWeek_s,vDay;
    vWeek = ["星期天","星期一","星期二","星期三","星期四","星期五","星期六"];
    let  date =  new Date();
    let year = date.getFullYear();
    let month = date.getMonth() + 1;
    if(month<10){
        month='0'+month;
    }
    let day = date.getDate();
    if(day<10){
        day='0'+day;
    }
    let  hours = date.getHours();
    if(hours<10){
        hours='0'+hours;
    }
    let minutes = date.getMinutes();
    if(minutes<10){
        minutes='0'+minutes;
    }
    let  seconds = date.getSeconds();
    if(seconds<10){
        seconds='0'+seconds
    }
    vWeek_s = date.getDay();
    return year + "." + month + "." + day  + "\t" + hours + ":" + minutes +":" + seconds + "\t" + vWeek[vWeek_s];
    
    };
function getNowDate(){
    let date = new Date();
    let seperator1 = "-";
    let year = date.getFullYear();
    let month = date.getMonth() + 1;
    let strDate = date.getDate();
    let hour=date.getHours();
    let min=date.getMinutes();
    let second=date.getSeconds();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    if(hour>=1&&hour<=9){
        hour="0"+hour;
    };
    if(min>=1&&min<=9){
        min="0"+min;
    };
    if(second>=1&&second<=9){
        second="0"+second;
    }

    let currentdate = year + seperator1 + month + seperator1 + strDate;
    let currenttime=hour+":"+min+":"+second;
    return currentdate+" "+currenttime;
}
export{
    time,getNowDate
}