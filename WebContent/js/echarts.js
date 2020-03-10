var colors = ['#ff0000', "#00ff00", "#0000ff"];

$(document).ready(function () {
    echart1();
    echart2();
    echart3();
    echart5();
})


//可以框选的图
function echart2() {
    var mychartAlarm = echarts.init(document.getElementById('echart2'));    //初始化echarts图表
    var option = null;
    option = {
        title: {
            text: '框选',
            left: 'center'
        },
        tooltip: {
            trigger: 'axis',
            formatter: '{a} <br/>{b} : {c}'
        },
        legend: {
            left: 'left',
            data: ['2的指数', '3的指数']
        },

        xAxis: {
            type: 'category',
            name: 'x',
            splitLine: {show: false},
            data: ['一', '二', '三', '四', '五', '六', '七', '八', '九']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            right: '5%',  //框选按钮……的位置
        },
        brush: {    //右上角框选按钮
            toolbox: ['rect'],   //开启横向选择功能，只显示一个图标
            seriesIndex: 'all',   //所有 series 可以被刷选

            transformable: false,   //选中区域不能调整平移
            brushMode: 'single',   //单选
            xAxisIndex: 'all',

            throttleType: 'debounce',
            throttleDelay: 300,   //刷选或者移动选区的时候，会不断得发 brushSelected 事件，从而告诉外界选中的内容。
        },
        yAxis: {
            type: 'log',
            name: 'y'
        },
        series: [
            {
                name: '3的指数',
                type: 'line',
                data: [1, 3, 9, 27, 81, 247, 741, 2223, 6669, 33, 44]
            },
            {
                name: '2的指数',
                type: 'line',
                data: [1, 2, 4, 8, 16, 32, 64, 128, 256, 56, 787, 11, 22]
            },
            {
                name: '1/2的指数',
                type: 'line',
                data: [1 / 2, 1 / 4, 1 / 8, 1 / 16, 1 / 32, 1 / 64, 1 / 128, 1 / 256, 1 / 512]
            }
        ]
    };
    /*	mychartAlarm.dispatchAction({
            type: 'brush',
            areas: [
                {
                    geoIndex: 0,
                    // 指定选框的类型。
                    brushType: 'polygon',
                    // 指定选框的形状。
                    coordRange: [[119.72,34.85],[119.68,34.85],[119.5,34.84],[119.19,34.77]]
                }
                ]
        });*/

    mychartAlarm.on('legendselectchanged', function (params) {   //图例选中事件
        console.log(params);
    });
    mychartAlarm.on('click', function (params) {  //鼠标点击圆点，图形事件
        console.log(params);
    });
    mychartAlarm.on('dblclick', function (params) {  //鼠标双击击圆点，图形事件
        alert(1)
    });

    mychartAlarm.on('brushSelected', renderBrushed);   //框选


    function renderBrushed(params) {      //框选事件

    }

    mychartAlarm.setOption(option);   //为echarts对象加载数据


}


//可以下载的图
function echart3() {
    var mychartAlarm = echarts.init(document.getElementById('echart3'));    //初始化echarts图表
    var option = null;
    option = {
        title: {
            text: '下载',
            left: 'center'
        },
        tooltip: {
            trigger: 'axis',
            formatter: '{a} <br/>{b} : {c}'
        },
        legend: {
            left: 'left',
            data: ['2的指数', '3的指数'],
            icon: "circle",  //变为圆
            //icon:'image:///asset/get/s/data-1490602888744-Bkb5iBU3g.png',
        },

        xAxis: {
            type: 'category',
            name: 'x',
            splitLine: {show: false},
            data: ['一', '二', '三', '四', '五', '六', '七', '八', '九']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            right: '5%',  //按钮位置
            textStyle: 30,
            fontSize: 30,
            feature: {      //右上角按钮
                dataZoom: {show: true},
                dataView: {show: true, readOnly: false},
                restore: {show: true},
                //  magicType:{show:true, type: ['line', 'bar', 'stack', 'tiled']},
                saveAsImage: {show: true},   //下载
                myTest1: {        //自定义的工具,只能以 my 开头
                    show: true,
                    title: '自定义工具',
                    itemSize: 15,
                    icon: 'image://./../img/echarts/b.png',
                    iconStyle: {
                        normal: {
                            color: 'red',
                            fontSize: 30
                        }
                    },
                    onclick: function (e) {
                        var picInfo = mychartAlarm.getDataURL();
                    }
                }
            }
        },
        yAxis: {
            type: 'log',
            name: 'y'
        },
        series: [
            {
                name: '3的指数',
                type: 'line',
                data: [1, 3, 9, 27, 81, 247, 741, 2223, 6669, 33, 44]
            },
            {
                name: '2的指数',
                type: 'line',
                data: [1, 2, 4, 8, 16, 32, 64, 128, 256, 56, 787, 11, 22]
            },
            {
                name: '1/2的指数',
                type: 'line',
                data: [1 / 2, 1 / 4, 1 / 8, 1 / 16, 1 / 32, 1 / 64, 1 / 128, 1 / 256, 1 / 512]
            }
        ]
    };

    mychartAlarm.on('legendselected  ', function (params) {   //图例选中事件
        alert("444")
    });

    mychartAlarm.setOption(option);   //为echarts对象加载数据
}


