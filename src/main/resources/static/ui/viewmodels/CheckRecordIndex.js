var app = new Vue({
    el: '#app',
    data: {
        checkRecords: [],
        currentTimestamp: '',
        allLoaded: false
    },
    mounted() {
        console.log('view mounted');
        this.getCheckRecords();
    },
    methods: {
        getCheckRecords() {
            axios.get('/checkinout/getWithTime', {
                params: {
                    timestamp: this.currentTimestamp
                }
            })
                .then(function (response) {
                    console.log(response);

                    if (app.currentTimestamp === '') {
                        app.$refs.loadmore.onTopLoaded();
                    } else {
                        app.$refs.loadmore.onBottomLoaded();
                    }

                    var checkRecords = response.data;
                    // app.checkRecords.push.apply(
                    //     app.checkRecords,
                    //     checkRecords);
                    app.checkRecords.push(...checkRecords);
                    app.checkRecords.map(function (checkRecord) {
                        var time = new Date(checkRecord.timestamp);
                        checkRecord.time = time.toLocaleTimeString();
                        return checkRecord;
                    })
                    if(!checkRecords.length){
                        app.allLoaded = true;
                        MINT.Toast('没有更多数据了');
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        loadTop() {
            console.log('load top trigger');
            this.currentTimestamp = '';
            this.checkRecords = [];
            this.allLoaded = false;
            this.getCheckRecords();
        },
        loadBottom() {
            console.log('load bottom trigger');
            this.currentTimestamp = this.checkRecords[this.checkRecords.length - 1].timestamp;
            this.getCheckRecords();
        }
    }
});