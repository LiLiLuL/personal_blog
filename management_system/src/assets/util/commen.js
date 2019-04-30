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

export {
    getNowDate
}