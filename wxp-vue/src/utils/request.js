import {getUserInfo,getToken} from './auth'

export function RequestMapParams(params){
    var userInfo= getUserInfo()
    let result={
        userInfo:{
            TOKEN:getToken(),
            USER_CODE:userInfo.user_code,
            USER_ID:userInfo.user_id,
            ORG_CODE:userInfo.org_code,
            USER_NAME:userInfo.user_name
        },
        reqTime: getCurrentDate(),
        dataInfo: params
    }
    return result
}


function  getCurrentTime(){
    return  (new Date()).valueOf()
}
 
Date.prototype.format = function(fmt) { 
    var o = { 
       "M+" : this.getMonth()+1,                 //月份 
       "d+" : this.getDate(),                    //日 
       "h+" : this.getHours(),                   //小时 
       "m+" : this.getMinutes(),                 //分 
       "s+" : this.getSeconds(),                 //秒 
       "q+" : Math.floor((this.getMonth()+3)/3), //季度 
       "S"  : this.getMilliseconds()             //毫秒 
   }; 
   if(/(y+)/.test(fmt)) {
           fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
   }
    for(var k in o) {
       if(new RegExp("("+ k +")").test(fmt)){
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        }
    }
   return fmt; 
}  

export function getCurrentDate(){
    var time = new Date().format("yyyy-MM-dd hh:mm:ss");
      return time
}