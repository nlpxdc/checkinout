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
                    var users = response.data.list;
                    app.users.push.apply(
                        app.users,
                        users);
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
            this.$refs.loadmore.onTopLoaded();
        },
        loadBottom() {
            console.log('load bottom trigger');
            this.pageNum++;
            this.getUsers();
            this.$refs.loadmore.onBottomLoaded();
        }
    }
});