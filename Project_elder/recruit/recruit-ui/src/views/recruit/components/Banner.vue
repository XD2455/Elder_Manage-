<template>
<div>
  <a href = "https://seniors.jjshebao.com/test/#/important-discuss">
    <img src="@/assets/images/banner.png" alt="">
  </a>

<!--    <img src="https://static.zhipin.com/v2/web/geek/images/fast-reg-text.png" alt="">-->
</div>
</template>

<script>
import MyContainer from '@/components/Me/MyContainer'
export default {
  name: 'Banner',
  components: { MyContainer }
}
</script>

<style scoped lang="scss">
div {
  height: 120px;
  //background: #5dd5c8;
  img:first-child{
    width: 100%;
    //margin-left: 60px;
  }
  //img:last-child{
  //  float: right;
  //  //margin-right: 60px;
  //  margin-top: 30px;
  //}
}
</style>
