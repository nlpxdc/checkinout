const ticket = 'LIKLckvwlJT9cWIhEQTwfJuU557garB7J1tppEvMocW-iUiFaI9vUMg2qx3lzwqT3mpp5OI-QyR6_PBudG1D9Q';

wx.config({
    debug: false,
    appId: 'wx0c14a6dfeab19166', // 必填，公众号的唯一标识
    timestamp: 1548295875, // 必填，生成签名的时间戳
    nonceStr: '1234567890abcdef', // 必填，生成签名的随机串
    signature: '62e373fd5534a4d3edafa28462bf64b21c7a43f6',// 必填，签名
    jsApiList: [
        'checkJsApi'
    ] // 必填，需要使用的JS接口列表
});

wx.error(function(error){
    console.error(error);
});

wx.ready(function(){
    console.log('验证成功');
});


var app = new Vue({
    el: '#app',
    data: {
        message: 'Hello Vue!'
    },
    methods:{
        handleCheckInOut(){
            console.log('check inout click');            
        }
    }
});