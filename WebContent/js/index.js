//页面加载后执行
$(document).ready(function () {
    AcquireData();
    test();
    dragDiv();   //拖拽div

    //点击页面跳到最上层
    $(".scrollTop").click(function () {
        $(document.documentElement).animate({
            scrollTop: 0
        }, 200);
        //支持chrome
        $(document.body).animate({
            scrollTop: 0
        }, 200);
    })

    //鼠标点击切换悬浮
    $("#mouseT").click(function () {
        $("#mouseT").removeClass("mouseTop").addClass("mouseBot");
        $("#mouseB").removeClass("mouseBot").addClass("mouseTop");
    })
    $("#mouseB").click(function () {
        $("#mouseB").removeClass("mouseTop").addClass("mouseBot");
        $("#mouseT").removeClass("mouseBot").addClass("mouseTop");
    })

    select(); //easyui下拉框
})

//向后台获取数据
function AcquireData() {
    var url = "./../database/getAcquireData.do";
    var data = ajax(url);
    $("#AcquireData").text(data);
}

//向后台发送数据
function database() {
    var username = $("#username").val();
    var password = $("#password").val();
    var age = $("#age").val();
    var url = './../database/getInsertDatabase.do?username=' + username + '&password=' + password + '&age=' + age;
    var data = ajax(url);
    $("#hint").text(data);
}

//不停变动的时间
window.setInterval(function () {
    var nowtime = null;
    nowtime = new Date().getTime() / 1000;
    var aaa = getTimestealTime(nowtime, _timeName1, 0, 0, false); //转化时间格式
    $("#nowtime").text(aaa);
}, 1000);


function test() {
    var list = [];
    list.push("2015-03-02");
    list.push("2015-03-01");
    list.push("2015-03-03");
    list.push("2015-03-05");

}

//自动增加div
function divMap(a) {
    for (var i = 0; i < a; i++) {
        var str = '<div id="echarts' + i + '" class="echartsDIV" style="height:400px;width:500px;"></div>'
        $("#body").append(str);
    }
}

//弹窗移动
function popMove() {
    var o = document.getElementById("win");
    var oBtn = document.getElementsByTagName("button")[0];
    var oClose = document.getElementById("close");
    var oH2 = oWin.getElementsByTagName("h2")[0];
    var bDrag = false;  //设为通用方法后，将这句设为全局变量
    var disX = disY = 0;
    oBtn.onclick = function () {
        oWin.style.display = "block"
    };
    oClose.onclick = function () {
        oWin.style.display = "none"

    };
    oClose.onmousedown = function (event) {
        (event || window.event).cancelBubble = true;
    };
    oH2.onmousedown = function (event) {
        var event = event || window.event;
        bDrag = true;
        disX = event.clientX - oWin.offsetLeft;
        disY = event.clientY - oWin.offsetTop;
        this.setCapture && this.setCapture();
        return false
    };
    document.onmousemove = function (event) {
        if (!bDrag) return;
        var event = event || window.event;
        var iL = event.clientX - disX;
        var iT = event.clientY - disY;
        var maxL = document.documentElement.clientWidth - oWin.offsetWidth;
        var maxT = document.documentElement.clientHeight - oWin.offsetHeight;

        //只能在div内移动，如需移出浏览器，删除这段
        iL = iL < 0 ? 0 : iL;
        iL = iL > maxL ? maxL : iL;
        iT = iT < 0 ? 0 : iT;
        iT = iT > maxT ? maxT : iT;
        //

        oWin.style.marginTop = oWin.style.marginLeft = 0;
        oWin.style.left = iL + "px";
        oWin.style.top = iT + "px";
        return false
    };
    document.onmouseup = window.onblur = oH2.onlosecapture = function () {
        bDrag = false;
        oH2.releaseCapture && oH2.releaseCapture();
    };
}

//淡入淡出效果
function fadeToggle() {
    $("#fadeToggle").fadeToggle(2000);  //淡入淡出,2000毫秒
    //$("#fadeToggle").fadeToggle(2000,incident);  //淡入淡出时执行incident()方法
    //$("#fadeToggle").fadeToggle("slow");  //或
    //$("#fadeToggle").fadeToggle("");  //或
    //$("#fadeToggle").fadeOut("");   //淡出
    //$("#fadeToggle").fadeIn("");    //淡入
}

//滑动效果
function slideToggle() {
    //$("#slideToggle").slideToggle(1000);  //滑入滑出,1000毫秒
    //$("#slideToggle").slideToggle(2000,aaa);  //滑入滑出时执行aaa()方法
    $("#slideToggle").slideDown(1000).slideUp(1000);  //向下再向上
    //$("#slideToggle").slideUp();  //向上
}

