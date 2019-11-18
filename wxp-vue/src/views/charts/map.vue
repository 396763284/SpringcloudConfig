<!--  -->
<template>
        <div ref="map" :style="{width:'100%',height:'100%'}"></div>

</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';

import echarts from 'echarts'
import 'echarts/map/js/china'

export default {
//import引入的组件需要注入到对象中才能使用
components: {},
data() {
//这里存放数据
return {

};
},
//监听属性 类似于data概念
computed: {},
//监控data中的数据变化
watch: {},
//方法集合
methods: {
    ininData(){
         this.$nextTick(() => {
            console.log("ininData")
            this.initChart()
          })
    },
    converData(data){
        let geoCoord={
            '北京': [116.4551, 40.2539],
            '上海': [121.4648, 31.2891],
            '杭州': [119.5313, 29.8773]}
        let res = []
        for (let i = 0; i <  data.length; i ++) {
                let dataItem = data[i]
            let fromCoord = geoCoord[dataItem[0].name]
            let toCoord = geoCoord[dataItem[1].name]
            if(fromCoord && toCoord){
                res.push([{
                        coord: fromCoord
                    }, {
                        coord: toCoord
                    }])
            }
        }
        return res
    },
     initChart() {
      this.chart = echarts.init(this.$el)
      let SHData = [
                    [{name:'上海'},{name:'北京'}],
                    [{name:'上海'},{name:'杭州'}]
                 ]             
       this.chart.setOption({
            title: {
          text: '城市连线',
          textStyle: {
            fontSize: 30
          },
          x: 'center'
        },
        geo: {
          roam: true,
          map: 'china',
          left: 'left',
          right: '300',
          layoutSize: '80%',
          label: {
            emphasis: {
              show: false
            }
          },
          itemStyle: {
            emphasis: {
              areaColor: '#fff464'
            }
          },
          regions: [{
            name: '南海诸岛',
            value: 0,
            itemStyle: {
              normal: {
                opacity: 0,
                label: {
                  show: false
                }
              }
            }
          }]
        },
        series: [{
          name: '用户行程',
          type: 'lines',
          zlevel: 1,
          label: {
            show: false
          },
          data: this.converData(SHData)

        }]
       })
      
      }
},
//生命周期 - 创建完成（可以访问当前this实例）
created() {
    
},
//生命周期 - 挂载完成（可以访问DOM元素）
mounted() {
     this.ininData()
},
beforeCreate() {}, //生命周期 - 创建之前
beforeMount() {}, //生命周期 - 挂载之前
beforeUpdate() {}, //生命周期 - 更新之前
updated() {}, //生命周期 - 更新之后
beforeDestroy() {
}, //生命周期 - 销毁之前
destroyed() {}, //生命周期 - 销毁完成
activated() {}, //如果页面有keep-alive缓存功能，这个函数会触发
}
</script>
<style lang='scss' scoped>
//@import url(); 引入公共css类

</style>