<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
import echarts from "echarts";
require("echarts/theme/macarons"); // echarts theme
import resize from "./mixins/resize";
import {queryEchartsPieBarArray} from '@/api/echarts'

const animationDuration = 6000

export default {
  mixins: [resize],
  props: {
    sqlCode:{
      type: String,
      default: ""
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
      arr: [],
      angleAxisData: [],
      max:50
    }
  },
  mounted() {
    this.initParam()
  },
  beforeDestroy() {
    if (!this.chart) {
      return;
    }
    this.chart.dispose();
    this.chart = null;
  },
  methods: {
    initParam() {
       let query= {
          code:this.sqlCode
        }
       queryEchartsPieBarArray(query).then(data => {
          data.forEach(e=>{
            this.arr.push({
              name:e['chartName'],
              value:e['chartValue']
            })
            this.angleAxisData.push(e['chartName'])
         })
         this.max=this.getMax(this.arr,'value')
          this.$nextTick(() => {
            this.initChart()
          })
        }).catch(error => {

        })
    },

    initChart() {
      this.chart = echarts.init(this.$el, "macarons");

      this.chart.setOption({
        backgroundColor: '#222',
        tooltip: {
            trigger: 'item',
            textStyle: {
                fontSize: 16,
                color: '#fff',
                fontFamily: 'Microsoft YaHei'
            }
        },
        tooltip: {
          trigger: "item",
          textStyle: {
            fontSize: 16,
            color: "#fff",
            fontFamily: "Microsoft YaHei"
          }
        },
         angleAxis: {
         type: 'category',
         axisLine: {
             lineStyle: {
                 color: '#6d8a92'
             }
         },
         axisLabel: {
             interval: 0,
             fontSize: 14,
             color: '#fff',
             fontFamily: 'Microsoft YaHei'
         },
         axisTick: {
             show: false
         },
         data: this.angleAxisData,
         z: 10
     },
      radiusAxis: {
         max: this.max,
         min: 0,
         axisTick: {
             show: false
         },
         axisLine: {
             show: true,
             lineStyle: {
                 color: '#6d8a92'
             }
         },
         axisLabel: {
             formatter: '{value}',
             textStyle: {
                 fontSize: 11,
                 color: '#61d9fb',
                 fontFamily: 'Microsoft YaHei'
             }
         },
         splitLine: {
             show: true,
             lineStyle: {
                 color: '#6d8a92'
             }
         },
         splitArea: {
             areaStyle: {
                 color: 'transparent'
             }
         }
     },
         polar: {
         center: ['50%', '50%'],
         radius: '74%',
     },
     series: [{
         type: 'bar',
         data: this.arr,
         itemStyle: {
             color: function(params) {
                 var colorList = ['#5cc6ca', '#d87a7f', '#f5b97f', '#5ab1ef', '#b6a2de', '#8d98b3', '#e5d02d', '#97b552', '#956f6d', '#d0579c'];
                 return colorList[params.dataIndex];
             }
         },
         coordinateSystem: 'polar',
     }]
      });
    },
    getMax(arr, key) {
     var max = 0,
         len = arr.length;
     for (var i = 0; i < len; i++) {
         var item = arr[i][key]
         if (max < item) max = item;
     }
     return max;
    }
  }
};
</script>