//div滑动放大动画
function animate2() {
    $("#animate2").animate({
        left: '250px',
        height: '+=150px',
        width: '+=150px'
    });
}

//div滑动动画
function animate3() {
    var div = $("#animate3");
    div.animate({height: '300px', opacity: '0.4'}, "slow").animate({fontSize: '3em'}, "slow");  //可以连续执行n个方法
    div.animate({width: '300px', fontSize: '4em', opacity: '0.8'}, "slow");
    div.animate({height: '100px', opacity: '0.4'}, "slow");
    div.animate({fontSize: '3em'}, "slow");
    div.animate({width: '100px', opacity: '0.8'}, "slow");
    div.animate({fontSize: '4em'}, "slow");
}

//添加文本
function addtext() {
    $("#addtext").text(function (i, origText) {
        return origText + i + origText;
    })
}

//切换class
function changetext() {
    $("#changetext").toggleClass("animate2");  //切换class
    //$("#changetext").addClass("animate2")    //添加class
    //$("#changetext").removeClass("animate2")  //删除class
}

//获取文件内的数据
function getLocalText() {
    $("#getLocalText").load("../file/aaa.txt #p1");   //获取aaa.text文件内id=p1的内容
    /*$("#getLocalText").load("../file/aaa.txt",function(responseTxt,statusTxt,xhr){
          if(statusTxt=="success")
            alert("外部内容加载成功！");
          if(statusTxt=="error")
            alert("Error: "+xhr.status+": "+xhr.statusText);
        });*/
}


//页面滚动显示或隐藏div
$(window).scroll(function () {
    if (window.document.body.scrollTop > 600) {
        $("#fixed-hide").show();
    } else {
        $("#fixed-hide").hide();
    }
})

//最后执行
window.onload = function () {
    popMove();   //弹窗移动
};


function aaaa() {
    var url = "./../file/upload.do";
}

var dragDiv;

//拖拽div
function dragDiv() {
    var divList = $("#drag_div li");
    for (var i = 0; i < divList.length; i++) {
        divList[i].addEventListener('dragstart', function (e) {
            dragDiv.e.target;  // 保存被拖拉节点
            e.target.style.opacity = .5;  // 被拖拉节点的背景色变透明
        });
    }
    var divBody = $("#dragBody");
    divBody[0].addEventListener('dragenter', function (e) {
        if (e.target.className == "dragBody") {
            divBody.append(dragDiv);
        }
    });
}


function setTextColor(picker) {
    /*document.getElementsByTagName('body')[0].style.color = '#' + picker.toString()*/
    $("#colorChouse").css("color", picker.toString())
}


//下拉框
function select() {

    //下拉框数据
    var aa = [{"name": "全部", "type": "all"},
        {"name": "一", "type": "one"},
        {"name": "二", "type": "two"}
    ];

    var url = './../database/getselectData.do';
    $("#comboxInp").combobox({
        //data: aa,
        url: url,
        textField: 'name',
        valueField: 'type',
        panelHeight: 80,
        onSelect: function (recode) {
            /*$("#comboxInp").combobox("setValue",aa[0].name);
            $("#comboxInp").combobox("setText",aa[0].type);*/
        },
        onChange: function (e, record) {

        },
    })
}


//文件上传
function clickFileUpload() {
    var url = "./../database/upLoadingFiles.do";
    var formData = new FormData($("#deviceForm")[0])
    $.ajax({
        url: url,
        type: 'post',
        async: false,
        data: formData,
        processData: false,
        contentType: false,
        cache: false,
        dataType: 'json',
        success: function (json) {
            var names = json.split(".");
            var filename = names[0].split("__")[0];
            if (names.length > 1) {
                filename = filename + "." + names[1];
            }
            $("#deviceForm").form("clear");
            //C:\testSSMUpLoadFiles
        }
    })
}

//文件下载
function downloadImage(e) {
    var fileName = "boiler__20180605133726.js";
    if (fileName == "") {
        $("#hintPop").show();
        $("#hintPopText").html("无任何设备图纸，请先导入图纸!");
        return;
    }
    var url = "./../database/downFiles.do";
    var form = $("<form></form>").attr("action", url).attr("method", "post");
    form.append($("<input></input>").attr("type", "hidden").attr("name", "fileName").attr("value", fileName));
    form.appendTo('body').submit().remove();
}