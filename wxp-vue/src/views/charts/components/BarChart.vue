<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
import echarts from "echarts";
require("echarts/theme/macarons"); // echarts theme
import resize from "./mixins/resize";

import {queryEchartsBarArray} from '@/api/echarts'


const animationDuration = 6000;

export default {
  mixins: [resize],
  props: {
    sqlCode:{
      type: String,
      default: ""
    },
    title:{
      type: String,
      default: "柱状图"
    },
    className: {
      type: String,
      default: "chart"
    },
    width: {
      type: String,
      default: "100%"
    },
    height: {
      type: String,
      default: "300px"
    }
  },
  data() {
    return {
      chart: null,
      xArray:[],
      sourceArray:[]
    };
  },
  mounted() {
    this.initData()
   
  },
  //生命周期 - 创建完成（可以访问当前this实例）
created() {
  // this.initData()
},
  beforeDestroy() {
    if (!this.chart) {
      return;
    }
    this.chart.dispose();
    this.chart = null;
  },
  methods: {
    initData(){
        let query= {
          code:this.sqlCode
        }
        let title=["titles", "当日", "同比", "环比"]
        this.sourceArray=[["titles", "当日", "同比", "环比"]]
        queryEchartsBarArray(query).then(data => {
         data.forEach(e=>{
            var array=[]
            array[0]=e['parAcctDay']
            array[1]=e['dayCount']
            array[2]=e['chainCount']
            array[3]=e['yearOnyearCount']
            this.sourceArray.push(array)
            this.xArray.push(e['parAcctDay'])
         })
          this.$nextTick(() => {
            this.initChart()
          })
        }).catch(error => {

        })
    },
    initChart() {
      this.chart = echarts.init(this.$el, "macarons");

      this.chart.setOption({
        toolbox: {
        show : true,
        feature : {
            myDayShow : {
              show: true,
              title: '周',
              icon : 'image://http://echarts.baidu.com/images/favicon.png',
              onclick: function (){
                    alert('周')
              }
            },
            myWeekShow : {
              show: true,
              title: '月',
              icon : 'image://http://echarts.baidu.com/images/favicon.png',
              onclick: function (){
                    alert('月')
              }
            }
        }
    },
        title: {
        text: this.title
        },
        tooltip: {
          trigger: "axis",
          axisPointer: {
            // 坐标轴指示器，坐标轴触发有效
            type: "shadow" // 默认为直线，可选为：'line' | 'shadow'
          }
        },
         legend: {
         data: ['当日', '同比', '环比']
       },
        dataset: {
          source: //this.sourceArray
          [
            ["titles", "当日", "同比", "环比"],
            ["20190920", 43.3, 43.3,  85.8],
            ["20190921",  83.1,  85.8, 93.7],
            ["20190922", 86.4, 93.7, 85.8]
          ]
        },
        xAxis: { 
          type: "category" ,
          data: //this.xArray
           ['20190920', '20190921', '20190922']
          },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            type: "bar",
            barGap: 0,
            itemStyle: {
              normal: {
                color: new echarts.graphic.LinearGradient(
                  0,
                  1,
                  0,
                  0,
                  [
                    {
                      offset: 0,
                      color: "#0000FF" // 0% 处的颜色
                    },
                    {
                      offset: 0.6,
                      color: "#0033FF" // 60% 处的颜色
                    },
                    {
                      offset: 1,
                      color: "#0066FF" // 100% 处的颜色
                    }
                  ],
                  false
                )
              }
            }
          },
          {
            type: "bar",
            barGap: 0,
            itemStyle: {
              normal: {
                color: new echarts.graphic.LinearGradient(
                  0,
                  1,
                  0,
                  0,
                  [
                    {
                      offset: 0,
                      color: "#CC6600" // 0% 处的颜色
                    },
                    {
                      offset: 0.6,
                      color: "#CC9900" // 60% 处的颜色
                    },
                    {
                      offset: 1,
                      color: "#CCCC00" // 100% 处的颜色
                    }
                  ],
                  false
                )
              }
            }
          },
          {
            type: "bar",
            barGap: 0,
            itemStyle: {
              normal: {
                color: new echarts.graphic.LinearGradient(
                  0,
                  1,
                  0,
                  0,
                  [
                    {
                      offset: 0,
                      color: "#6699FF" // 0% 处的颜色
                    },
                    {
                      offset: 0.6,
                      color: "#66CCFF" // 60% 处的颜色
                    },
                    {
                      offset: 1,
                      color: "#66FFFF" // 100% 处的颜色
                    }
                  ],
                  false
                )
              }
            }
          }
        ]
      });
    }
  }
};
</script>
