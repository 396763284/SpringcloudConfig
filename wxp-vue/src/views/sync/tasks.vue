<!--  -->
<template>
 <div  class="app-container">
     <el-form :inline="true" :model="query" class="query-form" size="mini">
            <el-form-item class="query-form-item">
                <el-input v-model="query.sync_name" placeholder="任务名"></el-input>
            </el-form-item>
            <el-form-item class="query-form-item">
                <el-select v-model="query.status" placeholder="状态">
                    <el-option label="全部" value=""></el-option>
                    <el-option label="禁用" value="1300"></el-option>
                    <el-option label="正常" value="1000"></el-option>
                </el-select>
            </el-form-item>
           
            <el-form-item>
                <el-button-group>
                    <el-button type="primary" icon="search" @click="onSubmit" v-has="'sync:tasks:add'">查询</el-button>
                    <el-button type="primary" icon="el-icon-refresh" @click="onReset"></el-button>
                </el-button-group>
            </el-form-item>
        </el-form>
       
        <el-table
            v-loading="loading"
            :data="list"
            style="width: 100%;"
            max-height="500">
            <el-table-column
                label="同步任务ID"
                prop="sync_id"
                fixed>
            </el-table-column>
             <el-table-column
                label="任务名称"
                prop="sync_name"
                fixed>
            </el-table-column>
             <el-table-column
                label="来源表"
                prop="from_table_name"
                fixed>
            </el-table-column>
             <el-table-column
                label="流向表"
                prop="to_table_name"
                fixed>
            </el-table-column>
            <el-table-column
                label="操作"
                fixed="right">
                <template slot-scope="scope">
                    <el-button type="text" size="small" @click.native="handleForm(scope.$index, scope.row)">编辑
                    </el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-pagination
            :page-size="query.limit"
            @current-change="handleCurrentChange"
            layout="prev, pager, next"
            :total="total">
        </el-pagination>


       
    </div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';

import {
    taskLists
} from "@/api/sync/sync";
const formJson = {
    id: "",
    password: "",
    username: "",
    checkPassword: "",
    status: 1,
    roles: []
};
export default {
    data() {
        
        return {
            query: {
                username: "wxpwxp",
                status: "",
                page: 1,
                limit: 20,
                role_id: ""
            },
            list: [],
            total: 0,
            loading: true,
            index: null,
            formName: null,
            formMap: {
                add: "新增",
                edit: "编辑"
            },
            formLoading: false,
            formVisible: false,
            formData: formJson,
            formRules: {},
            deleteLoading: false
        };
    },
    methods: {
        onSubmit(){

        },
        onReset() {
            this.$router.push({
                path: ""
            });
            this.query = {
                username: "wwww",
                status: "",
                page: 1,
                limit: 20
            };
            this.getList();
        },
        handleCurrentChange(val) {
            this.query.page = val;
            this.getList();
        },
        getList() {
            this.loading = true;
            taskLists(this.query)
                .then(data => {
                    this.loading = false;
                    console.log(data)
                     this.list = data.data || [];
                     this.total = data.totalCount || 0;
                })
                .catch(() => {
                    this.loading = false;
                    this.list = [];
                    this.total = 0;
                    this.roles = [];
                });
        },
        // 刷新表单
        resetForm() {
            if (this.$refs["dataForm"]) {
                // 清空验证信息表单
                this.$refs["dataForm"].clearValidate();
                // 刷新表单
                this.$refs["dataForm"].resetFields();
            }
        },
        // 隐藏表单
        hideForm() {
            // 更改值
            this.formVisible = !this.formVisible;
            // 清空表单
            this.$refs["dataForm"].resetFields();
            return true;
        },
        // 显示表单
        handleForm(index, row) {
            this.formVisible = true;
            this.formData = JSON.parse(JSON.stringify(formJson));
            if (row !== null) {
                this.formData = Object.assign({}, row);
            }
            this.formName = "add";
            this.formRules = this.addRules;
            if (index !== null) {
                this.index = index;
                this.formName = "edit";
                this.formRules = this.editRules;
            }
        },

    },
    filters: {
        
    },
    mounted() {},
    created() {
        // 将参数拷贝进查询对象
        let query = this.$route.query;
        this.query = Object.assign(this.query, query);
        this.query.limit = parseInt(this.query.limit);
        // 加载表格数据
        this.getList();
        
    }
};
</script>
<style lang='scss' scoped>
//@import url(); 引入公共css类

</style>