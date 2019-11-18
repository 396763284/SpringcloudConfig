<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
import echarts from "echarts";
require("echarts/theme/macarons"); // echarts theme
import resize from "./mixins/resize";

const animationDuration = 6000;

export default {
  mixins: [resize],
  props: {
    title:{
      type: String,
      default: "仪表盘"
    },
    detail:{
      type: String,
      default: "数值"
    },
    value:{
      type: Number,
      default: 0
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
      chart: null
    };
  },
  mounted() {
    this.$nextTick(() => {
      this.initChart();
    });
  },
  beforeDestroy() {
    if (!this.chart) {
      return;
    }
    this.chart.dispose();
    this.chart = null;
  },
  methods: {
    initChart() {
      this.chart = echarts.init(this.$el, "macarons");
      this.chart.setOption({
        title: {
        text: this.title
        },
        tooltip : {
        formatter: " {c}"
    },
    toolbox: {
        feature: {
            restore: {},
            saveAsImage: {}
        }
    },
    series: [
        {
            name: this.detail,
            type: 'gauge',
            min:0,   
            max:100,    //设置刻度盘内数值区间
            detail: {
              formatter:this.detail+":"+this.value,
              textStyle:{
                fontSize:13
              }
            },
            data: [{value: this.value}]
        }
    ]
      });
    }
  },
  watch: {
    value:{
      immediate: true,
      handler(newValue,oldvalue){
      this.value= newValue
      }
    }
  },
};
</script>
