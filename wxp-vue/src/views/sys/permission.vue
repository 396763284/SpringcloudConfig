<!--  -->
<template>
<div class='app-container'>
 <el-card class="wa_search_card">
      <el-form :inline="true" :model="query" class="demo-form-inline">
        <el-form-item label="名称">
          <el-input v-model="query.title" small placeholder="请输入名称"></el-input>
        </el-form-item>
        <el-form-item label="状态">
            <el-select v-model="query.status" placeholder="请选择状态">
                    <el-option label="请选择" value="" selected></el-option>
                    <el-option label="有效" value="1000" ></el-option>
                    <el-option label="无效" value="1300"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit" class="wa-button">查询</el-button>
          <el-button type="info" @click="reSet" class="wa-button">重置</el-button>
        </el-form-item>
      </el-form>
    </el-card>

   <el-card>
      <el-button round type="success" size="small" @click="handleForm(null, null)">新增</el-button>
      <el-table v-loading="loading" :data="list" style="width: 100%;" max-height="500">
        <el-table-column label="菜单ID" prop="permission_id" fixed></el-table-column>
        <el-table-column label="父级菜单ID" prop="pid" ></el-table-column>
        <el-table-column label="路由标题" prop="title" ></el-table-column>
        <el-table-column label="路由名称" prop="name" ></el-table-column>
        <el-table-column label="文件路径" prop="import_path" ></el-table-column>
        <el-table-column label="URL路径" prop="path" ></el-table-column>
         <el-table-column label="状态">
          <template slot-scope="scope">
            <el-tag :type="scope.row.status | statusFilterType">{{scope.row.status | statusNameFilterType }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作" fixed="right">
          <template slot-scope="scope">
            <el-button
              type="text"
              size="mini"
              @click="handleForm(scope.$index, scope.row)"
            >编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        :page-size="query.limit"
        @current-change="handleCurrentChange"
        layout="prev, pager, next"
        :total="total"
      ></el-pagination>
    </el-card>  

     <!--表单-->
        <el-dialog
            :title="formMap[formName]"
            :visible.sync="formVisible"
            :before-close="hideForm"
            width="80%"
            >
            <el-form :model="formData" :rules="formRules" ref="dataForm" label-width="100px"
            :size="size"
            label-position="right">
               <el-form-item label="父节点" prop="par_menu_id">
                   <select-tree 
                      :props="props"
                      :options="optionData"
                      :value="formData.permission_id"
                      :clearable="isClearable"
                      :accordion="isAccordion"
                      @getValue="getValue($event)"/> 
                </el-form-item>
                <el-form-item label="id" prop="permission_id" v-if="idVisible">
                    <el-input v-model="formData.permission_id" :disabled="true" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="菜单标题" prop="title">
                    <el-input v-model="formData.title"  auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="菜单名称" prop="name">
                    <el-input v-model="formData.name"  auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="URL地址" prop="path">
                    <el-input v-model="formData.path" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="文件地址" prop="import_path">
                    <el-input v-model="formData.import_path" auto-complete="off"></el-input>
                </el-form-item>
                 
                <el-form-item label="状态" prop="status">
                  <el-radio-group v-model="formData.status">
                    <el-radio v-model="formData.status" label="1000">有效</el-radio>
                    <el-radio v-model="formData.status" label="1300">无效</el-radio>
                  </el-radio-group>
                </el-form-item>
                
                 <el-form-item label="排序" prop="sort">
                    <el-input v-model="formData.sort" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="描述">
                  <el-input type="textarea" v-model="formData.perm_desc" maxlength="30" show-word-limit></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click.native="hideForm">取消</el-button>
                <el-button type="primary" @click.native="formSubmit()" :loading="formLoading">提交</el-button>
            </div>
        </el-dialog>

</div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';
const list_url='/permission/permPage'
const add_url='/permission/addPerm'
const update_url='/permission/updatePerm'
const all_list_url= '/permission/permList'

const formJson = {
    permission_id: "",
    pid: "",
    path: "",
    import_path: "",
    name: "",
    title: "",
    type: "",
    perm_code: '',
    status: 1000,
    perm_desc: '',
    sort: "",
    icon: "icon-fenleiorguangchangorqitatianchong",
    url_type: "",
    perm_desc:""
}

const addRules = {
  name: [{ required: true, message: "参数不能为空", trigger: "blur" }],
  title: [{ required: true, message: "参数不能为空", trigger: "blur" }]
}

const editRules = {
  name: [{ required: true, message: "参数不能为空", trigger: "blur" }],
  title: [{ required: true, message: "参数不能为空", trigger: "blur" }]
}

import SelectTree  from '@/components/treeSelect'
import { api } from "@/api/index";


export default {
//import引入的组件需要注入到对象中才能使用
components: {},
data() {
//这里存放数据
return {
    query: {
        title:"",
        status:"",
        page: 1,
        limit: 20
	    },
	    list: [],
	    total: 0,
	    size: "mini",
      loading: true,
      formMap: {
        add: "新增",
        edit: "编辑"
      },
      noEdit:false,
      idVisible: false,
      formName: null,
      formVisible: false,
      formData: formJson,
      formLoading: false,
      formRules: {},
      props:{                // 配置项（必选）
        value: 'permission_id',
        label: 'title',
        children: 'children',
        // disabled:true
      },
      isClearable:true,      // 可清空（可选）
      isAccordion:true,      // 可收起（可选）
      valueId:0,
      treeList:[]
};
},
//监听属性 类似于data概念
computed: {
    optionData(){
      let cloneData = JSON.parse(JSON.stringify(this.treeList))  
      // 对源数据深度克隆
      return  cloneData.filter(father=>{                      // 循环所有项，并添加children属性
          let branchArr = cloneData.filter(child=>father.permission_id == child.pid);       // 返回每一项的子级数组
          branchArr.length>0 ? father.children=branchArr : ''   //给父级添加一个children属性，并赋值
          return father.par_menu_id== null;      //返回第一层
      });
    }
},
//监控data中的数据变化
watch: {},
//方法集合
methods: {
    getList(){
        this.loading = true
        api(this.query,list_url)
            .then(response => {
            	console.log(response)
                this.loading = false;
                this.list = response.data.pages.data || [];
                this.total = response.data.pages.total || 0;
            })
            .catch(() => {
                this.loading = false;
                this.list = [];
                this.total = 0;
            });
  },
  getMenuTree(){
        api(this.query,all_list_url)
            .then(response => {
                this.treeList = response.data.list || [];            
                })
            .catch(() => {
                this.treeList = [];
            });
  },
  handleCurrentChange(val) {
            this.query.page = val;
            this.getList();
        },
  onSubmit(){
      this.getList()
  },
  reSet(){
    this.query= {
      smenu_name:"",
    	smenu_status:"",
    	smenu_type:"",
	    page: 1,
	    limit: 20
    }
  },
  handleForm(index, row) {
      this.idVisible=false
      this.noEdit=false
      this.formVisible = true
      this.formData = JSON.parse(JSON.stringify(formJson))
      this.getMenuTree()
      if (row !== null) {
        this.formData = Object.assign({}, row)
      }
      this.formName = "add";
      this.formRules = addRules
      if (index !== null) {
        this.noEdit=true
        this.idVisible=true
        this.formName = "edit"
        this.formRules = editRules
      }
    },
    hideForm(){
       // 更改值
      this.formVisible = !this.formVisible;
      this.formLoading =false
      // 清空表单
      this.resetForm()
      return true;
    },
    formSubmit(){
       this.$refs["dataForm"].validate(valid => {
                if (valid) {
                    this.formLoading = true
                    let data = Object.assign({}, this.formData)
                    let strParams= paramToString(data)
                    var code=""
                    if (this.formName === "add") {
                      code=add_code
                    }else if(this.formName === "edit"){
                      code=update_code
                    }
                    api(strParams, code).then(res => {
                        console.log(res)
                        if(res.RESULT.RESULTCODE==0){
                          this.$message({ message: '操作成功', type: 'success' })
                        }else{
                          this.$message({message: '操作失败', type: 'error'})
                        }
                        this.hideForm() 
                        this.getList()
                    })
                }
            })
    },
    resetForm() {
        if (this.$refs["dataForm"]) {
            // 清空验证信息表单
            this.$refs["dataForm"].clearValidate();
            // 刷新表单
            this.$refs["dataForm"].resetFields();
        }
    },
    getValue(value){
        this.formData.par_menu_id = value
    }

},
filters: {
    statusFilterType(status) {
      const statusMap = {
        1000: "success",
        1300: "info"
      };
      return statusMap[status];
    },
    statusNameFilterType(status) {
      const statusMap = {
        1000: "有效",
        1300: "失效"
      };
      return statusMap[status];
    }
  },
//生命周期 - 创建完成（可以访问当前this实例）
created() {
    this.getList();
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