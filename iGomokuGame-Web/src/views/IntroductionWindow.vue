<script setup>
// 介绍页面，网站首页
import { ref, onBeforeMount } from 'vue'
import { login, register } from '@/api/account.js'
import { useUserIderStore } from '@/stores/userIder'
import { useShowingFrienderStore } from '@/stores/showingFriender'
import router from '@/router'
import { getUnreadMessageObj } from '@/api/friend'
import { ElMessage } from 'element-plus'
import { addWebsiteClick } from '@/api/admin/analysis.js'
onBeforeMount(() => {
  // 进来首先发个请求统计网站流量
  addWebsiteClick()
})

const loginDialogVisible = ref(false)
const userIderStore = useUserIderStore()
const showingFrienderStore = useShowingFrienderStore()
const status = ref(true) // true 为Sign in，false 为Sign up
const usernameInp = ref(null)
const passwordInp = ref(null)
const form = ref({
  username: '',
  password: ''
})
const openDialog = () => {
  loginDialogVisible.value = true
  form.value.username = ''
  form.value.password = ''
}
const onSubmit = async () => {
  if (form.value.username == '') {
    ElMessage.error('User Name不能为空')
    return
  }
  if (form.value.password == '') {
    ElMessage.error('Password不能为空')
    return
  }
  // console.log(form.value)

  if (!status.value) {
    // 请求Sign up
    await register(form.value)
    // Sign up成功
  }
  // 请求Sign in
  var res = await login(form.value)
  // Sign in成功
  ElMessage.success('Sign in成功')
  loginDialogVisible.value = false // 关闭弹窗
  // 存储用户信息
  userIderStore.setLoginForm(form.value)
  userIderStore.setUserInfo(res.data)
  // 创建聊天的连接
  userIderStore.getChatSocket()
  res = await getUnreadMessageObj()
  showingFrienderStore.setUnreadMessageObj(res.data)
  console.log('unreadMessageObj', showingFrienderStore.unreadMessageObj)
  router.push('/main')
}

const pressUsername = (event) => {
  if (event.key == 'ArrowDown' || event.key == 'Enter') passwordInp.value.focus()
}
const pressPassword = (event) => {
  if (event.key == 'ArrowUp') usernameInp.value.focus()
  else if (event.key == 'Enter') onSubmit()
}
</script>

<template>
  <!-- 菜单 -->
  <el-menu
    style="width: 100%"
    class="menu"
    mode="horizontal"
    :unique-opened="true"
    :ellipsis="false"
  >
    <div style="flex-grow: 1"></div>

    <div style="font-size: 30px; text-align: center; padding-top: 1%">
      <p>Distributed Gomoku</p>

  </div>

    <!-- Sign in/个人信息按钮 -->
    <el-menu-item>
      <!-- Sign in按钮 -->
      <span>
        <el-button style="margin-bottom: 15px" size="large" link @click="openDialog">
          Sign in
        </el-button>
        <!-- Sign in对话框 -->
        <el-dialog v-model="loginDialogVisible" width="30%">
          <div style="max-width: 600px">
            <h1 style="text-align: center">{{ status ? 'Sign in' : 'Sign up' }}</h1>
            <el-form :model="form" label-width="120px">
              <el-form-item label="User Name">
                <el-input
                  ref="usernameInp"
                  @keydown="pressUsername"
                  v-model="form.username"
                  :placeholder="status ? 'Please enterUser Name' : '设置新User Name'"
                />
              </el-form-item>

              <el-form-item label="Password">
                <el-input
                  ref="passwordInp"
                  @keydown="pressPassword"
                  v-model="form.password"
                  type="password"
                  :placeholder="status ? 'Please enterPassword' : '设置新Password'"
                  show-password
                />
              </el-form-item>
              <div>
                <el-button
                  style="float: right"
                  size="small"
                  type="primary"
                  @click="status = !status"
                >
                  {{ status ? 'Sign up' : 'Sign in' }}
                </el-button>
              </div>

              <el-form-item>
                <el-button type="primary" @click="onSubmit">{{
                  status ? 'Sign in' : 'Sign up'
                }}</el-button>
                <el-button @click="loginDialogVisible = false">Cancel</el-button>
              </el-form-item>
            </el-form>
          </div>
        </el-dialog>
      </span>
    </el-menu-item>
  </el-menu>

  <div class="introduction">
    <div style="font-size: 80px; text-align: center; padding-top: 20%">
      <p> </p>
    </div>
  </div>
</template>
<style scoped>
.introduction {
  width: 100vw;
  height: 100vh;
  background-image: url(/img/user-login-bg.png);
  background-size: 100% 100%;
}

.menu {
  position: absolute;
  width: 100%;
  top: 0;
}

.name {
  font-size: 30px;
  text-align: right;
  margin-right: 50px;
  margin-top: 150px;
}
</style>
