import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
import * as Icons from '@ant-design/icons-vue'
import axios from 'axios';
const app = createApp(App);

app.use(store).use(router).use(Antd).mount('#app')


//全局使用icons


const icons : any = Icons;
for (const key in icons) {
  app.component(key, icons[key]);
}


/**
 * axios拦截器
 */
 axios.interceptors.request.use(function(config) {
    console.log("请求参数",config);
    return config;
 },error=>{
    console.log("请求错误",error);
    return Promise.reject(error);
 }  );


 axios.interceptors.request.use(function(response) {
  console.log("返回结果",response);
  return response;
},error=>{
  console.log("返回错误",error);
  return Promise.reject(error);
}  );

