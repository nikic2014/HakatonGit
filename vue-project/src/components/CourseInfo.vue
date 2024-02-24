<script setup>
import Header from './Header.vue'
import TaskList from './TaskList.vue'
</script>

<template>
  <div>
    <Header />

    <body class="border-b-2 border-black">
      <div class="p-10">
        <div class="flex justify-between">
          <h2 class="text-3xl font-bold mb-8">Курс 1</h2>
        </div>
        <TaskList />
      </div>
    </body>
  </div>
</template>
