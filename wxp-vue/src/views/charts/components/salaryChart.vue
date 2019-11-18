<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
import echarts from 'echarts'
require('echarts/theme/macarons') // echarts theme
import resize from './mixins/resize'

const animationDuration = 6000

export default {
  mixins: [resize],
  props: {
    className: {
      type: String,
      default: 'chart'
    },
    width: {
      type: String,
      default: '100%'
    },
    height: {
      type: String,
      default: '300px'
    }
  },
  data() {
    return {
      chart: null
    }
  },
  mounted() {
    this.$nextTick(() => {
      this.initChart()
    })
  },
  beforeDestroy() {
    if (!this.chart) {
      return
    }
    this.chart.dispose()
    this.chart = null
  },
  methods: {
    initChart() {
      this.chart = echarts.init(this.$el, 'macarons')

      this.chart.setOption({
         	
         title : {
        text: '南丁格尔玫瑰图',
        subtext: 'demo',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        icon: "circle",
        show : false,
        data:['rose1','rose2']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {
                show: true,
                type: ['pie', 'funnel']
            },
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    series : [
        {
           name: "",
        type: "pie",
        radius: [
            0,
            70
        ],
        avoidLabelOverlap: false,
        startAngle: 0,
         roseType: "area",
        center: [
            "46%",
            "50%"
        ],
        selectedMode: "single",
        label: {
            normal: {
                show: true,
                formatter: '{b}\n{c}'
            },
            emphasis: {
                show: true
            }
        },
        labelLine: {
            normal: {
                show: true,
                smooth: false,
                length: 0,
                length2: 8
            },
            emphasis: {
                show: true
            }
        },
            data:[
                {value:5, name:'-0.5'},
                {value:1, name:'0.8'}
            ]
        }
    ]
      })
    }
  }
}
</script>
