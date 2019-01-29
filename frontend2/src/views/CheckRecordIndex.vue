<template>
  <div id="CheckRecordIndexPage">
    <mt-loadmore
      :top-method="loadTop"
      :bottom-method="loadBottom"
      :bottom-all-loaded="allLoaded"
      ref="loadmore"
      :auto-fill="false"
    >
      <div class="content">
        <mt-cell
          v-for="item in checkRecords"
          :key="item.id"
          :title="item.user.nickname"
          :value="item.time"
        >
          <img slot="icon" :src="item.user.avatarUrl" width="24" height="24">
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
      checkRecords: [],
      currentTimestamp: "",
      allLoaded: false
    };
  },
  mounted() {
    // this = this;
    console.log("view mounted");
    this.getCheckRecords();
  },
  methods: {
    getCheckRecords() {
      axios
        .get("/checkinout/getWithTime", {
          params: {
            timestamp: this.currentTimestamp
          }
        })
        .then((response) => {
          console.log(response);

          if (this.currentTimestamp === "") {
            this.$refs.loadmore.onTopLoaded();
          } else {
            this.$refs.loadmore.onBottomLoaded();
          }

          var checkRecords = response.data;
          this.checkRecords.push(...checkRecords);
          this.checkRecords.map(function(checkRecord) {
            var time = new Date(checkRecord.timestamp);
            checkRecord.time = time.toLocaleTimeString();
            return checkRecord;
          });
          if (!checkRecords.length) {
            this.allLoaded = true;
            Toast("没有更多数据了");
          }
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    loadTop() {
      console.log("load top trigger");
      this.currentTimestamp = "";
      this.checkRecords = [];
      this.allLoaded = false;
      this.getCheckRecords();
    },
    loadBottom() {
      console.log("load bottom trigger");
      this.currentTimestamp = this.checkRecords[
        this.checkRecords.length - 1
      ].timestamp;
      this.getCheckRecords();
    }
  }
};
</script>