var aa = {
    'map': [{
        'data': [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
        'time': ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
        'data1': [2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2],
        'name': ['蒸发量', '平均温度']
    },
        {
            'data': [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
            'time': ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
            'data1': [2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2],
            'name': ['蒸发量', '平均温度']
        }],
}

//自动增加div
function divMap(a) {
    for (var i = 0; i < a; i++) {
        var str = '<div id="echarts' + i + '" class="echartsDIV" style="height:400px;width:500px;float:left"></div>'
        $("#body").append(str);
    }
}

//自动增加实验
function echart1() {
    var strData = eval(aa).map;  //json格式转化为数组
    var a = strData.length;
    divMap(a);
    var data = [];
    var service = [];
    var div = [];
    for (var i = 0; i < strData.length; i++) {
        data[i] = strData[i].data;
        var mychartAlarm = echarts.init(document.getElementById('echarts' + i, "shine"));
        //初始化echarts图表
        var option = null;
        option = {
            tooltip: {
                trigger: 'axis',
                color: colors,
            },
            legend: {
                data: [strData[i].name[1], strData[i].name[2]]
            },
            xAxis: [
                {
                    type: 'category',
                    data: strData[i].time
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: '水量',

                    interval: 50,
                    axisLabel: {
                        formatter: '{value} ml'
                    }
                },
                {
                    type: 'value',
                    name: '温度',

                    interval: 5,
                    axisLabel: {
                        formatter: '{value} °C'
                    }
                }
            ],
            series: [
                {
                    name: strData[i].name[1],
                    type: 'bar',
                    data: strData[i].data
                },
                {
                    name: strData[i].name[2],
                    type: 'line',
                    symbol: 'none',
                    showAllSymbol: true,
                    yAxisIndex: 1,
                    data: strData[i].data1
                }
            ]
        };
        mychartAlarm.setOption(option);   //为echarts对象加载数据
        mychartAlarm.on('showtip', function (params) {
            var a = params.dataIndexInside;
        })
        mychartAlarm.getZr().on('click', function (option) {
            alert("22")
        })

    }
}


function echart5() {
    var mychartAlarm = echarts.init(document.getElementById('echart5'));    //初始化echarts图表
    var option = null;
    option = {
        title: {
            text: '下载',
            left: 'center'
        },
        tooltip: {
            trigger: 'axis',
            formatter: '{a} <br/>{b} : {c}'
        },
        legend: {
            left: 'left',
            data: ['2的指数', '3的指数']
        },

        xAxis: {
            type: 'category',
            name: 'x',
            splitLine: {show: false},
            data: ['一', '二', '三', '四', '五', '六', '七', '八', '九']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        yAxis: {
            type: 'log',
            name: 'y'
        },
        series: [
            {
                name: '3的指数',
                type: 'bar',
                data: [1, 3, 9, 27, 81, 247, 741, 2223, 6669, 33, 44],
                itemStyle: {
                    normal: {
                        label: {
                            show: true,
                            position: 'top',
                            textStyle: {
                                color: '#333'
                            },
                            formatter: function (params) {
                                if (params.value) {
                                    return '{b|' + params.value + ' }' + '%'
                                } else {
                                    return '';
                                }
                            },
                            // 在文本中，可以对部分文本采用 rich 中定义样式。
                            // 这里需要在文本中使用标记符号：
                            // `{styleName|text content text content}` 标记样式名。
                            // 注意，换行仍是使用 '\n'。
                            /*      formatter: [
                          　　　　            '{a|这段文本采用样式a}',
                          　　　　            '{b|这段文本采用样式b}这段用默认样式{x|这段用样式x}'
                          　　　　        	'{b| }'
                          　　　　        ].join('\n'),*/

                            rich: {
                                a: {
                                    color: 'red',
                                    lineHeight: 10
                                },
                                b: {
                                    backgroundColor: {
                                        image: './../img/echarts/b.png'
                                    },
                                    height: 10,
                                    width: 10
                                },
                                x: {
                                    fontSize: 18,
                                    fontFamily: 'Microsoft YaHei',
                                    borderColor: '#449933',
                                    borderRadius: 4
                                },
                            }
                        },
                    }
                }
            },
            {
                name: '2的指数',
                type: 'bar',
                data: [1, 2, 4, 8, 16, 32, 64, 128, 256, 56, 787, 11, 22]
            },
            {
                name: '1/2的指数',
                type: 'bar',
                data: [1 / 2, 1 / 4, 1 / 8, 1 / 16, 1 / 32, 1 / 64, 1 / 128, 1 / 256, 1 / 512]
            }
        ]
    };


    mychartAlarm.setOption(option);   //为echarts对象加载数据
}
