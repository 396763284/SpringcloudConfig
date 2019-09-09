<template>
  <div class="dashboard-container">
    <div class="dashboard-text">name:{{name}}</div>
    <div class="dashboard-text">当前登录角色:{{current_role}}</div>
    <div class="dashboard-text">所有角色:<span v-for='role in roles' :key='role.role_code'>{{role}},</span></div>
    <div class="dashboard-text">当前权限:<span v-for='permission in perms' :key='permission'>{{permission}},</span></div>
   <div>
<a @click="download()">下载1</a>
   </div>
   
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { api_download } from "@/api/index";

export default {
  data() {
    return {
    }
  },
  computed: {
    ...mapGetters([
      'name',
      'current_role',
      'roles',
      'perms'
    ])
  },
  methods: {
    download() {
      api_download()
        .then(res => {
          console.log(res)
          if (window.navigator.msSaveOrOpenBlob) {
            // 兼容ie11
            var blobObject = new Blob([res], {
              type: "application/force-download"
            });
            window.navigator.msSaveOrOpenBlob(blobObject, fileName);
          } else {
            let url = URL.createObjectURL(
              new Blob([res], { type: "application/force-download" })
            );
            console.log(url)
            let a = document.createElement("a");
            document.body.appendChild(a); //此处增加了将创建的添加到body当中
            a.href = url;
            a.download = fileName;
            a.target = "_blank";
            a.click();
            a.remove(); //将a标签移除
          }
        })
        .catch(() => {
          this.$message({ message: "下载失败", type: "error" });
        });
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
