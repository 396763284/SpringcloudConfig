<!--  -->
<template>
 <div class="app-container">
    <el-card class="wa_search_card">
      <el-form :inline="true" :model="query" class="demo-form-inline">
        <el-form-item label="角色名">
          <el-input v-model="query.role_name" small placeholder="角色名"></el-input>
        </el-form-item>
        <el-form-item label="状态">
          <el-select v-model="query.status" placeholder="状态">
            <el-option label="全部" value></el-option>
            <el-option label="有效" value="1000"></el-option>
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
        <el-table-column label="ID" prop="role_id" fixed></el-table-column>
        <el-table-column label="角色编码" prop="role_code" fixed></el-table-column>
        <el-table-column label="角色名" prop="role_name" fixed></el-table-column>
        <el-table-column label="状态">
          <template slot-scope="scope">
            <el-tag :type="scope.row.status | statusFilterType">{{scope.row.status | statusNameFilterType }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作" fixed="right" width="170">
          <template slot-scope="scope">
            <el-button type="text" size="mini" @click="handleForm(scope.$index, scope.row)">编辑</el-button>
            <el-button type="text" size="mini" @click="handleRelForm( scope.row)">配置权限</el-button>
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
      width="85%"
      top="5vh"
    >
      <el-form :model="formData" label-position="right" label-width="100px" size="small" :rules="formRules" ref="dataForm">
        <el-form-item label="角色ID" prop="role_id" v-if="idVisible">
          <el-input v-model="formData.role_id"  :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="角色编码" prop="role_code">
          <el-input v-model="formData.role_code" :disabled="noEdit"></el-input>
        </el-form-item>
        <el-form-item label="角色名称" prop="role_name">
          <el-input v-model="formData.role_name" ></el-input>
        </el-form-item>
        
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="formData.status">
            <el-radio v-model="formData.status" label="1000">有效</el-radio>
            <el-radio v-model="formData.status" label="1300">无效</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="描述">
          <el-input type="textarea" v-model="formData.role_desc" maxlength="30" show-word-limit></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native="hideForm">取消</el-button>
        <el-button type="primary" @click.native="formSubmit()" :loading="formLoading">提交</el-button>
      </div>
    </el-dialog>


     <!-- 配置权限-->
    <el-dialog
      title="配置权限"
      :visible.sync="relformVisible"
      :before-close="hideRelForm"
      width="85%"
      top="5vh"
    >
    <el-table ref="multipleTable" tooltip-effect="dark" v-loading="reltloading" :data="rel_list" @selection-change="handleSelectionChange"
     style="width: 100%;" max-height="500">
        <el-table-column
      type="selection"
      width="55">
    </el-table-column>
        <el-table-column label="ID" prop="permission_id" fixed></el-table-column>
        <el-table-column label="权限名称" prop="title" fixed></el-table-column>
        <el-table-column label="权限类型" prop="type" fixed></el-table-column>
    </el-table>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native="hideRelForm">取消</el-button>
        <el-button type="primary" @click.native="formRelSubmit()" :loading="formLoading">提交</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';

const list_url = "/role/rolePage";
const add_url = "/role/addRole";
const update_url = "/role/updateRole";

const rel_list_url= "/role/getRolePermRel"
const rel_conf_url = "/role/updateRolePermissions"


const formJson = {
  role_name: "",
  role_id: "",
  role_code: "",
  status: "0",
  role_desc: ""
}
import { api } from "@/api/index";

export default {
//import引入的组件需要注入到对象中才能使用
components: {},
data() {
//这里存放数据
return {
    query: {
        role_name: "",
        role_status: "0",
        page: 1,
        limit: 20
      },
      size: "small",
      loading: true,
      formMap: {
        add: "新增",
        edit: "编辑"
      },
      noEdit: false,
      idVisible: false,
      formName: null,
      formVisible: false,
      formData: formJson,
      formLoading: false,
      formRules: {},
      relformVisible:false,
      reltloading:false,
      rel_list:[],
      multipleRelList:[],
      rel_id:''
};
},
//监听属性 类似于data概念
computed: {},
//监控data中的数据变化
watch: {},
//方法集合
methods: {
    getList() {
      this.loading = true;
      api(this.query, list_url)
        .then(response => {
          console.log(response);
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
    handleCurrentChange(val) {
      this.query.page = val;
      this.getList();
    },
    onSubmit() {
      this.getList();
    },
    reSet() {
      this.query = {
        role_name: "",
        status: "",
        page: 1,
        limit: 20
      }
    },
    handleForm(index, row) {
      this.idVisible = false;
      this.noEdit = false;
      this.formVisible = true;
      this.formData = JSON.parse(JSON.stringify(formJson));
      if (row !== null) {
        this.formData = Object.assign({}, row);
      }
      this.formName = "add";
      this.formRules = addRules;
      if (index !== null) {
        this.noEdit = true;
        this.idVisible = true;
        this.formName = "edit";
        this.formRules = editRules;
      }
    },
    hideForm() {
      // 更改值
      this.formVisible = !this.formVisible
      this.formLoading =false
      // 清空表单
      this.resetForm()
      return true;
    },
    formSubmit() {
      this.$refs["dataForm"].validate(valid => {
        if (valid) {
          this.formLoading = true
          let data = Object.assign({}, this.formData)
          var url=""
          if (this.formName === "add") {
            url=add_url
          }else if(this.formName === "edit"){
            url=update_url
          }
          api(data, url).then(res => {
              if(res.RESULT.RESULTCODE==0){
                this.$message({ message: '操作成功', type: 'success' })
              }else{
                this.$message({message: '操作失败', type: 'error'})
              }
              this.hideForm() 
              this.getList()
          })
        }
      });
    },
    resetForm() {
      if (this.$refs["dataForm"]) {
        // 清空验证信息表单
        this.$refs["dataForm"].clearValidate();
        // 刷新表单
        this.$refs["dataForm"].resetFields();
      }
    },
    getRelList(role_id){
      let rel_query={role_id:role_id}
      api(rel_query, rel_list_url)
        .then(res => {
          this.reltloading = false;
          this.rel_list = res.data.list || [];
          this.$nextTick(() => {
          this.rel_list.forEach(row => {
              if(row.checked == 1){
                this.$refs.multipleTable.toggleRowSelection(row,true)               
                }
             })
           })
          })
        .catch(() => {
          this.reltloading = false;
          this.rel_list = [];
        })
    },
    handleRelForm(row) {
      this.multipleRelList=[]
      this.relformVisible= true
      this.getRelList(row.role_id)
      this.rel_id=row.role_id

    },
    hideRelForm(){
       this.rel_id=''
       // 更改值
      this.relformVisible = !this.relformVisible;
      // 清空表单
      return true;
    },
    formRelSubmit(){
      let p_list=[]
      this.multipleRelList.forEach(row => {
          p_list.push(row.permission_id)
      })

      let rel_data={role_id:this.rel_id,perms:p_list}
      api(rel_data, rel_conf_url).then(res => {
          console.log(res)
          this.relformVisible=true
          if(res.code==1){
            this.$message({ message: '操作成功', type: 'success' })
          }else{
            this.$message({message: '操作失败', type: 'error'})
          }
          this.hideRelForm() 
       })
    },
    handleSelectionChange(val){
      this.multipleRelList = val
      // console.log(this.multipleRelList)
    },
    onFormChange(data) {
      if(data == undefined){
        this.formData.role_type = ""
        return
      }
      this.formData.role_type = data
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