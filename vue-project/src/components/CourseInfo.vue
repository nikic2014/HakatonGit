<script setup>
import { useRoute } from 'vue-router'
import Header from './Header.vue'
import TaskList from './TaskList.vue'

const route = useRoute()
const title = route.query.title
</script>

<template>
  <div>
    <Header />

    <body>
      <div class="border-t-2 border-gray-200 drop-shadow-md p-10">
        <div class="flex justify-between">
          <h2 class="text-3xl font-bold mb-8 text-cyan-900">{{ title }}</h2>
        </div>
        <TaskList />
      </div>
    </body>
  </div>
</template>

<style scoped>
body {
  background-color: rgb(229, 253, 255);
}
</style>
