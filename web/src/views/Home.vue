<template>
    <a-layout>
        <a-layout-sider width="200" style="background: #fff">
          <a-menu
            v-model:selectedKeys="selectedKeys2"
            v-model:openKeys="openKeys"
            mode="inline"
            :style="{ height: '100%', borderRight: 0 }"
          >
            <a-sub-menu key="sub1">
              <template #title>
                <span>
                  <user-outlined />
                  subnav 111
                </span>
              </template>
              <a-menu-item key="1">option1</a-menu-item>
              <a-menu-item key="2">option2</a-menu-item>
              <a-menu-item key="3">option3</a-menu-item>
              <a-menu-item key="4">option4</a-menu-item>
            </a-sub-menu>
            <a-sub-menu key="sub2">
              <template #title>
                <span>
                  <laptop-outlined />
                  subnav 2
                </span>
              </template>
              <a-menu-item key="5">option5</a-menu-item>
              <a-menu-item key="6">option6</a-menu-item>
              <a-menu-item key="7">option7</a-menu-item>
              <a-menu-item key="8">option8</a-menu-item>
            </a-sub-menu>
            <a-sub-menu key="sub3">
              <template #title>
                <span>
                  <notification-outlined />
                  subnav 3
                </span>
              </template>
              <a-menu-item key="9">option9</a-menu-item>
              <a-menu-item key="10">option10</a-menu-item>
              <a-menu-item key="11">option11</a-menu-item>
              <a-menu-item key="12">option12</a-menu-item>
            </a-sub-menu>
          </a-menu>
        </a-layout-sider>

        <a-layout-content
            :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
          >
     <a-list item-layout="vertical" size="large" :data-source="ebook" :grid="{guttre: 20, column : 3}">
    <!-- <template #footer>
      <div>
        <b>ant design vue</b>
        footer part
      </div>
    </template> -->
    <template #renderItem="{ item }">
      <a-list-item key="item.name">
        <template #actions>
          <span v-for="{ type, text } in actions" :key="type">
            <component :is="type" style="margin-right: 8px" />
            {{ text }}
          </span>
        </template>
        <!-- <template #extra>
          <img
            width="272"
            alt="logo"
            src="https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png"
          />
        </template> -->
        <a-list-item-meta :description="item.description">
          <template #title>
            <a :href="item.href">{{ item.name }}</a>
          </template>
          <template #avatar><a-avatar :src="item.cover" /></template>
        </a-list-item-meta>
        <!-- {{ item.content }} -->
      </a-list-item>
    </template>
  </a-list>
            
        </a-layout-content>
    </a-layout>
</template>

<script lang="ts">
import { defineComponent,onMounted,ref } from 'vue';
import HelloWorld from '@/components/HelloWorld.vue'; 
import axios from 'axios'// @ is an alias to /src



export default defineComponent({
  name: 'Home',
  setup(){
   //响应式数据
   const ebook = ref();

    onMounted(() => {
      console.log('Home mounted')
       axios.get('http://localhost:8081/ebook/list',{
        params: {
        page: 1,
        size: 1000
        }
       }).then(res => {
        const data =  res.data;
        ebook.value = data.content.list;

    });
    })

    return{
      ebook,
      pagination:{
          onChange: (page: number) => {
          console.log(page);
        },
      pageSize: 3,
      },

      actions: [
      { type: 'StarOutlined', text: '156' },
      { type: 'LikeOutlined', text: '156' },
      { type: 'MessageOutlined', text: '2' },
      ],

    }
  },

  
  
  

});


</script>

 //本css只在本组件中生效
<style scoped>
 
.ant-avatar {
    width : 50px;
    height : 50px;
    border-radius : 10%;
    line-height : 50px;
    margin : 5px 0;
}
  
</style>
