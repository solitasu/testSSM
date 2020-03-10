//时间格式
var _timeName = ["年", "月", "日", "时", "分", "秒"];
var _timeName1 = ["-", "-", " ", ":", ":", ""];


/**
 * 转换时间格式(通用)
 * 调用：getTimestealTime("",_timeName1,1,1,false);
 * @param nowtime 按秒级不断变化的时间，为空时为当前时间
 * @param name  时间显示格式,如：["年","月","日","时","分","秒"], 上方有全局变量
 * @param num1  数组中时间的起始位数
 * @param num2  数组中时间的结束位数，length-num2
 * @param type  时间显示格式是否为汉字，如果为false，数组长度减一
 * @returns
 */
function getTimestealTime(nowtime, name, num1, num2, type) {
    var datatime = "";
    if (nowtime == "") {
        datatime = new Data();
    } else {
        datatime = new Date(nowtime * 1000);
    }
    var year = datatime.getFullYear();
    var mon = datatime.getMonth() + 1;
    var days = datatime.getDate();
    var hours = datatime.getHours();
    var minutes = datatime.getMinutes();
    var seconds = datatime.getSeconds();
    if (mon < 10) {
        mon = "0" + mon;
    }
    if (days < 10) {
        days = "0" + days;
    }
    if (hours < 10) {
        hours = "0" + hours;
    }
    if (minutes < 10) {
        minutes = "0" + minutes;
    }
    if (seconds < 10) {
        seconds = "0" + seconds;
    }

    var data = [];
    data.push(year);
    data.push(mon);
    data.push(days);
    data.push(hours);
    data.push(minutes);
    data.push(seconds);

    var num = "";
    if (type && num2 != 0) {
        num = num2 + 1;
    } else {
        num = num2;
    }

    var dataTime = "";
    for (var i = num1; i < name.length - num; i++) {
        dataTime += data[i] + name[i];
    }

    return dataTime;
}

/**
 * ajax通用方法
 * @param url 接口地址
 * @returns
 */
function ajax(url) {
    var data = "";
    $.ajax({
        type: "get",
        async: false,    //false:同步加载  true:异步加载
        url: url,     //string类型，发送请求的地址
        cache: false,    //默认true， false时将不会从浏览器缓存中加载请求信息
        dataType: "json",    //要求返回的类型  有xml , html , script , json , jsonp , text 
        success: function (json) {
            data = json
        }
    })
    return data;
}

//是否移动
var mFlag = false;
//鼠标与div左上角相对位置
var divX, divY;

/**
 *
 * @param win : 整个div的id
 * @param oH21 : div头部id
 * @param type : 判断是否能移出页面，true为可以移出页面
 * @returns
 */
function popBox(win, oH21, type) {

    var divTopId = $("#" + oH21);
    var divId = $("#" + win);

    divTopId.mousedown(function (e) {
        mFlag = true;
        divX = e.pageX - divId[0].offsetLeft;
        divY = e.pageY - divId[0].offsetTop;
        //divId.fadeTo(20,0.5);//点击后开始拖动并透明
    });
    $(document).mousemove(function (e) {
        if (mFlag) {

            var iL = e.pageX - divX;
            var iT = e.pageX - divY;
            var maxL = $(document).width() - divId.width();
            var maxT = $(document).height() - divId.height;

            if (type != true) {
                iL = iL < 0 ? 0 : iL;
                iL = iL > maxL ? maxL : iL;
                iT = iT < 0 ? 0 : iT;
                iT = iT > maxT ? maxT : iT;
            }

            //画出新坐标
            divId.css("margin-left", "0").css("margin-top", "0");
            divId.css("left", iL + "px").css("top", iT + "px");
        }
    }).mouseup(function () {
        mFlag = false;
        //divId.fadeTo("fast",1);//松开鼠标后停止移动并恢复成不透明
    });
}

/**
 * 只能输入数字的input框
 * @param value
 * @returns
 */
function Mreg(value) {
    var reg = /^\d*\.{0,9}\d{0,9}$/;
    if (value.match(reg) == null) {
        return ""
    }
    return value;
}