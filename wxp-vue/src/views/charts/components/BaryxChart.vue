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
			if(!this.chart) {
				return
			}
			this.chart.dispose()
			this.chart = null
		},
		methods: {
			initChart() {
				this.chart = echarts.init(this.$el, 'macarons')

				this.chart.setOption({
					title: {
						text: '累计预算完成量'
					},
					tooltip: {},
					legend: {
						data: ['完成率']
					},
					xAxis: {

					},
					yAxis: {
						data: ["ITV净增用户", "宽带净增用户", "智能手机销售", "移动用户净增", "主营业务收入"]
					},
					series: [{
						name: '完成率',
						type: 'bar',
						data: [20, 36, 10, -10, 20]
					}]

				})
			}
		}
	}
</script>