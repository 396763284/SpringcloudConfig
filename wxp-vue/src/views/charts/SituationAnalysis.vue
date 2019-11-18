<!--  -->
<template>
<div class='app-container'>
     <el-card>
       <h4>警情总数汇总 </h4>
       <span>警情总数：{{result.allCount}}</span>
       <h4>刑事案件 </h4>
       <span>总数：{{result.criminalAllCount}} ,今日:{{result.criminalDayCount}} ,本周 :{{result.criminalWeekCount}}，本月:{{result.criminalMonthCount}}</span>
        <h4>治安案件 </h4>
       <span>总数：{{result.securityAllCount}} ,今日:{{result.securityDayCount}} ,本周 :{{result.securityWeekCount}}，本月:{{result.securityMonthCount}}</span>
     <h4>今日警情 </h4>
     <span v-for='item in todayCase' :key='item.chartCode'>  种类:{{item.chartName}};数量:{{item.chartValue}};环比:{{item.ratio}}% ,</span>
       <h4>本周警情 </h4>
     <span v-for='item in weekCase' :key='item.chartCode'>  种类:{{item.chartName}};数量:{{item.chartValue}};占比:{{item.ratio}}% ,</span>


  </el-card>
  <el-card>
<bar-chart :title="criminalBarTitle" :sqlCode="criminalsqlCode"/>
  </el-card>
  <el-card>
<bar-chart :title="securityBarTitle" :sqlCode="securitysqlCode"/>
  </el-card>
   <el-card >
      <gauge-chart v-if="gaugeReset" :title="gaugeTitle" :detail="gaugeDetail" :value="result.todayCount" />
  </el-card>
  <el-card>
      <bar-pie-chart :sqlCode="policesqlCode"/>
  </el-card>
  
</div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';
 import { queryEchartsMap, queryEchartsPieBarArray} from '@/api/echarts'


import BarChart from "./components/BarChart";   //条形图
import BarPieChart from './components/BarPieChart'; //条形图
import GaugeChart from './components/GaugeChart' //仪表盘

export default {
//import引入的组件需要注入到对象中才能使用
components: {BarChart,BarPieChart,GaugeChart},
data() {
//这里存放数据
return {
        activeName: 'five',
        query:{
          sqlType:"SituationAnalysisMap"
        },
        policesqlCode:"policePieBar",
        gaugeReset:true,
        gaugeTitle:"警情情况",
        gaugeDetail:"今日警情",
        todayTypeCode:"todayTypeCount",
        weekTypeCode:"weekTypeCount",
        securitysqlCode:"securityWeekBar",
        criminalsqlCode:"criminalWeekBar",
        criminalBarTitle:"刑事类警情对比",
        securityBarTitle:"治安类警情对比",
        todayCase:[],
        weekCase:[],
        result:{
          allCount:0,
          todayCount:0,
          criminalAllCount:0,
          criminalDayCount:0,
          criminalWeekCount:0,
          criminalMonthCount:0,
          securityAllCount:0,
          securityDayCount:0,
          securityWeekCount:0,
          securityMonthCount:0
        }
};
},
//监听属性 类似于data概念
computed: {
   
},
//监控data中的数据变化
watch: {},
//方法集合
methods: {
    initParams(){
        this.gaugeReset=false
        queryEchartsMap(this.query).then(data => {
          console.log(data)
          this.result = Object.assign({}, data)
          this.$nextTick(() => {
            this.gaugeReset = true;
          });
        }).catch(error => {

        })
        queryEchartsPieBarArray({
            code:this.todayTypeCode
        }).then(data => {
          this.todayCase=data
        }).catch(error => {

        })
        queryEchartsPieBarArray({
            code:this.weekTypeCode
        }).then(data => {
          this.weekCase=data
        }).catch(error => {

        })
    }
},
//生命周期 - 创建完成（可以访问当前this实例）
created() {
  this.initParams()
},
//生命周期 - 挂载完成（可以访问DOM元素）
mounted() {

},
beforeCreate() {}, //生命周期 - 创建之前
beforeMount() {}, //生命周期 - 挂载之前
beforeUpdate() {}, //生命周期 - 更新之前
updated() {}, //生命周期 - 更新之后
beforeDestroy() {}, //生命周期 - 销毁之前
destroyed() {}, //生命周期 - 销毁完成
activated() {}, //如果页面有keep-alive缓存功能，这个函数会触发
}
</script>
<style lang='scss' scoped>
//@import url(); 引入公共css类

</style>