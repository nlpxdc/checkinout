<template>
  <div id="UserIndexPage">
    <mt-loadmore
      :top-method="loadTop"
      :bottom-method="loadBottom"
      :bottom-all-loaded="allLoaded"
      ref="loadmore"
      :auto-fill="false"
    >
      <div class="content">
        <mt-cell
          v-for="user in users"
          :key="user.openid"
          :title="user.nickname"
          :value="user.gender"
        >
          <img slot="icon" :src="user.avatarUrl" width="24" height="24">
        </mt-cell>
      </div>
    </mt-loadmore>
  </div>
</template>

<style>
</style>

<script>
import { Toast } from 'mint-ui';
import axios from 'axios';

export default {
  data() {
    return {
      users: [],
      pageNum: 1,
      allLoaded: false
    };
  },
  mounted() {
    // this = this;
    console.log("view mounted");
    this.getUsers();
  },
  methods: {
    getUsers() {
      axios
        .get("/user/getWithPage", {
          params: {
            pageNum: this.pageNum
          }
        })
        .then(function(response) {
          console.log(response);

          if (this.pageNum === 1) {
            this.$refs.loadmore.onTopLoaded();
          } else {
            this.$refs.loadmore.onBottomLoaded();
          }

          var users = response.data.list;
          this.users.push(...users);
          if (!users.length) {
            this.allLoaded = true;
            Toast("没有更多数据了");
          }
        }.bind(this))
        .catch(function(error) {
          console.log(error);
        });
    },
    loadTop() {
      console.log("load top trigger");
      this.pageNum = 1;
      this.users = [];
      this.allLoaded = false;
      this.getUsers();
    },
    loadBottom() {
      console.log("load bottom trigger");
      this.pageNum++;
      this.getUsers();
    }
  }
};
</script>


