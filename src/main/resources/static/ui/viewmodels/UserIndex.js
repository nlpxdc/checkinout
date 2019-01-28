var app = new Vue({
    el: '#app',
    data: {
        users: [],
        pageNum: 1,
        allLoaded: false
    },
    mounted() {
        console.log('view mounted');
        this.getUsers();
    },
    methods: {
        getUsers() {
            axios.get('/user/getWithPage', {
                params: {
                    pageNum: this.pageNum
                }
            })
                .then(function (response) {
                    console.log(response);

                    if (app.pageNum === 1) {
                        app.$refs.loadmore.onTopLoaded();
                    } else {
                        app.$refs.loadmore.onBottomLoaded();
                    }

                    var users = response.data.list;
                    // app.users.push.apply(
                    //     app.users,
                    //     users);
                    app.users.push(...users);
                    if(!users.length){
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
            this.pageNum = 1;
            this.users = [];
            this.allLoaded = false;
            this.getUsers();
        },
        loadBottom() {
            console.log('load bottom trigger');
            this.pageNum++;
            this.getUsers();
        }
    }
});