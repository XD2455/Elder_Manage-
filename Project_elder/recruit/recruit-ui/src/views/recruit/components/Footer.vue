<template>
  <div id="footer" class="">
    <MyContainer>
      <el-row>
        <el-col :span="2">
          <h4>求职者服务</h4>
          <a>平台协议</a>
          <a>防骗指南</a>
          <a>使用帮助</a>
        </el-col>
        <el-col :span="2">
          <h4>企业服务</h4>
          <a>平台协议</a>
          <a>防骗指南</a>
          <a>使用帮助</a>
        </el-col>
        <el-col :span="10">
          <h4>西南民族大学</h4>
          <a>软件工程1903 XD</a>
          <a>联系地址 成都市双流区西南民族大学航空港校区</a>
          <a>联系电话 010-810xxxx1</a>
          <a>联系电话 010-810xxxx2</a>
        </el-col>
        <el-col :span="5">
          <h4>政府后台管理系统</h4>
          <div class="footer-social">
            <a>企业服务热线和举报投诉 <span>400 XXX 5799</span></a>
            <a>工作日 <span>8:00 - 22:00</span></a>
            <a>休息日 <span>9:30 - 18:30</span></a>
          </div>
        </el-col>
        <el-col :span="5">
          <h4>微信公众号</h4>
          <img src="@/assets/images/vx.png">
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <span style="float:left;margin-right: 30px;">Copyright © 2023 老年人力资源开发平台</span>
<!--          <a href="https://beian.miit.gov.cn/" target="_blank">京ICP备11号-5</a>-->
        </el-col>
        <el-col :span="2">
<!--          <a href="https://www.zhipin.com/activity/cc/businesslicense.html" rel="nofollow" ka="link-businesslicense" target="_blank">-->
<!--            <img src="https://static.zhipin.com/v2/web/geek/images/icon-badge-1.png" alt="">-->
<!--            电子营业执照-->
<!--          </a>-->
        </el-col>
<!--        <el-col :span="6">-->
<!--          <a><img src="https://static.zhipin.com/v2/web/geek/images/icon-beian.png" alt=""> 京公网安备110105XXX2801</a>-->
<!--        </el-col>-->
      </el-row>
    </MyContainer>
  </div>
</template>

<script>
import MyContainer from '@/components/Me/MyContainer'
export default {
  name: 'Footer',
  components: { MyContainer },
  data() {
    return {}
  },
  methods: {},
  created() {
  }
}
</script>

<style scoped>
a {
  display: block;
  font-size: 12px;
  color: #8d92a1;
  height: 24px;
  line-height: 24px;
}
a img {
  width: 16px;
  height: 16px;
  vertical-align: middle;
}
</style>
