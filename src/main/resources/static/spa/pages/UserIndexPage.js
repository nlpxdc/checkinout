const UserIndexPage = {
    name: 'UserIndexPage',
    template: `
<div id="UserIndexPage">
    <mt-loadmore :top-method="loadTop" :bottom-method="loadBottom" :bottom-all-loaded="allLoaded" ref="loadmore"
        :auto-fill="false">
        <div class="content">
            <mt-cell v-for="user in users" :key="user.openid" :title="user.nickname" :value="user.gender">
                <img slot="icon" :src="user.avatarUrl" width="24" height="24">
            </mt-cell>
        </div>
    </mt-loadmore>
</div>
    `,
    data() {
        return {
            users: [],
            pageNum: 1,
            allLoaded: false
        }
    },
    mounted() {
        UserIndexPageVM = this;
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

                    if (UserIndexPageVM.pageNum === 1) {
                        UserIndexPageVM.$refs.loadmore.onTopLoaded();
                    } else {
                        UserIndexPageVM.$refs.loadmore.onBottomLoaded();
                    }

                    var users = response.data.list;
                    UserIndexPageVM.users.push(...users);
                    if (!users.length) {
                        UserIndexPageVM.allLoaded = true;
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
};